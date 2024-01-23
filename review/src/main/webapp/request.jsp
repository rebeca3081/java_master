<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.jsp</title>
</head>
<body>
	<!-- GET 방식 : 길이제한이 있음 -->
	<a href="ReqServ?name=kim&age=20">도서</a> 
	<!-- POST 방식 -->
	<form action="ReqServ" method="post">
		<input type="hidden" name="name" value="kim">
		<input type="hidden" name="age" value="20">
		<button type="submit">전송</button>
	</form>
</body>
</html>