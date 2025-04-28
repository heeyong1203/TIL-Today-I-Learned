// 랜덤한 값 구하기 (원하는 정수를 반환받기 위해서는 n값을 호출 시 결정하자)
// ex) getRandom(1000)을 넘기면 0~999 값 반환
function getRandom(n){
   return parseInt(Math.random()*n);
}