package gui.font;

import java.awt.Frame;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWin extends Frame implements ActionListener{

	TextArea area;
	Panel p_south;
	Button bt_style;
	GuiFont guiFont;
	
	public MyWin(){
		area = new TextArea();
		p_south= new Panel();
		bt_style = new Button("서식");
	
		// 스타일
		area.setBackground(Color.YELLOW);
	
		// 붙이기
		add(area);
		p_south.add(bt_style);
		add(p_south, BorderLayout.SOUTH);
		
		setSize(300,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		guiFont = new GuiFont();
	}
	
	public static void main(String[] args){
		new Chat();
	}
}