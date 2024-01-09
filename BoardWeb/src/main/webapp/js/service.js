/**
 * service.js
 */
function makeLi(reply = {}) {
	// console.log(reply); // {replyNo: 1, boardNo: 1, reply: 'test'}
	// console.log(reply);
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호: ' + reply.replyNo;
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = ' ' + reply.reply;
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = ' ' + reply.name;
	li.appendChild(span);

	// 삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() {
		
		// fetch함수 (댓글삭제) + async / await -> 순차적으로 한라인씩 처리하겠습니다 구문
		const promise =  await fetch('delReplyJson.do?rno=' + reply.replyNo)
		const json = await promise.json();
		console.log(json);
		try{
			if (json.retCode == 'OK') {
				showList(pageInfo);
				alert('삭제됨.');
			} else if (json.retCode == 'NG') {
				alert('처리중 에러.');
			}
		} catch (err) {
			console.log('예외=>',err);
		}
		
		/* 
		// Ajax : 댓글번호 삭제 후(DB) -> 화면에서 제거(jsp)
		let delHtp = new XMLHttpRequest();
		delHtp.open('get', 'delReplyJson.do?rno='+reply.replyNo);
		delHtp.send();
		delHtp.onload = function() {
			let result = JSON.parse(delHtp.responseText);
			if(result.retCode == 'OK'){
				// btn.parentElement.remove(); // 화면에서 삭제
				// 게시글 번호 bno, 페이지 정보 page => 페이지리스트(목록데이터), 페이징리스트(번호) 
				showList(pageInfo);
				alert('삭제됨.');
			} else if(result.retCode == 'NG'){
				alert('처리중 에러.');
			}
		}
		*/
	}, false) // 이벤트 옵션 객체 -> 기본값,버블링: 하위에서 ~ 상위요소로 이벤트 전파됨
	btn.innerText = '삭제';
	li.appendChild(btn);

	return li;
}// end of makeLi()