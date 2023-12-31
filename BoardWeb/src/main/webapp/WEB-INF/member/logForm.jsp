<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${message != null }">
	<p>${message }</p>
</c:if>

<h3>로그인 화면</h3>
<form action="login.do" method="post">
	<table class="table">
		<tbody>
			<tr>
				<th colspan="2">로그인</th>
				<td></td>
			</tr>
			<tr>
				<th colspan="2">아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th colspan="2">비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="로그인" class="btn btn-primary">
					<input type="reset" value="초기화" class="btn btn-warning">
				</td>
			</tr>
		</tbody>
	</table>
</form>