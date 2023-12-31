// var: 함수 레벨 , let, const: block 레벨.
var name = 'Hwang';
function myfunc()
{
  var name = 'hong'; // 함수 안에서만 유효한 값을 가짐
  // name = 'hong';  // 'Hwang' -> 'hong'
  console.log(name); // hong
  console.log(this);
}
myfunc();
console.log(name); // Hwang

// let, const 사용하는 것이 더 좋음
let age = 20;
// function myfunc2()
{
  let age = 22; // 블록 안에서만 유효한 값을 가짐
  console.log(age);
}
// myfunc2();
console.log(age);

// 객체
let obj = {
  id : 'Hong',
  age : 20,
  show : function(){
    console.log(this);
  }
}
obj.show();

//
document.body.addEventListener('click', function(){
  console.log(this);
});

// 1. 전역영역: window 객체.
// 2. 함수: window 객체.
// 3. 객체: object.
// 4. 이벤트: 이벤트 실행 대상.
// console.log(this);

// let show = 'Hello';

/*
function show(){
  console.log('show');
}
*/

let show = function(){
  console.log('show');
  // return undefined; // defalut로 undefined를 반환해줌
  return '반환값';
}

console.log(show());

// 익명함수 실행하기,  () 함수실행의 의미
(function() {
  console.log('익명함수');
})()

// 함수명명 규칙. -> camelCase법 사용하기
function showMyName(){
  console.log('홍길동');
}

// 상수선언 const (에러:Assignment to constant variable.)
/*
const height = 167.9;
height = 169;
*/

// 객체는 상수로 선언하자~!
const friend = {
  name: '홍길동',
  phone: '010-11111'
}
friend.phone = '010-2222';

// 객체 자체는 재정의가 안됌.
// friend = {};