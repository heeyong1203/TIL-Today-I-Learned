package mvcproject.swing.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// mvc가 합쳐져 있다?
public class BloodWin extends JFrame {
	JComboBox box;
	JButton bt;
	
	public BloodWin() {
		box = new JComboBox<>();
		bt = new JButton("판단 요청");
		
		//style
		box.setPreferredSize(new Dimension(175, 30));
		
		//데이터 채우기
		box.addItem("A"); // data가 포함되어 있음
		box.addItem("B");
		box.addItem("O");
		box.addItem("AB");		
		
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
		String blood=(String)box.getSelectedItem(); // 모델에서 제외
		String msg = null;
		if(blood.equals("A")){
			msg="신중하고 꼼꼼함";
		} else if (blood.equals("B")){
			msg="자유롭고 개성이 강함";
		} else if (blood.equals("O")){
			msg="외향적이고 리더십이 강함";
		} else if (blood.equals("AB")){
			msg="이성적이고 독특함";
		}
		JOptionPane.showMessageDialog(this, msg); // 모델에서 제외
	}
	
	public static void main(String[] args) {
		new BloodWin();
	}
}
