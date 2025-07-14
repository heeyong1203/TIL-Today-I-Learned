/*
객체지향 언어의 장점
1) 캡슐화
2) 상속
3) 추상화
*/
package use;
public class Account{
	private String num="789-45655-89";
	private String bank="하나은행";
	private String owner="Smith";
	private int balance=500000;

// 클래스 작성 시, 데이터를 보호하고 이 보호된 데이터를 외부에서 사용하게 해주려면,
// 공개된 메서드를 제공해주어야 하는데, 이러한 클래스 정의 기법을 은닉화(encapsulation)라고 함

// 데이터에 대해 읽기, 쓰기가 가능하도록 메서드를 정의해야 함
	public int getBalance(){ // get+멤버변수의 조합 : 일명 getter 메서드
		return balance;
	}
	public void setBalance(){ //set+멤버변수의 조합 : setter 메서드
		this.balance=balance;
	}
	
	public String getNum(){ 
		return num;
	}
	public void setNum(){
		this.num=num;
	}
	
	public String getBank(){
		return bank;
	}
	public void setBank(){
		this.bank=bank;
	}
	
	public String getOwner(){
		return owner;
	}
	public void setOwner(){
		this.owner=owner;
	}
}
