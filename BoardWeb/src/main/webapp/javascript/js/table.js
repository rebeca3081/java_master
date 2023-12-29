// table 생성 start.
let table = document.createElement('table');
// table에 attribute 'border' 추가
table.setAttribute('border', '1');
table.setAttribute('id', 'list');
table.appendChild(makeHead()); // table > thead
// 결과 : table > thead > tr > th * 3
table.appendChild(makeBody()); // table > tbody
// 최종결과 : 
// table > thead > tr > th * 3
//       > tbody > tr * 3 > td * 3
// 문서에 출력하기
document.querySelector('body').appendChild(table);
// table 생성 end.

// 추가 버튼 클릭 이벤트.
document.getElementById('addBtn').addEventListener('click', function(){
  let id = document.getElementById('uid').value; // input 태그의 입력값 받아서 변수에 담기.
  let name = document.getElementById('uname').value;
  let phone = document.getElementById('uphone').value;

  // ! -> not, id에 값이 없으면 -> false
  if(!id || !name || !phone){
    alert('값을 입력하세요~!');
    return;
  }

  let obj = {id, name, phone}; // {id: id, name: name, phone: phone} // property : value
  document.querySelector('#list>tbody').appendChild(makeTr(obj));

  // 입력값 변수 초기화
  document.getElementById('uid').value = '';
  document.getElementById('uname').value = '';
  document.getElementById('uphone').value = '';
  document.getElementById('uid').focus();

});

// 변경 버튼 클릭 이벤트 등록.
document.querySelector("#editBtn").addEventListener('click', function(){
  // 찾을 값
  let findId = document.querySelector('#uid').value;
  let newName = document.querySelector('#uname').value;
  let newPhone = document.querySelector('#uphone').value;

  // 찾을 대상.
  let target = document.querySelectorAll('#list>tbody>tr');
  // console.log(target);
  //배열target의 요소 갯수만큼 함수(매개값으로 사용된 함수(요소, 인덱스, 배열))를 실행.
  target.forEach(function(item, idx, ary){ // 
    // console.log(item, idx, ary);
    let tr = item;
    if(tr.children[0].innerText == findId) {
      tr.children[2].innerText = newPhone; // 전화번호 변경
      tr.children[1].innerText = newName; // 이름변경
    }
  })
});

// 선택삭제 이벤트 시작.
document.querySelector("#delBtn").addEventListener('click', function(){
  document.querySelectorAll("#list>tbody>tr>td>input:checked").forEach(function(item, idx, ary){
    // console.log(item);
    // console.log(item.parentElement.parentElement);
    item.parentElement.parentElement.remove();
    
  })
});

// 함수_1 : thead 생성
function makeHead() {
  // thead 생성
  let thead = document.createElement('thead');
  // tr 생성
  let tr = document.createElement('tr');

  // th * 3
  for(let prop in obj1){
    let th = document.createElement('th');
    th.innerText = prop.toUpperCase();
    tr.appendChild(th);
  }
  // 삭제.
  let th = document.createElement('th');
  th.innerText = '삭제';
  tr.appendChild(th);

  // 선택 삭제.
  th = document.createElement('th');
  th.innerText = '선택삭제';
  tr.appendChild(th);

  thead.appendChild(tr); // thead > tr
  return thead;
}

// 함수_2 : tbody 생성
function makeBody(){
  // tbody 생성
  let tbody = document.createElement('tbody');

  // friends 배열에 담신 객체 수 만큼 tr 만들기
  for(let friend of friends){
    tbody.appendChild(makeTr(friend)); // tbody > tr
  }
  return tbody;
}

// 함수_3 : tr > td
// obj={} : 객체에 초기값 설정해줌
function makeTr(obj={}){
  let trb = document.createElement('tr'); // tr 생성
  // 텍스트 클릭 시 등록 테이블에 값 보여지는 기능
  trb.addEventListener('click', function(){
    console.log(this.children[0].innerText); // this.children -> HTMLCollection(4) [td, td, td, td]
    document.getElementById('uid').value = this.children[0].innerText;
    document.querySelector('#uname').value = this.children[1].innerText;
    document.getElementById('uphone').value = this.children[2].innerText;
  });

  // obj1 ~ 3에 담긴 데이터 td에 넣기 
  for(let prop in obj){
    let td = document.createElement('td'); // td 생성
    td.innerText = obj[prop];
    trb.appendChild(td);
  }

  // 삭제버튼 생성
  let td = document.createElement('td'); // td 생성
  let btn = document.createElement('button'); // 버튼생성
  // button 이벤트 등록.
  btn.addEventListener('click', function (e){ // 이벤트핸들러.
    e.stopPropagation(); // 상위요소로 이벤트 전파(버블링) 차단.
    console.log(this.parentElement.parentElement.remove());
    // this - 해당요소
    // .parentElement - 부모요소
  });
  btn.innerText = '삭제';
  td.appendChild(btn);
  trb.appendChild(td);

  // 삭제 체크박스 생성
  td = document.createElement('td');
  td.setAttribute('align', 'center');
  let check = document.createElement('input');
  check.addEventListener('click', function(e){
    e.stopPropagation(); // 상위요소로 이벤트 전파(버블링) 차단.
    console.log(e);
  })
  check.setAttribute('type' ,'checkbox');
  td.appendChild(check);
  trb.appendChild(td);

  return trb;
}


// 콘솔창에서 출력해서 확인하기
console.log(table);

