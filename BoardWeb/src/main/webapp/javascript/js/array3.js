// array3.js
import {
  members,
  titles
} from './data.js';

console.log(members);
console.log(titles);

let str = titles.reduce((acc, title, idx) => {
  if (idx == 0) {
    acc += '<tr>';
  }
  acc += '<th>' + title + '</th>';
  if (idx == title.length - 1) {
    acc += '</tr>';
  }
  return acc;
}, '');
console.log(str);
document.getElementById('theader').innerHTML = str; // <tr><th.../th></tr>

const tbody = document.getElementById('tbody');
members.reduce((acc, member) => {
  let tr = document.createElement('tr');
  for (let prop in member) {
    let td = document.createElement('td');
    td.innerText = member[prop];
    tr.appendChild(td);
  }
  acc.appendChild(tr);
  return acc;
}, tbody); // DOM <- Object type



// map(A -> A'), filter(A -> B)
// map() : 요소들을 조합해서 새로운 배열 생성
let result = members.map((member, idx) => {
  let obj = {}
  obj.id = member.id;
  obj.name = member.first_name + '-' + member.last_name;
  obj.email = member.email;
  return obj;
});

// filter() : 조건을 만족하는 새로운 배열 생성
// 메소드체인 : 메소드를 이어서 사용(반환값이 맞아야 가능)
result = members
  .filter((item => item.gender == 'Female'))
  .map((member, idx) => {
    let obj = {}
    obj.id = member.id;
    obj.name = member.first_name + '-' + member.last_name;
    obj.email = member.email;
    return obj;
  })
  .map((item) => item.name);
// return 과 {} 생략됨.
console.log(result);
result.push('charles');
result.push('Hong');
result.push('charles');
console.log(result);

console.log(result.indexOf('charles')); // [5] 1st 'charles'
console.log(result.indexOf('charles', 6)); // [7] 2nd 'charles'


