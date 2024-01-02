// function5.js

// Array.prototype.forEach();
const ary = ['a', 'b', 'c'];
ary.forEach(elem => console.log(elem)); // ☆ 화살표 함수: 간단하게 표현하기 위함

ary.forEach((elem, idx) => { // 매개변수가 여러개인 경우 : 매개변수에 () 필요
  if (idx > 0) {
    console.log(elem); // [1]: 'b', [2]: 'c'만 출력됨
  }
})

// ☆ Array의 prototype(interface역할)에 sum 이라는 메소드를 정의해서 추가하겠습니다.
// 자바스크립트에서 가능 (정의되어진 영역에서만 사용가능)
Array.prototype.sum = function () {
  console.log(this); // 자기 자신을 출력함 numbers = [1, 2, 3, 4];
  let result = 0;
  this.forEach(function (val) {
    result += val;
  })
  return result;
};
const numbers = [1, 2, 3, 4];
console.log('sum의 결과 : ' + numbers.sum());