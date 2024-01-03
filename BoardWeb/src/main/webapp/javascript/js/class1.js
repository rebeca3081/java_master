// class1.js

const obj1 = {
  name: "Hong",
  age: 20,
  showInfo() {
    return `이름은 ${this.name}이고 나이는 ${this.age} 입니다.`;
  }
}

// 클래스. () 중괄호 없음
class Member {
  constructor(name, age) { // 생성자
    this.name = name;
    this.age = age;
  }
  titles = ['이름', '나이']; // 필드 선언
  showTitle() { // 메소드
    this.titles.forEach(item => {
      console.log(item);
    })
    return undefined; // 반환값 기본 -> undefined
  }
  showInfo() { // 메소드
    return `이름은 ${this.name}이고 나이는 ${this.age} 입니다.`;
  }

}
// 프로토타입으로 메소드를 구현하기
Member.prototype.showName = function () {
  return `이름은 ${this.name}입니다.`;
}
const obj2 = new Member('홍길동', 20);
console.log(obj2.showName());