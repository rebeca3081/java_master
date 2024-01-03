// class2.js

// let year = 2024;
// let month = 2;

// // 날짜 객체 / {} new Object()
// let today = new Date(year, month - 1, 1); // 5월달의 첫날
// today = new Date(year, month, 0); // 5월달의 마지막날
/*
console.log(today.getFullYear());
console.log(today.getMonth() + 1); // 1월-> 0, 2월-> 1 ...
console.log(today.getDate()); // 날짜
console.log(today.getDay()); // 요일
*/

let year = 2024;
let month = 12;

class Calendar {
  constructor(year, month) { // 생성자
    this.year = year;
    this.month = month;
  }

  days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']; // 필드
  
  makeCalendar() { // 메소드
    this.makeTitle(document.querySelector('#theader'));
    this.makeBody(document.getElementById('tbody'));
  }
  
  makeTitle(pos) { // 메소드
    let tr = document.createElement('tr');
    this.days.forEach(function (day) {
      let th = document.createElement('th');
      th.innerText = day;
      tr.appendChild(th);
    })
    pos.appendChild(tr);
  }

  makeBody(pos = {}) { // 메소드
    let tr = document.createElement('tr');
    // 공백
    let firstDay = this.getFirstDay();
    for (let i = 0; i < firstDay; i++) {
      let td = document.createElement('td');
      td.innerText = '';
      tr.appendChild(td);
    }
    // 날짜
    let lastDate = this.getLastDate();
    for (let i = 1; i <= lastDate; i++) {
      let td = document.createElement('td');
      td.innerText = i;

      // console.log((firstDay + i) % 7);
      // td 속성추가(토요일 : aqua, 일요일 : pink)
      if ((firstDay + i) % 7 == 0) { // 토요일
        td.setAttribute('style', "background-color:aqua; font-weight:bold;");
      } else if ((firstDay + i - 1) % 7 == 0) { // 일요일 (firstDay + i) % 7 == 1
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
  }

  getFirstDay() { // 메소드
    // 요일에 따라 => 1일의 위치 (공백이 몇개인지 반환)// 
    return new Date(this.year, this.month - 1, 1).getDay(); //(1일)첫째 날 들고오기
  } // end of getFirstDay

  getLastDate() { // 메소드
    return new Date(this.year, this.month, 0).getDate(); // 마지막 날 들고오기
  } // end of getLastDate

} // end of class
const cal = new Calendar(year, month);
cal.makeCalendar();

