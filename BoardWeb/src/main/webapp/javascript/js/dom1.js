// dom1.js

// 객체가 담긴 배열 : [{id, name, phone}...] [배열{object}]
// 객체 = {key : value}
const obj1 = { id : 'user1', name : '홍길동', phone : '010-1111'};
const obj2 = { id : 'user2', name : '김민수', phone : '010-2222'};
const obj3 = { id : 'user3', name : '박철호', phone : '010-3333'};
const friends = [obj1, obj2, obj3];

// for...of(객체 탐색) : 객체가 담긴 배열의 반복
for(let friend of friends){
  // for...in(배열 값 순환) : 기본-key를 읽어옴 / obj[key] :value 읽어옴
  for(let prop in friend){
    console.log(prop.toUpperCase(), ' - ', friend[prop]); //obj1.id == obj1['id']
  }
}