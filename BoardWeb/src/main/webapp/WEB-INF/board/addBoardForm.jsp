<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/menu.jsp"%>
<%@ include file="../layout/nav.jsp"%>

<%
	logName = (String) session.getAttribute("logName");
%>

	<h3>등록화면</h3>
	<form action = "addBoard.do">
		<table border="1" class="table">
			<tr>
                <th>제목</th>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="content" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <th>작성자</th>
                <%if(logName == null){ %>
                <td><input type="text" name="writer"></td>
                <%} else{ %>
                <td><input type="text" name="writer" value="<%=logName %>"></td>
                <%} %>
                <!-- 홍길동을 로그인한 사람명으로 작성자를 바꿔보기 -->
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="저장">
                    <input type="reset" value="초기화">
                </td>
            </tr>
		</table>
	</form>
<%@ include file="../layout/foot.jsp"%>