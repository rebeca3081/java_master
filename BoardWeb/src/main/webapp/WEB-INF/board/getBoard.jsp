<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<h3>상세화면</h3>
<form name="myForm" action="modifyForm.do">
	<!-- 화면에는 보이지 않지만 값을 넘길 때 type="hidden" -->
	<input type="hidden" name="bno" value="${vo.boardNo }">
	<table border="1" class="table">
		<tbody>
			<tr>
				<td>글번호</td>
				<td colspan="3">${vo.boardNo }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${vo.title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${vo.content }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3">${vo.writer }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.writeDate }" /></td>
				<td>조회수</td>
				<td>${vo.clickCnt }</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td colspan="3">
					<c:if test="${!empty vo.image }">
					  <img width="150px" src="images/${vo.image }">
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
				  <c:choose>
				  	<c:when test="${logName eq vo.writer }">
					  <input type="submit" value="수정">
					  <input type="button" onclick="deleteFun()" value="삭제">
					</c:when>
					<c:otherwise>
					  <input type="submit" disabled value="수정">
					  <input type="button" disabled onclick="deleteFun()" value="삭제">
					</c:otherwise>
				  </c:choose>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<br>
<p>댓글내용 : <input type="text" id="content"> <button id="addReply">등록</button></p>
<div id="show">
	<h5>댓글목록</h5>
	<ul id="list">
	</ul>
</div>

<!-- 페이징 처리 -->
<div id="paging" class="pagination">
</div>
<br>
<a href="boardList.do">글목록이동</a>

<script src="js/service.js"></script>

<script>
	function deleteFun() {
		// console.log(window);
		document.forms.myForm.action = "removeForm.do";
		document.forms.myForm.submit();
	}
	const bno = ${vo.boardNo };
	let ul = document.querySelector('#list');
	
	// -- 페이징.
	// 페이지를 클릭하면 페이지의 데이터를 보여주도록.	
	let pageInfo = 1; // 전역변수
	function pageList(e){
		e.preventDefault(); // <a>의 기본기능을 차단
		pageInfo = this.getAttribute("href"); // 클릭할 때마다 href 속성에 페이지 정보를 담음 
		console.log(pageInfo);
		
		// 댓글목록(데이터)을 보여주는 함수호출(실제 값);
		showList(pageInfo); 
		
		// 페이지를 생성하는 함수를 호출.
		pagingList(pageInfo);
	}
	
	// 페이지 목록(데이터를 보여주는 부분)
	function showList(page) {
		ul.innerHTML = ''; // 댓글 목록 초기화
		// Ajax 호출. : DB처리, 화면처리
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyListJson.do?bno=' + bno + '&page=' + page);
		xhtp.send(); // 데이터 요청
		xhtp.onload = function () {
			let data = JSON.parse(xhtp.responseText); // JSON 문자열 -> Javascript 객체로 변환
			data.forEach(reply => {
				let li = makeLi(reply);			
				ul.appendChild(li);
			})
		}
	} // end of showList()
	showList(pageInfo); //  함수호출(실제 값);
	
	
	// Ajax : 페이지 생성.(화면에 출력)
	let paging = document.querySelector('#paging'); // <div id="paging">
	pagingList(); // 함수호출.
	
	function pagingList(page = 1) {
		// 다음 클릭 -> 다음페이지 기준으로 페이지 목록을 생성.
		paging.innerHTML = ''; // 기존 페이지 초기화
		
		let pagingAjax = new XMLHttpRequest();
		//.opne('방식', '페이지 정보')
		pagingAjax.open('get', 'pagingListJson.do?bno=' + bno + '&page=' + page);
		pagingAjax.send();
		pagingAjax.onload = function() {
			let result = JSON.parse(pagingAjax.responseText);
			console.log(result);
			// 이전 페이지(prev)
			if(result.prev) {
				let aTag = document.createElement('a');
				aTag.href = result.startPage - 1;
				aTag.innerText = '이전';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
			// 페이징 목록.(번호)
			for(let p = result.startPage; p <= result.lastPage; p++) {
				let aTag = document.createElement('a');
				if(p == page){
					aTag.setAttribute('class', 'active');
				}
				aTag.href = p; // 'href' 속성
				aTag.innerText = p;
				aTag.addEventListener('click', pageList); // 클릭이 발생 -> 콜백함수 호출
				paging.appendChild(aTag);
			}
			// 이후 페이지(next)
			if(result.next) {
				let aTag = document.createElement('a');
				aTag.href = result.lastPage + 1;
				aTag.innerText = '다음';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
				
			}
		} // end of onload
	} // end of pagingList()
	
	
	// 등록버튼 클릭 이벤트 생성.
	// document.querySelector('#addReply').addEventListener('click', function() {});
	
	document.querySelector('#addReply').onclick = function() {
		let reply = document.querySelector('#content').value;
		let replyer = '${logId }';
		
		const addAjax = new XMLHttpRequest();
		addAjax.open('get', 'addReplyJson.do?reply='+reply+'&replyer='+replyer+'&bno='+bno);
		addAjax.send();
		addAjax.onload = function () {
			// console.log(addAjax.responseText);
			let result = JSON.parse(addAjax.responseText);
			if(result.retCode == 'OK'){
				alert('댓글등록됨.');
				// let reply = result.vo
				// let li = makeLi(reply); // 함수생성부분
				//ul.appendChild(li);
				showList(pageInfo); // 등록시 내림차순으로 목록 보이기
				
				document.querySelector('#content').value = '';
			} else if(result.retCode == 'NG'){
				alert('처리중 에러.');
			}
		}
		// console.log(reply, replyer);
	}
	
	
</script>