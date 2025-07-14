/*
AWT는 자바 초창기 GUI패키지임은 맞지만, os마다 다른 디자인으로 실행됨... mac-맥에 맞게, win-윈도우에 맞게끔, linux-리눅스에 맞게끔
mac에 최적화한 경우, win에서 깨지는 경우가 발생하였음
swing은 os 즉, 플랫폼에 상관없이 중립적인 Look&Feel 디자인을 유지함
요즘은 swing처럼 os에 어울리지 않고 너무 java 최적화 디자인을 지양함. 따라서 javaFX가 지원됨...
swing은 기존의 awt를 계승했기 때문에 우리가 사용해왔던 awt 컴포넌트 명에 J접두어만 붙는다.
*/

package gui.swing;
import javax.swing.JFrame; // x는 보통 extends를 의미... 확장된 java를 의미함
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWin extends JFrame implements ActionListener{
	JTextArea area;
	JPanel p_south;
	JButton bt;
	
	public MyWin(){
		area = new JTextArea(4, 15); // 행,열 지원
		p_south = new JPanel();
		bt = new JButton("환경설정");
		
		// area 노란 배경 색상 부여
		area.setBackground(Color.YELLOW);
		
		add(area); // 센터에 부착
		p_south.add(bt); // 남쪽 패널에 버튼 부착
		add(p_south, BorderLayout.SOUTH); // 남쪽에 패널 부착
	
		bt.addActionListener(this); // 리스너를 구현한 者의 인스턴스 this
		//setSize(300, 400);
		setBounds(2000, 200, 300, 400); // x,y,w,h
		setVisible(true);
	}
	
	// 부모의 메서드 오버라이딩
	public void actionPerformed(ActionEvent e){
		// this란? 인스턴스가 자기 자신을 가리키는 레버런스 변수명
		// 개발자가 마음대로 정한 이름이 아닌, 시스템이 정해놓은 변수명
		new Config(this);
	}
	
	public static void main(String[] args){
		new MyWin();
	}
}