<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../layout/menu.jsp"%>
<%@ include file="../layout/nav.jsp"%>

<h3>수정화면</h3>
<form action="modifyBoard.do">
<!-- 화면에는 보이지 않지만 값을 넘길 때 type="hidden" -->
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
				<td colspan="3">
					<textarea cols="30" rows="4" name="content">${vo.content}</textarea>
				</td>
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
					<input type="submit" value="저장">
					<input type="reset" value="취소">
				</td>
			</tr>
		</tbody>
	</table>
</form>
<%@ include file="../layout/foot.jsp"%>