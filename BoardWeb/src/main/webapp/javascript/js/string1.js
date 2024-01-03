// string1.js

let str1 = "Hello";
console.log(str1, typeof str1); // 1. string

let str2 = new String("Hello");
console.log(str2, typeof str2); // 2. 'object'

console.log(str1 == str2); // true (값만 비교)
console.log(str1 === str2); // false (값과 타입까지 비교)

console.log(str2.substring(1, 3)); // 즉, [1]~[2] 인덱스로 잘라서 반환
// substring(start, end) start은 포함하고, end는 포함하지 않겠습니다.


let word = "     Hello, World  ";
console.log(word.trimStart()); // 왼쪽 여백 삭제
console.log(word.trimEnd()); // 오른쪽 여백 삭제
console.log(word.trim()); // 양쪽 여백 삭제

// const obj = new Object(); {}
// const reg = new RegExp(); /값/ g-> global [정규표현식]
console.log(word.replace(/l/g, 'L')); // 문자변경
console.log(word.replace(/\s/g, '')); // 공백(\s)을 다 찾아서 비우겠음

word = '   how are you   to day  everyone.   ';
console.log(word.split(' ').filter((val) => val).join(' '));
// split(' '):공백을 기준으로 자른 후 새 배열을 반환함
// filter() : true 값만 새로운 배열에 담아 반환(빈문자열 '' -> false임)
// join(' '): 공백으로 이어서 새로운 문자열을 생성함

let str3 = "Jang hyo eun";
console.log(str3.slice(2, 8)); // == substring(start, end)
console.log(str3.slice(1, -6)); //(음수도 가능)

console.log(str3.substr(2, 4)); // (idx, 갯수)

let num = 601;
console.log(num.toString(), typeof num.toString()); // number -> string 변환

const str4 = 'bad morning, GOOD Afternoon, Good Eveningm good Night';

// indexOf('문자열' , idx) : (1) 찾는 문자열이 있으면 위치(인덱스번호를) 반환
// 없으면 -1 (2) idx -> 검색을 시작하는 위치지정
console.log(str4.indexOf('good'));
console.log(str4.lastIndexOf('good'));

console.log(str4.charAt(5)); // 해당 위치의 문자 1개를 반환

console.log(str4.includes('bad')); // 있으면 true, 없으면 false

// 대·소문자 구분없이 문자열 위치 찾기
console.log(str4.toLowerCase().indexOf('good'));
console.log(str4.toUpperCase().indexOf('GOOD'));
console.log(str4.search('good'));
console.log(str4.search('GOOD'));
console.log(str4.search(/goOd/i)); // 정규표현식 -> i: 대소문자를 무시

// match() : 정규표현식 또는 문자열과 일치하는 모든 문자열을 찾아서 배열로 반환
console.log(str4.match(/good\s\w+/gi)); // 없으면 null반환

// 문자열 합치기
let str5 = '문자열1';
let str6 = '문자열2';
console.log(str5.concat(str6));
console.log(''.concat(str5, str6)); // ★

let strAry = ['good', ' ', 'Morning', '!'];
console.log(''.concat(...strAry));









