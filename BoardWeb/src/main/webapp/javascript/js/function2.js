// function2.js
let members = `[{"id":1,"first_name":"Sela","last_name":"MacPake","email":"smacpake0@who.int","gender":"Female","salary":9010},
{"id":2,"first_name":"Fabien","last_name":"Van Geffen","email":"fvangeffen1@hc360.com","gender":"Male","salary":2062},
{"id":3,"first_name":"Shayne","last_name":"Giffkins","email":"sgiffkins2@ehow.com","gender":"Male","salary":9801},
{"id":4,"first_name":"Barrett","last_name":"Cleynman","email":"bcleynman3@webnode.com","gender":"Male","salary":1288},
{"id":5,"first_name":"Tessi","last_name":"Tourot","email":"ttourot4@independent.co.uk","gender":"Female","salary":7892},
{"id":6,"first_name":"Delbert","last_name":"Bellson","email":"dbellson5@cnet.com","gender":"Male","salary":539},
{"id":7,"first_name":"Lindy","last_name":"Carter","email":"lcarter6@walmart.com","gender":"Male","salary":7795},
{"id":8,"first_name":"Aime","last_name":"Manz","email":"amanz7@engadget.com","gender":"Female","salary":7833},
{"id":9,"first_name":"Bunny","last_name":"Orgel","email":"borgel8@sfgate.com","gender":"Female","salary":8981},
{"id":10,"first_name":"Killie","last_name":"Simione","email":"ksimione9@themeforest.net","gender":"Male","salary":9449},
{"id":11,"first_name":"Tatiania","last_name":"Slym","email":"tslyma@guardian.co.uk","gender":"Female","salary":1639},
{"id":12,"first_name":"Rufus","last_name":"Crackett","email":"rcrackettb@wikispaces.com","gender":"Male","salary":6268},
{"id":13,"first_name":"Joyan","last_name":"Starkings","email":"jstarkingsc@wikimedia.org","gender":"Female","salary":9330},
{"id":14,"first_name":"Tad","last_name":"Kun","email":"tkund@sogou.com","gender":"Male","salary":2177},
{"id":15,"first_name":"Kirsteni","last_name":"Fealey","email":"kfealeye@thetimes.co.uk","gender":"Female","salary":9197}]`;

let memberAry = JSON.parse(members); // 문자열 -> 객체 타입으로 변환.

// console.log(members);
// console.log(memberAry);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여'];

function makeHeader(fields = [], pos = {}) {
  let tr = document.createElement('tr');
  fields.forEach(function (field) {
    let th = document.createElement('th');
    th.innerText = field;
    tr.appendChild(th);
  })
  pos.appendChild(tr);
}

makeHeader(titles, document.getElementById('theader'));

function makeBody(data = [], pos = {}) {
  data.forEach(function (members) {
    let tr = document.createElement('tr');
    if (members.gender == 'Male') {
      tr.setAttribute('style', "background-color:lightblue;");
    } else {
      tr.setAttribute('style', "background-color:lightpink;");
    }
    for (let prop in members) {
      let td = document.createElement('td');
      td.innerText = members[prop];
      tr.appendChild(td);
    }
    pos.appendChild(tr);
  })
}

makeBody(memberAry, document.getElementById('tbody'));
