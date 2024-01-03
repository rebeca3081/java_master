// function6.js
const args = [4, 5, 6];

// ... 펼침연산자
function sum(num1 = 0, num2 = 0, ...args) {
  let result = 0;
  result = num1 + num2;
  if (args.length > 0) {
    args.forEach(val => {
      result += val;
    })
  }
  return result;
}
console.log(sum(10, 20, ...args)); // sum(10, 20, 4, 5, 6)
const ary1 = [10, 20];

// concat : 배열을 합쳐서 새로운 배열 반환 (문자열 합치기도 가능)
const ary2 = ary1.concat(args);
console.log(ary2);

// 펼침 연산자를 통해 배열연결 -> 새로운 배열에 담아줌
const ary3 = [...ary1, ...args];
console.log(ary3);

// 펼침 연산자를 통해 객체연결 -> 새로운 객체에 담아줌
const obj1 = { name: "Hong", age: 20 }
const obj2 = { name: "Hwang", height: 170 }

const obj3 = { ...obj1, ...obj2 }; // 같은 속성은 마지막 객체로 덮어쓰기, 새로운 속성은 누적
console.log(obj3);

// 기억해서 활용 잘 하면 좋은 고차함수들 : forEach(), reduce(), map(), filter()

// reduce() : / 고차함수
let result = [4, 5, 6].reduce((acc, curItem, idx, ary) => {
  console.log(acc, curItem, idx); // acc: 이전 순번에서 누산된 값을 반환
  return acc + curItem; // curItem 반환값이 다음 순번의 acc 값이 됨
}, 0)

console.log('결과값: ' + result); // 6

// map() 메소드 : 다른 값으로 mapping / 고차함수
result = [1, 2, 3, 4].map((item, idx, ary) => {
  // console.log(item, idx, ary);
  return item * 2;
});
console.log('결과값: ', result); // *2한 새로운배열을 반환해줌


// 변수의 스코프
var name = '어피치'; // 전역변수
function run() {
  if (true) {
    // var name = '라이언';
    let name = '라이언';
  }
  console.log(name); // 1.라이언  // let ->어피치
  return name;
}
run();
console.log(name); // 2.어피치

// 스코프 체인
var a = 1;
var b = 5;
function outerFunc() {
  // var b; // undefined. (호이스팅이 일어남, 선언만)
  function innerFunc() { // outerFunc() 내에서만 사용가능
    a = b;
  }
  console.log(a); // (1)전역변수 a = 1 출력
  a = 3;
  b = 4; // var b;에 4를 담겠습니다
  innerFunc();
  console.log(a, b); // 4, 4
  var b = 2; // 값이 담김
  console.log(b); // 2
}
outerFunc();
console.log(a, b); // 4, 5


// 예외처리
const c = 10;

try {
  c = 20;
} catch (error) {
  console.log(error)
} finally {
  console.log(c);
}
