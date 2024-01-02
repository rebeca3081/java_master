// calendar.js

let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];

let lastDate = getLastDate(1);
let firstDay = getFirstDay(1);
console.log(lastDate, firstDay);

// 달력생성
makeCalendar(3);

function makeCalendar(month) {
  makeTitle(days, document.querySelector('#theader')); // 요일 생성
  makeBody(month, document.querySelector('#tbody'));
}

function getLastDate(month) {
  // 월 입력 => 마지막날을 반환. 1월->31일 2월->29일, 3월->31일
  if (month == 4 | month == 6 | month == 9 | month == 11) {
    return 30;
  } else if (month == 2) {
    return 29;
  } else {
    return 31;
  }
}

function getFirstDay(month) {
  // 월 입력 => 1일의 위치(공백이 몇개인지 반환)
  switch (month) {
    case 1:
      return 1;
    case 2:
      return 4;
    case 3:
      return 5;
  }
}

// header 부분 생성해주는 함수
function makeTitle(dayAry = [], pos = {}) {
  let tr = document.createElement('tr');
  dayAry.forEach(function (day) {
    let th = document.createElement('th');
    th.innerText = day;
    tr.appendChild(th);
  })
  pos.appendChild(tr);
  // console.log(pos); // <thead>...</thead> (#theader)
}

// 날짜생성 : tbody 부분 생성 함수
function makeBody(month = 0, pos = {}) {
  let tr = document.createElement('tr');
  // 공백
  let firstDay = getFirstDay(month);
  for (let i = 0; i < firstDay; i++) {
    let td = document.createElement('td');
    td.innerText = '';
    tr.appendChild(td);
  }
  // 날짜
  let lastDate = getLastDate(month);
  for (let i = 1; i <= lastDate; i++) {
    let td = document.createElement('td');
    td.innerText = i;

    // td 속성추가(토요일 : aqua, 일요일 : pink)
    if((firstDay + i) % 7 == 0){ // 토요일
      td.setAttribute('style', "background-color:aqua; font-weight:bold;");
    }else if ((firstDay + i - 1) % 7 == 0) { // 일요일 firstDay + i) % 7 == 1
      td.setAttribute('style', "background-color:pink; font-weight:bold;");
    }

    tr.appendChild(td);

    // 공백수 + 날짜 = 7의 배수이면 이미 만들어진 tr태그는 붙이고 새로운 tr을 만들어줌
    if ((firstDay + i) % 7 == 0) {
      pos.appendChild(tr);
      tr = document.createElement('tr');
    } 
  }
  pos.appendChild(tr);
  // console.log(pos); // <tbody>...</tbody> (#tbody)
}