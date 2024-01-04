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
// delete friend.age; // 속성 삭제
friend.ages = 20; // 속성 추가
friend.showFriends = function () { // 메소드 추가
  console.log(this); // friend 객체를 가리킴
}
// console.log(friend['pets'][0]['friends'][0]); // ['속성명'] 값 접근
// console.log(friend.pets[0].friends[0]); // . 접근
// console.log(friend.pets[0].friends);
console.log(friend);
// console.log(friend.showFriends());


// ------ 240104(목) ---------

// 참조값을 복사.
const fcopy = friend; // 동일한 객체를 가리키고 있음
fcopy.age = 22;
console.log(fcopy);

// 객체를 복사. : 원본 객체에는 변경이 되지 않음
const fcopy2 = Object.assign({ bloodType: 'A' }, friend); // assign(빈 객체, 복사할 대상)
fcopy2.age = 24;
console.log(fcopy2);

// 속성추가.
Object.defineProperty(friend, 'height', { // defineProperty(객체, 속성, );
  get: function () { // 메소드 아님 getter : 속성의 값 불러오기
    return this._height; // '_'제외하면 자기 자신을 무한 호출에러 (_:숨김속성의 의미)
  },
  set: function (value) { // setter : 속성의 값 설정하기
    if (value <= 0) {
      alert('error');
    } else {
      this._height = value;
    }
  }
});

friend.height = 163;
console.log(friend.height);