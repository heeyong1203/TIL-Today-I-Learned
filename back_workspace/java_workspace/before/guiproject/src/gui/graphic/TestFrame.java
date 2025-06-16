/*
그래픽 프로그래밍 시, 알고 있으면 도움이 되는 비유
	[현실]								[프로그래밍]
1) 화가						1) 컴포넌트
2) 붓(그리는 행위)				2) 컴포넌트가 보유한 그리는 메서드; paint()
3) 팔레트 등 기타 도구				3) paint가 보유하고 있는 객체; paint(Graphics g)
4) 캠퍼스(도화지)					4) 컴포넌트 자신

모든 컴포넌트는 스스로를 그린다...
버튼이 스스로 그림을 그릴 때 뺏어보기!!
*/
package gui.graphic;

import javax.swing.JFrame;
import javax.swing.JButton;

public class TestFrame extends JFrame{
	MyButton bt; // 같은 자료형이므로 당연히 가능
	ImgPanel ip; // 내가 재정의한 패널
	
	public TestFrame(){
		bt = new MyButton("커스텀 버튼");
		ip = new ImgPanel();
		
		setLayout(new java.awt.FlowLayout());
		add(bt);
		add(ip);
		
		setSize(300, 400); // this.setSize와 동일 의미
		setVisible(true);
		// 윈도우창을 닫을 때, 프로세스 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	public static void main(String[] args){
		new TestFrame();
	}
}