/*------------------------------------------------------------- 
랜덤한 값 구하기 (원하는 정수를 반환받기 위해서는 n값을 호출 시 결정하자)
ex) getRandom(1000)을 넘기면 0~999 값 반환
*------------------------------------------------------------*/
function getRandom(n){
   return parseInt(Math.random()*n);

}
/*------------------------------------------------------------- 
범위를 지정한 랜덤
getRandomByRange(min,max) min부터 max 사이의 랜덤값 반환
*------------------------------------------------------------*/
function getRandomByRange(min, max){
   return parseInt(Math.random()*(max-min+1))+min;

}
/*------------------------------------------------------------- 
시간이 한 자리 수인 경우 앞에 0 붙이기
*------------------------------------------------------------*/
function zeroString(n){
   // 만일 n이 한자리 수이면, 앞에 '0'문자를 붙여주자
   let str=n;
   if(n>0 && n<10)str="0"+n;
   return str;
}

/*------------------------------------------------------------- 
해당 월의 시작 요일 구하기
API 사용 예) 2025년 5월 구하기 : getStartDay(2025, 4); 입력
*------------------------------------------------------------*/
function getStartDay(yy,mm){
   let d = new Date(yy, mm, 1); // yy년도 mm월 1일
   return d.getDay(); // 요일을 반환
   
}

/*------------------------------------------------------------- 
영어 또는 한국어로 요일을 변환하여 반환하기
API 사용 예) convertDay(2, "kor");
*------------------------------------------------------------*/
function convertDay(n, lang){
   let korArray=["일요일","월요일","화요일","수요일","목요일","금요일","토요일"];
   let engArray=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday",]

   let day=(lang=="kor" || lang=="korean")? korArray[n]:engArray[n] ;// 어떤 요일을 선택할지 결정
   return day;
}
   /*------------------------------------------------------------- 
   해당 월의 마지막 일 구하기
   API 사용 예) 2025년 5월 구하기 : getLastDate(원하는 연도, 원하는 달);
   *------------------------------------------------------------*/
  function getLastDate(yy,mm){
     let d = new Date(yy, mm+1, 0); // yy년도 mm월 1일
     return d.getDate(); // 요일을 반환
     
   }
   
   /*------------------------------------------------------------- 
   충돌체크 함수;
   API 사용 예) 
   *------------------------------------------------------------*/
   function collisionCheck(me, target){
   // 나에 대한 수치계산
   const me_x = parseInt(me.style.left);
   const me_y = parseInt(me.style.top);
   const me_width= parseInt(me.style.width);
   const me_height= parseInt(me.style.height);

   const target_x = parseInt(target.style.left);
   const target_y = parseInt(target.style.top);
   const target_width= parseInt(target.style.width);
   const target_height= parseInt(target.style.height);

   return !(
      me_x+me_width < target_x || // me의 우측면이 target의 좌측면에 도달하지 못했거나
      me_x > target_x+target_width || // me의 좌측면이 target의 우측면을 넘어섰을 경우
      me_y+me+me_height < target_y || // me의 하단면이 target의 상단면에 도달하지 못했거나
      me_y > target_y + target_height // me의 상단면이 target의 하단면을 넘어섰을 경우
   )
  }