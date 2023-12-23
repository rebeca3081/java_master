<%@page import="java.util.List"%>
<%@page import="com.yedam.student.vo.Student"%>
<%@page import="com.yedam.student.mapper.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.html</title>
</head>
<body>

	<table border='1'>
		<thead>
			<tr><th>학번</th><th>이름</th><th>영어</th><th>수학</th></tr>
		</thead>
		<tbody>
		<!-- Java code 영역 -->
		<%
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.getStudentList();
	
			for (Student std : list) {
		%>
		<tr>
			<td><a href='studentInfo.jsp?sno=<%=std.getStudentNo ()%>'><%=std.getStudentNo() %></a></td>
			<td><%=std.getStudentName() %></td>
			<td><%=std.getScoreEng() %></td>
			<td><%=std.getScoreMath() %></td>

		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
</body>
</html>