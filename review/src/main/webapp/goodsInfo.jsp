<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsInfo.jsp</title>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

</head>
<body>
	<h1>상품상세</h1>
	${book }
	
	<h1>리뷰등록</h1>
	<!-- 일반 form -->
	<form action="reviewAddServ">
		<input name="content" value="리뷰1">
		<input name="username" value="길동">
		<button>등록</button>
	</form>
	
	<!-- ajax 요청 -->
	<form id="ajaxForm">
		<input name="content" value="리뷰1">
		<input name="username" value="길동">
		<button type="button" id="btnAdd">ajax등록</button>
	</form>
	
	<h2>리뷰리스트</h2>
	<div id="reviewList">
		${review }
	</div>
	
	
	<script>
		btnAdd.addEventListener('click', function() {
			let username = ajaxForm.querySelector('[name="username"]').value;
			let content = document.querySelectorAll('[name="content"]')[1].value;
			let param = `name=\${username}&content=\${content}`;
			// $('#ajaxForm').serialize()
			
			
			/*// Ajax
			// fetch('reviewAddAjaxServ?' + param); // GET 방식
			fetch('reviewAddAjaxServ?' + param)
			.then(result => result.text()) // 응답(response) 결과가 들어옴
			.then(result => console.log(result))
			*/
			
			// POST 방식
			let formData = new FormData(ajaxForm);
			fetch('reviewAddAjaxServ', {
				method: "post",
				headers: {
				      "Content-Type": "application/json",
				      // 'Content-Type': 'application/x-www-form-urlencoded',
				},
				body: JSON.stringify({username, content}) // Object -> String 으로
					 // $('#ajaxForm').serialize()
			})
			.then(result => result.json()) // 응답(response) 결과가 들어옴
			.then(result => console.log(result.retCode))
		})
	</script>
</body>
</html>