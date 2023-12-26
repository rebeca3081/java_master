<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/menu.jsp"%>
<%@ include file="../layout/nav.jsp"%>
<h3>상세화면</h3>
<%
BoardVO vo = (BoardVO) request.getAttribute("vo");
%>
<form name="myForm" action="modifyForm.do">
	<!-- 화면에는 보이지 않지만 값을 넘길 때 type="hidden" -->
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
	<table border="1" class="table">
		<tbody>
			<tr>
				<td>글번호</td>
				<td colspan="3"><%=vo.getBoardNo()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%=vo.getTitle()%></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><%=vo.getContent()%></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3"><%=vo.getWriter()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=vo.getWriteDate()%></td>
				<td>조회수</td>
				<td><%=vo.getClickCnt()%></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="수정">
					<input type="button" onclick="deleteFun()" value="삭제"></td>
			</tr>
		</tbody>
	</table>
</form>
<br>
<a href="boardList.do">글목록이동</a>
<script>
	function deleteFun() {
		console.log(window);
		document.forms.myForm.action = "removeForm.do";
		document.forms.myForm.submit();
	}
</script>
<%@ include file="../layout/foot.jsp"%>