package com.sinse.wms;

import javax.swing.JFrame;

import com.sinse.wms.common.view.Page;

public class AppMain extends JFrame{
	
		
	public AppMain() {
		
		
		// 페이지 확인
		new Page(this);
		
		setSize(1440, 960);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // db 연동 시 해제
	}
	
	// public void showPage(JPanel panel){
		//add(panel);
	//}
	
	
	public static void main(String[] args) {
		new AppMain();
	}
}