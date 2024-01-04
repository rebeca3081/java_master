//class7.js

// import: 모듈 가져오기
import { friend, sum, getMax } from "./class6.js";

let n1 = 10, n2 = 20;
console.log(sum(n1, n2)); // 두개의 script파일이 하나의 html에 있어서 가능

console.log(getMax(n1, n2));

console.log(friend.showInfo());