<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>책목록</h3>
	<table border="1">
		<thead>
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
	</table>
	<!-- DB에서 가져와서 목록출력 -->
	<!-- Ajax -->
	<script>
		const heads = ['bookCode', 'bookName', 'bookAuthor', 'bookPress', 'bookPrice'];
		const xhtp = new XMLHttpRequest();
	    xhtp.open('get', 'bookListJson.do');
	    xhtp.send();
	    xhtp.onload = function() {
	  	  let result = JSON.parse(xhtp.responseText);
	  	  console.log(result);
	  	  
	  	  result.forEach(books => {
	  		//console.log(books.bookCode);
	  		
	  		let tr = document.createElement('tr');
	  		heads.forEach(head => {
	  			let td = document.createElement('td');
		  		td.innerText = books[head];
		  	  	tr.appendChild(td);
	  		})
	  		document.querySelector('#list').appendChild(tr);
	  		
	  	  })
	  	  
	    }
	    
	    
	
		
		/*
		fetch('bookList.do', {
			method: 'get',
			headers: {
				'Content-type': 'json'
			}
		})
		.then(result => {
			console.log(result.json());
		})
		*/
	
	</script>
	
</body>
</html>