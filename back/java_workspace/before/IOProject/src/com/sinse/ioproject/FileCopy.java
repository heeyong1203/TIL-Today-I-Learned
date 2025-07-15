package com.sinse.ioproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileCopy extends JFrame implements ActionListener{
	JLabel la_ori;
	JLabel la_dest;
	JTextField t_ori;
	JTextField t_dest;
	JButton bt;
	
	public FileCopy() {
		la_ori = new JLabel("원본");
		la_dest = new JLabel("복사본");
		t_ori = new JTextField();
		t_dest = new JTextField();
		bt = new JButton("복사실행");

		setLayout(new FlowLayout());
		
		// 크기 지정
		la_ori.setPreferredSize(new Dimension(100, 20));
		t_ori.setPreferredSize(new Dimension(350, 20));
		la_dest.setPreferredSize(new Dimension(100, 20));
		t_dest.setPreferredSize(new Dimension(350, 20));
		
		// 컴포넌트 추가
		add(la_ori);
		add(t_ori);
		add(la_dest);
		add(t_dest);
		add(bt);
		
		// 버튼에 액션 리스너 등록
		bt.addActionListener(this);
		
		// 창 설정
		setSize(450, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	// 현재 실행중인 자바프로그램으로 파일을 읽어들여, 원하는 경로로 내뱉기 = '복사'
	public void copy() {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(t_ori.getText()); // 원본 스트림
			fos=new FileOutputStream(t_dest.getText()); // 복사본 스트림
			
			// 한 알갱이 마시고, 내뱉기
			int data=-1;

			while(true) {
				data=fis.read();
				if(data==-1) break;
				fos.write(data);
			}
			
			// 시각적으로 완료되었음을 알려주기
			JOptionPane.showMessageDialog(this, "복사완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 존재할 때만 닫기
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		copy();
	}
	
	public static void main(String[] args){
		new FileCopy();
	}
	
	
}
