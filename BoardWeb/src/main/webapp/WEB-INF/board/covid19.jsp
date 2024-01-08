<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="show">
		<table class="table">
			<thead>
				<tr>
					<th>센터id</th>
					<th>센터 타입</th>
					<th>센터명</th>
					<th>연락처</th>
					<th>시도정보</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>
	</div>

	<script>
		const url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=20&serviceKey=wGeRjL%2BtGwvh%2FIhIPwMsjf9W5l3Xkgh9EoOlYwuZd1ecTrXJ6RiB9o5aHl9rYYy1O3F%2Fvld25TGvbhC8KkaJ2A%3D%3D';
		
		const fields = ['id', 'centerType', 'centerName', 'phoneNumber', 'sido', 'address']; // 화면에 보여줄 항목지정
		
		let tbody = document.getElementById("list");
		
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', url);
		xhtp.send();
		xhtp.onload = function () {
			console.log(JSON.parse(xhtp.responseText));
			let result = JSON.parse(xhtp.responseText);
			// tr > td * 4
			result.data.forEach(item => {
				console.log(item.org);
				let trTag = document.createElement('tr');
				trTag.addEventListener('click', function(){
					// location.href = 'map.do?x='+item.lat+'&y='+item.lng; // 현재창에서 지도열기
					window.open("map.do?x="+item.lat+"&y="+item.lng+"&name="+item.org);
				})
				fields.forEach(filed => {
					let tdTag = document.createElement('td');
					tdTag.innerHTML = item[filed];
					trTag.appendChild(tdTag);
				})
				tbody.appendChild(trTag);
				
			})
			
			
		}
	</script>
</body>
</html>