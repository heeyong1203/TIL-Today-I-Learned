/*
자동차 클래스로부터 인스턴스 1개를 생성하여 자동차 핸들의 색상, 바퀴 브랜드명, 문짝의 열기 기능 호출
*/
package use;

class UseCar{
	public static void main(String[] args){
		// Car car = new Car();만 입력하는 경우, 
		// 본체만 생성한 것일 뿐 has a 관계의 부품들은 생성되지 않은 상태
		Car car= new Car();
		/* 
		car.handle= new Handle();
		car.wheel= new Wheel();
		car.door= new Door();
		*/
		
		System.out.println(car.handle.color);
		System.out.println(car.wheel.brand);
		car.door.open();
	}
}