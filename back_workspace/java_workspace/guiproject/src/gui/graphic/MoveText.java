// w600, h50+h600
// borderLayout, Panel(p_north, p_center), Button
package gui.graphic;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoveText extends JFrame implements ActionListener{
	// 멤버 변수 선언
	JPanel p_north;
	JButton bt;
	MovePanel p_center;
	
	// 생성자 선언
	public MoveText(){
		p_north = new JPanel();
		bt = new JButton("이동");
		p_center = new MovePanel();
		
		// 스타일 및 조립
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		
		// 센터 패널에 붙이기
		add(p_center);
		
		bt.addActionListener(this); // 버튼과 리스너 연결
		
		// 화면에 출력
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,650);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		// MovePanel의 빨간색 원을 이동시키자
		// p_center의 x, y를 증가시키자 (값을 먼저 얻고 증가)
//		int x = p_center.getX();
//		int y = p_center.getY();
		
//		x++;
//		y++;
		
//		p_center.setX(x);
//		p_center.setY(y);
		// 너무 코드가 방대해짐, MovePanel에서 직접 처리하게 하자
		p_center.move();
		p_center.repaint(); // 다시 그려줘 ※주의 : 절대 paint(Graphics) 호출 금지
	}
	
	public static void main(String[] args){
		new MoveText();
	}
}