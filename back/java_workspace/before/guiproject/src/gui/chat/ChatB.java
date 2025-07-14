package gui.chat;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ChatB extends Frame implements KeyListener{
	TextArea area;
	Panel p_south;
	TextField t_input;
	ChatA chatA; //ChatB가 ChatA를 제어하기 위해 has a 관계로 보유함
	
	public ChatB(ChatA chatA){ // 생성자 호출 시 주소값을 넘겨야 하므로, 이 생성자 메서드를 호출하는 자 call by reference
		
		System.out.println("저 태어날 때 ChatA 정보 넘겨받았어요"+chatA);
		area= new TextArea();
		p_south = new Panel();
		t_input = new TextField(40);
		this.chatA = chatA; // 새롭게 인스턴스를 생성하지 말고, 기존의 ChatA를 넘겨받음
		
		//스타일
		area.setBackground(Color.YELLOW);
		add(area);
		p_south.add(t_input);
		add(p_south, BorderLayout.SOUTH);
		
		t_input.addKeyListener(this);

		setSize(300,400);
		setVisible(true);
	}
	
	// 키보드 누르면서 엔터 칠 때 ChatA에게 메시지 보내기
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){ // 엔터를 치면...
			// ChatA의 area에 값 추가
			chatA.area.append(t_input.getText()+"\n");
			t_input.setText("");
		}
	}
	
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){} // keydown
	
}