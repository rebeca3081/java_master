// map, filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

const strs = str.split(', ');
console.log(strs);

// 1. 콘이라는 이름이 몇번?
console.log(strs.filter(ele => ele.indexOf('콘') != -1).length);
// reduce() 연습

// 2. 이름이 3자 이상이 몇명?
// 2_1
let cnt = 0;
let result = strs.forEach(item => {
  if(item.length >= 3){
    cnt++
  }
})
console.log(cnt);
// 2_2
console.log(strs.filter(item => item.length >= 3).length);
// reduce() 연습

// 3. 2자인 이름이 있는지 여부?
console.log(strs.some(ele => ele.length == 2));

// 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입
/*
// reduce()
const strAry = [];
strs.reduce((acc, item, idx) => {
  let obj = {}
  obj.no = idx + 1;
  obj.name = item;
  acc.push(obj);
  return acc;
}, strAry);
*/
const strAry = strs.map((item, idx) => {
  let obj = {}
  obj.no = idx + 1;
  obj.name = item;
  return obj;
});
console.log(strAry);
