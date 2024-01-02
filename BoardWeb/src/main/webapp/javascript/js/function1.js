// 함수

// 함수 선언식
function sum(num1 = 0, num2 = 0) { // (parameter) : 매개변수
  let result = 0;
  result = num1 + num2;
  // console.log(result);
  console.log(arguments); // arguments : 들어오는 매개값들을 처리해주는 객체
  if (arguments.length > 2) {
    for (let arg = 2; arg < arguments.length; arg++) {
      result += arguments[arg];
    }
  }
  return result;

}
// 함수 호출
// sum(); // undefined + undefined = NaN
let result = sum(15, 30, 50, 20, 40, 60); // (argument) : 인수, 함수에 입력되는 값
console.log('결과는 ' + result);


// 함수 표현식
let sum2 = function (num1 = 0, num2 = 0) {
  let result = num1 + num2;
  return result;
}
// 함수 호출
console.log('결과 : ' + sum2(10, 20));

// 객체
let obj1 = {
  name : "Hong",
  point : 100
}
let obj2 = {
  name : "Hwang",
  point : 80
}
// 함수 매개값으로 객체 사용가능
let average = function (obj1 = {}, obj2 = {}){
  let result = 0;
  result = (obj1.point + obj2.point) / 2;
  return result;
}
console.log('평균값: ' + average(obj1, obj2));

// 배열
let array1 = [10, 20];
let array2 = [30, 40];
// 함수 매개값으로 배열 사용가능
let sum3 = function (ary1 = [], ary2 = []){
  let result = 0;
  // console.log(ary1.concat(ary2));
  ary1.concat(ary2).forEach(function(val){
    result += val;
  })
  return result;
}
console.log("배열의 총합 : " + sum3(array1, array2));

// 함수 매개값으로 함수를 사용
let myFunc = function(callback){
  let result = 0;
  let num1 =  10,
      num2 = 5;
  result = callback(num1, num2);
  return result;
}
let sumFunc = function(n1, n2){
  return n1 + n2;
}
let minusFunc = function(n1, n2){
  return n1 - n2;
}

console.log('함수결과 : ' + myFunc(sumFunc));
console.log('함수결과 : ' + myFunc(minusFunc));