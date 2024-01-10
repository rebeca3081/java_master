/**
 * member.js
 */
$(document).ready(function () {
	// 회원목록 출력.
	$.ajax('memberListJson.do', {
		method: 'get', // 서버 요청 방식
		// data: {bno: 1, rno: 2} // 'bno=1&rno=2' 서버에 데이터 전송
		dataType: 'json', // 서버의 데이터 포맷을 지정 == JSON.parse(result)
		success: function (result) { // 서버로 부터 정상적으로 데이터를 가져오면 result에 값이 담겨있음
			// console.log(result);
			
			// tr생성, td생성.
			$(result).each((idx, member) => { // each(idx, member) == // forEach
			// console.log(idx, member);
			// console.log(member);
			console.log(member.image)
				let img = '';
				if(member.image){ // image 값이 없으면 undefined -> false
					img = $('<img />').attr({'src':'images/'+member.image, 'style': 'width:100px'})
				}
				let tr = $('<tr />').append($('<td />').text(member.id), 
											$('<td />').text(member.name),
											$('<td />').text(member.responsibility),
											$('<td />').html(img)
									);
			$('#list').append(tr);
			}); 
		},
		error: function (err) { // 에러가 나면
			console.log(err);
		}
		
	})
	
	// 회원등록
	$('#addBtn').on('click', function () {
		let formData = new FormData(); // multipart/form-data : 의 형태로 전송해주는 메소드
		formData.append('id', $('input[name="id"]').val());
		formData.append('pw', $('input[name="pw"]').val());
		formData.append('name', $('input[name="name"]').val());
		formData.append('image', $('input[name="image"]')[0].files[0]);
		
		for(let ent of formData.entries()){
			console.log(ent);
		}
		$.ajax('memberAddJson.do', {
			method: 'post',
			data: formData,
			processData: false,
			contentType: false,
			dataType: 'json',
			success: function (result) {
				console.log(result); // retCode, vo
				let img = '';
				if(result.vo.image) { // image 값이 없으면 undefined -> false
					img = $('<img />').attr({'src':'images/'+result.vo.image, 'style': 'width:100px'})
				}
				if(result.retCode == 'OK') {
					let tr = $('<tr />').append($('<td />').text(result.vo.id),
												$('<td />').text(result.vo.name),
												$('<td />').text(result.vo.responsibility),
												$('<td />').html(img)
										);
					$('#list').append(tr);
				}
				
			},
			error: function (err) {
			console.log(err);
			}
		})
	})
	
	
	
	
}) // end of jquery