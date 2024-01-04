const ary = [12, 20, 100, 2, 1, 88];
 
ary.sort((a, b) => { // a 앞의 값, b 뒤의 값
  // 오름차순: -1 (음수), 내림차순: 1(양수)
  if (a < b) { // if (a > b)
    return -1;
  } else {
    return 1;
  }
});

const friends = [
  {name: "Hong", age: 12},
  {name: "Hwang", age: 111},
  {name: "Park", age: 2},
  {name: "Kim", age: 33},
];

friends.sort((a, b)=> {
  if(a.age < b.age){
    return -1;
  } else {
    return 1;
  }
})

friends.sort((a, b)=> {
  if(a.name < b.name){
    return -1;
  } else {
    return 1;
  }
})

console.log(ary);
console.log(friends);

