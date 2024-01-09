<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/javascript/promise.jsp</title>
</head>
<body>
	
	<div id="show">하이</div>

	<script>
		let show = document.getElementById('show');
		let cnt = 0;
		let interval = setInterval(() => { // setInterval() : 지연시간을 두고 무한반복
			const today = new Date();
			let hh = today.getHours();
			let mm = today.getMinutes();
			let ss = today.getSeconds();
			cnt++;
			
			if(cnt >= 20){
				clearInerval(interval); // 종료
			}
			
			show.innerHTML = hh + "시 " + mm + "분 " + ss +  "초 <br>";
		}, 1000);
	
		// Promise(function(정상호출시, 실패시){})
		const promise = new Promise(function(resolve, reject){
			
			setTimeout(function(){ // setTimeout() : 지연시간(ms단위)을 두고 한번 처리
				resolve('Success');
				// reject('Fail');
			}, 3000); 
		}); // Promise 상태 : pending(초기화) -> fullfilled(정상처리) -> rejected(비정상처리)
		promise.then(function(result) { // 정상처리 / then 여러개 가능
					console.log('then =>', result);
					return 'Ok';
				})
				.then(function (result) {
					console.log('second then =>', result);
				})
				.catch(function(err) { // 초기화, 비정상처리
					console.error('error =>', err);
				})
		
	</script>
</body>
</html>