// function3.js
// 객체생성: {}
let obj1 = {
  name: "홍길동",
  age: 20,
  showInfo: function () {
    return '이름은 ' + this.name + ', 나이는 ' + this.age;
  }
}

console.log(obj1.name);
console.log(obj1['age']);
console.log(obj1.showInfo());

// 함수를 통해 객체 선언.
function Member(name, age) { // 생성자 함수
  this.name = name; // 전역변수 name이 아닌, 객체안에 있는 this.name을 호출
  this.age = age;
  this.showInfo = function(){
    return '이름은 ' + this.name + ', 나이는 ' + this.age;
  }
}

let obj3 = new Member("박민수", 34); // new : 생성자를 통한 객체를 생성할 때
let obj4 = new Member("이형섭", 29);

console.log(obj3.showInfo());
console.log(obj4.showInfo());