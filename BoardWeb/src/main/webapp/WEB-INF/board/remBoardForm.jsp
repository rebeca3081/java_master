<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../layout/menu.jsp"%>
<%@ include file="../layout/nav.jsp"%>

<h3>삭제화면</h3>
<h4>'삭제'버튼 클릭 시 삭제완료됩니다.</h4>
<form name="myForm" action="removeBoard.do">
<input type="hidden" name="bno" value="${vo.boardNo}">
	<table border="1" class="table">
		<tbody>
			<tr>
				<td>글번호</td>
				<td colspan="3">${vo.boardNo}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${vo.title}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${vo.content}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3">${vo.writer}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.writeDate}" /></td>
				<td>조회수</td>
				<td>${vo.clickCnt}</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="삭제">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</tbody>
	</table>
</form>
<br>
<a href="boardList.do">글목록이동</a>
<%@ include file="../layout/foot.jsp"%>