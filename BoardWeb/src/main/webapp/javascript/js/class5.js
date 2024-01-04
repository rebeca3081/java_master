// Map, Set.
const map = new Map();
map.set('홍길동', 20);
map.set('김민수', 22);
map.set('최성우', 25);
map.set('홍길동', 21); // 같은 key가 있으면 새로운 값으로 변경됨

// 삭제
// map.delete('최성우');
// 전체삭제
// map.clear();

console.log(map.get('김민수'));

console.log(map.keys()); // map.keys() : key 값만 컬렉션 타입으로 반환
for (let key of map.keys()) {
  console.log(`key는 ${key}, value는 ${map.get(key)}`);
}
console.log(map.values()); // map.values() : value 값만 컬렉션 타입으로 반환

for (let [item, value] of map.entries()) { // map.entries() : [key, value]쌍
  console.log(item, value);
}

// 첫번째 매개값 -> 값, 두번째 매개값 -> 키.
map.forEach((val, key) => console.log(`key: ${key}, val: ${val}`));

// set.
const set = new Set();

// 추가
set.add('홍길동');
set.add('김민수');
set.add('박재희');
set.add('홍길동'); // 중복은 제거됨

set.delete('김민수');

console.clear();
console.log(set.size); // 배열의 length와 같은 역할

set.forEach(name => console.log(name));

const numAry = [10, 14, 12, 10]; // 중복 제거됨
const num = new Set(numAry); // 배열 -> Set에 담기
num.forEach(number => console.log(number));

console.clear();
map.clear();

map.set('김명철', 80);
map.set('김익수', 70);
map.set('이명철', 80);
map.set('이익수', 85);
map.set('홍길동', 80);

map.forEach((score, name) => console.log(name, score));

// 김씨 점수의 합계와 평균
let sum = 0;
let cnt = 0;
map.forEach((score, name) => {
  if (name.indexOf('김') == 0) {
    sum += score;
    cnt++;
  }
})
console.log(`합계는: ${sum}, 평균은: ${sum/cnt}`);

