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
${logName } vs ${vo.writer }
<br>
<a href="boardList.do">글목록이동</a>
<script>
	function deleteFun() {
		console.log(window);
		document.forms.myForm.action = "removeForm.do";
		document.forms.myForm.submit();
	}
</script>