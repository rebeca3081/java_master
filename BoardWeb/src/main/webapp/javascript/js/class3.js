// class3.js

// 배열에 추가 : push()
class Estimate {
  constructor(param) {
    this.unit = param;
  }
  // 견적가 얻기 메소드
  getEstimate(unittype, width, height) {
    let priceinfo = this.unit.find(item =>
      item.type == unittype);
    return priceinfo.price * width * height;
  }
  // 배열에 요소 추가 메소드
  addUnit(unit) {
    unit.push(unit);
  }
}
let unitinfo = [{ type: "wood", price: 100 }, { type: "iron", price: 300 }, { type: "plastic", price: 200 }];
const estimator = new Estimate(unitinfo);

let result1 = estimator.getEstimate('wood', 20, 20);
let result2 = estimator.getEstimate('iron', 10, 20);
let result3 = estimator.getEstimate('plastic', 50, 50);
console.log(`나무의 견적은 ${result1} 입니다.`);
console.log(`철의 견적은${result2} 입니다.`);
console.log(`플라스틱의 견적은${result3} 입니다.`);

// 추가해보기

///////////////////////

// this
// 1.객체 : 객체 자기자신
// 2.function() this : 전역객체 (window)
// 
function myFunc() {
  console.log(this);
}
myFunc();

// p112 예제
let obj = {};
obj.act = function () {
  this.value = 'default value';

  function innerAct() {
    this.value = 'innerAct value'; // this.value : window의 속성으로 '문자열' 담음
    console.log("this.value: " + this.value); // innerAct value
  }

  function innerReact(caller) {
    caller.value = "innerReact value";
    console.log("this.value: " + this.value); // innerAct value
    console.log("caller.value: " + caller.value); // innerReact value
  }
  innerAct();
  console.log("obj 객체의 this.value: " + this.value); // default value (window 전역객체)

  innerReact(this); // obj의 value -> default value
  console.log("obj 객체의 this.value: " + this.value); // innerReact value
}

obj.act();

////////////////
// 클로저. : 정의하는 시점(만들어진 시점)의 실행환경을 기억하는 함수
function outerFunc(name) {
  let saying = name + ' 안녕!';

  return function () {
    return saying;
  }
}

const closure1 = outerFunc('라이언');
console.log(closure1()); // closure1 = ƒ () {return saying;}
const closure2 = outerFunc('콘');
console.log(closure2());

function getCount(){
  let cnt = 1;

  return function (){
    cnt++;
    console.log(cnt);
  }
  // increaseCounter();
}
const clo1 = getCount();
clo1();
clo1();
clo1();

