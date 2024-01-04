// 연습
const friends = [{ name: "프로도", age: 3 }, { name: "라이언", age: 5 }, { name: "콘", age: 5 }, { name: "무지", age: 4 }, { name: "네온", age: 2 }];

// 1.find() : 함수의 조건을 만족하면 요소를 반환, 끝까지 없으면 undefined 반환
let result = friends.find(friend => friend.age == 4);
// console.log(result);

// 2.filter() : 함수의 조건을 만족하는 요소들만 모아, 배열로 반환
result = friends.filter(friend => friend.age >= 4);
// console.log(result);

// 3.map() : 요소들을 조합해서 새로운 배열 생성
result = friends.filter(friend => {
  // console.log(friend);
  let cuple = [];
  cuple.name = friend.name;
  return cuple;
});
// console.log(result);

// 4.some() : 조건을 만족하는 요소가 1개 이상이면 true, 없으면 false
let boolSome = friends.some(friend => friend.name == '프로도');
let boolSome2 = friends.some(friend => friend.name == '어피치');
console.log(boolSome);
console.log(boolSome2);

// 5.every() : 모든 요소가 조건에 만족하면 true, 아니면 false;
let boolEvery = friends.every(friend => friend.age > 3);
console.log(boolEvery);
