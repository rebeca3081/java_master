// class4.js

const friend = {
  name: "장효은",
  age: 29,
  hobbies: ['볼링', '음악감상', '잠자기'],
  pets: [{ name: '야옹이', gender: 'M', friends: ['검냥이', '빨냥이'] },
  { name: '삐약이', gender: 'F' }],
  showHobby() {
    return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
  }
}
friend.pets[0].friends[2] = '노냥이';
delete friend.age; // 속성 삭제
friend.ages = 20; // 속성 추가
friend.showFriends = function () { // 메소드 추가
  console.log(this); // friend 객체를 가리킴
}
console.log(friend['pets'][0]['friends'][0]); // ['속성명'] 값 접근
console.log(friend.pets[0].friends[0]); // . 접근
console.log(friend.pets[0].friends);
console.log(friend);
console.log(friend.showFriends());
