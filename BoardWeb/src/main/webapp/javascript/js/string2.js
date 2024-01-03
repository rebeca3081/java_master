// string2.js

const keyword = '홍';
const wordAry = ['사과', '홍씨', '홍장군', '김시홍', '감자'];
// 1. 배열에서 '홍'이 들어간 단어의 갯수 구하기.
let cnt = 0;
wordAry.forEach(function (item) {
  if (item.indexOf('홍') !== -1) {
    cnt++;
  }
});
console.log(`'홍'의 갯수 : ${cnt}`);

// 다른 방법
console.log(wordAry.filter(val => val.indexOf(keyword) != -1).length);

const url = 'http://localhost/BoardWeb/index/jsp?x=12&y=23';
// 2. url에서 파라미터(x, y)의 값을 찾기.

let ary = url.split('=');
let ary2 = ary[1].split('&');
console.log(`x = ${ary2[0]}, y = ${ary[2]}`);

// 다른 방법
console.log(url.match(/\d+/g));


const word = '안녕하세요xx만나서xx반갑습x니x다.';
// 3. "안녕하세요 만나서 반갑습니다." 문장으로 반환하기.

let ary3 = word.split('x');
// console.log(ary3);
let newStr = '';
let result = ary3.forEach(function (item) {
  if (item !== '') {
    newStr += item;
  } else {
    newStr += ' ';
  }
})
console.log(newStr);

// filter(), join() 써서 해보기
console.log(word.split('xx').filter((val) => val).join(' ').replace(/x/g, ''));

// 다른 방법
console.log(word.replace(/xx/g, ' ').replace(/x/g, ''));
