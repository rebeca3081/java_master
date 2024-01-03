// 클래스 연습해보기

// 일반적인 객체
const obj1 = {
  name: "Jang",
  age: "20",
  showInfo() {
    return `이름 ${this.name}, 나이 ${this.age}`;
  }
}

// 클래스
class Friend {
  // 생성자
  constructor(name, age, phone, job) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.job = job;
  }
  // 필드
  heads = ['이름', '나이', '전화번호', '직업'];
  // 메소드
  showInfo() {
    return `이름: ${this.name}, 나이 ${this.age}, 전화번호${this.phone}, 직업${this.job}`;
  }
}
const obj2 = new Friend('김진주', 30, '010-1234', '작가');
const obj3 = new Friend('안소정', 30, '010-9876', 'PD');

console.log(obj2.showInfo());
console.log(obj3.showInfo());
