// class6.js

// 모듈
function sum(num1, num2){
  return num1 + num2;
}

function getMax(num1, num2){
  return num1 > num2 ? num1 : num2;
}

const friend = {
  name: "hong",
  age: 20,
  showInfo(){
    return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
  }
}

// export: 특정 모듈 반환 (함수, 변수, 객체, 클래스... 가능)
export { friend, sum, getMax };