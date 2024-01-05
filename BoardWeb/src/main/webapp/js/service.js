/**
 * service.js
 */
function makeLi(reply = {}){
	// console.log(reply); // {replyNo: 1, boardNo: 1, reply: 'test'}
	console.log(reply);
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
	btn.addEventListener('click', function(){
		// 댓글번호 삭제 후(DB) -> 화면에서 제거(jsp)
		let delHtp = new XMLHttpRequest();
		delHtp.open('get', 'delReplyJson.do?rno='+reply.replyNo);
		delHtp.send();
		delHtp.onload = function() {
			let result = JSON.parse(delHtp.responseText);
			if(result.retCode == 'OK'){
				btn.parentElement.remove();
				alert('삭제됨.');
			} else if(result.retCode == 'NG'){
				alert('처리중 에러.');
			}
		}
	})
	btn.innerText = '삭제';
	li.appendChild(btn);
	
	return li;
}