package gui.chat;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ChatA extends Frame implements ActionListener, KeyListener{
							/*  is a						  is a			implement를 두 번 쓰는 것이 아님 쉼표(,) 이용 */
							
	TextArea area; // has a 관계
	Panel p_south;
	TextField t_input;
	Button bt_open;
	ChatB chatB;
	
	public ChatA(){
		area= new TextArea();
		p_south = new Panel();
		t_input = new TextField(30);
		bt_open = new Button("열기");
		
		//스타일
		area.setBackground(Color.YELLOW);
		
		add(area);
		p_south.add(t_input);
		p_south.add(bt_open);
		add(p_south, BorderLayout.SOUTH);
		
		// 버튼과 리스너인 자(者)와의 연결
		bt_open.addActionListener(this);
		
		// 텍스트 필드와 리스너인 자(者)와의 연결
		t_input.addKeyListener(this);
		
		setSize(300,400);
		setVisible(true);
	}
	// ActionListener를 구현하겠다고 선언하였으므로, 현재 클래스에서 인터페이스의 메서드를 오버라이딩 하자
	public void actionPerformed(ActionEvent e){
		// System.out.println("나 눌렀어?");
		
		// ChatB의 인스턴스 생성!
		// this란? 인스턴스가 자기 자신을 가리키는 레퍼런스 변수
		chatB = new ChatB(this); // this는 곧 ChatA의 인스턴스를 가리키는 변수이므로...
	}
	
	// KeyListener의 메서드를 재정의
	public void keyReleased(KeyEvent e){ // keyup
		// System.out.println(e.getKeyCode()); // keyCode를 얻어오는 메서드 getKeyCode()
			//String msg = t_input.getText();
			//System.out.println(msg);	
			
		if (e.getKeyCode()==10){ 
			// ChatB가 보유한 area의 텍스트값을 ChatA에 원하는 값을 입력하여 넣어보자
			// 나의 텍스트필드 값을 얻어서 전달
			String msg = t_input.getText();
			chatB.area.append(msg+"\n");
			
			// 나의 텍스트필드 다시 지우기
			t_input.setText(""); // 초기화
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){} // keydown
	
	public static void main(String[] args) {
		new ChatA();
	}
}