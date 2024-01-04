// array.js
// 배열 ary = [];
const ary = [1, 2, '3', new Date()]; // 다양한 타입의 변수를 담을 수 있으나, 사용X

const numAry = [10, 20, 30, 40];

// 추가
numAry.push(30); // 배열의 마지막에 추가
numAry.unshift(40); // 배열의 첫번째에 추가

// 삭제
numAry.pop(); // 마지막 요소 삭제
numAry.shift(); // 첫번째 요소 삭제

// ★★★ splice() : 특정 위치 요소 삭제/변경/추가 가능
// numAry.splice(1, 2); // splice(위치, 갯수)
// numAry.splice(1, 1, 50); // splice(위치, 갯수, 대체값)
// numAry.splice(1, 0, 50, 60); // splice(위치, 0->추가 의미, 추가값-> 여러개 가능)
// numAry.splice(1, 2, 50, 60, 80); // splice(위치, 2개, 추가값-> 여러개 가능)

// numAry.splice(0); // 공백
// numAry.length = 10; // 크기 조정가능 / empty × 6 / 읽기전용X 수정이 가능! 

const numAry2 = [50, 60];
// concat() -> 배열을 연결해서 새로운 배열을 반환해줌
// let numAry3 =numAry.concat(numAry2);

// numAry에 numAry2를 추가.
numAry2.forEach(num => numAry.push(num));

console.log(numAry);

