package gui.graphic;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class MovePanel extends JPanel{
	private int x; // default 값 : 0
	private int y; // default 값 : 0
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	
	public void move(){
		x++;
		y++;
	}
	
	// JPanel의 paint() 메서드를 오버라이딩
	public void paint(Graphics g){
		// 채워진 원 그리기
		g.setColor(Color.RED);
		g.fillOval(x, y, 45, 45);
	}
}