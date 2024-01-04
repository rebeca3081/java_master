// array2.js

const numAry = [23, 10, 17, 35, 9];

// 누적 합 반환
let result = numAry.reduce((acc, num) => {
  // console.log(acc, num);
  return acc + num;
}, 0);

// 제일 큰 값 반환
result = numAry.reduce((acc, num) => {
  return acc > num ? acc : num;
}, 0);

// 1. 최소값
result = numAry.reduce((acc, num) => {
  return acc < num ? acc : num;
}, numAry[0]);

// 2. 평균 구하기
result = numAry.reduce((acc, num, idx) => {
  if (idx == numAry.length - 1) {
    return (acc + num) / numAry.length;
  }
  return acc + num;
}, 0);

// 10보다 큰 값을 새로운 배열로 생성
result = numAry.reduce((acc, num) => {
  if (num > 10) {
    acc.push(num);
  }
  return acc;
}, []); // 초기값을 배열로 선언

console.log(`결과: ${result}`);