<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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
	// Ajax 호출. : DB처리, 화면처리
	const xhtp = new XMLHttpRequest();
	xhtp.open('get', 'replyListJson.do?bno='+bno);
	xhtp.send(); // 데이터 요청
	xhtp.onload = function () {
		console.log(xhtp.responseText);
		console.log(xhtp);
		let data = JSON.parse(xhtp.responseText); // JSON 문자열 -> Javascript 객체로 변환
		data.forEach(reply => {
			let li = makeLi(reply);			
			ul.appendChild(li);
		})
		//console.log(xhtp.responseText);
	}
	
	// 등록버튼 클릭 이벤트 생성.
	// document.querySelector('#addReply').addEventListener('click', function() {});
	
	document.querySelector('#addReply').onclick = function() {
		let reply = document.querySelector('#content').value;
		let replyer = '${logId }';
		
		const addAjax = new XMLHttpRequest();
		addAjax.open('get', 'addReplyJson.do?reply='+reply+'&replyer='+replyer+'&bno='+bno);
		addAjax.send();
		addAjax.onload = function () {
			console.log(addAjax.responseText);
			let result = JSON.parse(addAjax.responseText);
			if(result.retCode == 'OK'){
				alert('댓글등록됨.');
				let reply = result.vo
				let li = makeLi(reply); // 함수생성부분
				ul.appendChild(li);
				
				document.querySelector('#content').value = '';
			} else if(result.retCode == 'NG'){
				alert('처리중 에러.');
			}
		}
		// console.log(reply, replyer);
	}
	
	
</script>