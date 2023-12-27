<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h3>등록화면</h3>
<!-- POST방식 method="post" :  enctype="x-www-form-urlencoded" -->
<form action="addBoard.do" method="post" enctype="multipart/form-data">
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
			  <td><input type="text" name="writer" readonly value="${logName }"></td>
			<!-- 홍길동을 로그인한 사람명으로 작성자를 바꿔보기 -->
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="image"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장">
				<input type="reset" value="초기화">
			</td>
		</tr>
	</table>
</form>