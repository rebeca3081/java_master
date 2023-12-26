<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modBoardForm.jsp</title>
</head>
<body>
	<h3>수정화면</h3>
	<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
	%>
	<form action="modifyBoard.do">
	<!-- 화면에는 보이지 않지만 값을 넘길 때 type="hidden" -->
	<input type="hidden" name="bno" value="<%=vo.getBoardNo() %>">
		<table border="1">
			<tbody>
				<tr>
					<td>글번호</td>
					<td colspan="3"><%=vo.getBoardNo() %></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3"><%=vo.getTitle() %></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">
						<textarea cols="30" rows="4" name="content"><%=vo.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3"><%=vo.getWriter() %></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><%=vo.getWriteDate() %></td>
					<td>조회수</td>
					<td><%=vo.getClickCnt() %></td>
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
</body>
</html>