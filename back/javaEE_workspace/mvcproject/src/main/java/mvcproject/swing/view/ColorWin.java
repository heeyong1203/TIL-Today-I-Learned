package mvcproject.swing.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// mvc가 합쳐져 있다?
public class ColorWin extends JFrame {
	JComboBox box;
	JButton bt;
	
	public ColorWin() {
		box = new JComboBox<>();
		bt = new JButton("판단 요청");
		
		//style
		box.setPreferredSize(new Dimension(175, 30));
		
		//데이터 채우기
		box.addItem("RED"); // data가 포함되어 있음
		box.addItem("BLUE");
		box.addItem("YELLOW");
		box.addItem("GREEN");		
		
		setLayout(new FlowLayout());
		add(box);
		add(bt);
		
		bt.addActionListener(e->{ // 컨트롤러의 역할 (이벤트 리스너)
			getAdvice();
		});
		
		setSize(200, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void getAdvice() { // 제외 대상없이 모델로 재사용 가능
		// 혈액형에 대한 판단
		String color=(String)box.getSelectedItem(); // 모델에서 제외
		String msg = null;
		if(color.equals("red")){
			msg="열정적이고 활동적";
		} else if (color.equals("blue")){
			msg="신중하고 분석적";
		} else if (color.equals("yellow")){
			msg="낙천적이고 외향적";
		} else if (color.equals("green")){
			msg="온화하고 배려심 깊음";
		}
		JOptionPane.showMessageDialog(this, msg); // 모델에서 제외
	}
	
	public static void main(String[] args) {
		new ColorWin();
	}
}
