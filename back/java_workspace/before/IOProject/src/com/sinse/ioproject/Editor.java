package com.sinse.ioproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Editor extends JFrame implements ActionListener{
	JMenuBar bar; // 눈에 보이지는 않지만, 메뉴들을 얹혀놓을 막대기 위치가 딱 정해져 있음
				  // 윈도우 창 상단 고정...
	JMenu[] menu = new JMenu[5]; // 메뉴는 없는 상태이며, 빈 공간만 존재
								 // 공간에는 JMenu만 허용함
	String[] menuTitle = {"파일(F)", "편집(E)","서식(O)","보기(V)", "도움말(H)"};
	JMenuItem[] item = new JMenuItem[8];
	String[] itemTitle = {"새로 만들기(N)","새 창(W)","열기(O)","저장(S)","다른 이름으로 저장(A)","페이지 설정(U)","인쇄(P)","끝내기(X)"};
	JTextArea area;
	JFileChooser chooser;
	
	// 메뉴의 이름이 너무 불편하다. (* 배열의 0번째, 1번째...).. 직관성 부여를 위해 상수를 정의
	public static final int FILE=0;
	public static final int EDIT=1;
	public static final int OBJECT=2;
	public static final int VIEW=3;
	public static final int HELP=4;
	
	public Editor() {
		bar = new JMenuBar();
		area = new JTextArea();
		
		// 메뉴 만들기
		for(int i=0;i<menu.length;i++) {
			menu[i] = new JMenu(menuTitle[i]);
		}
		// 메뉴 아이템 만들기
		for(int i=0;i<item.length;i++) {
			item[i] = new JMenuItem(itemTitle[i]);
		}
		
		// 메뉴 아이템들을 '파일' 메뉴에 부착
		for(int i=0;i<item.length;i++) {
			menu[FILE].add(item[i]);
			if(i==4||i==6) {
				menu[FILE].addSeparator();				
			}
		}
		area = new JTextArea();
		chooser = new JFileChooser("E:/Lecture_workspace/back_workspace/java_workspace");
		
		// 메뉴 바에 메뉴 부착
		for(int i=0;i<menu.length;i++) {
			bar.add(menu[i]);
		}
		
		// bar 부착
		this.setJMenuBar(bar);
		add(area);

		item[2].addActionListener(this); // 열기 버튼에 이벤트 연결
		item[item.length-1].addActionListener(this); // 끝내기 버튼에 이벤트 연결
		
		
		setBounds(2000, 100, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void openFile() {
		// 어떤 파일을 대상으로 열 것인지는 개발자가 아닌 사용자가 결정하므로, 새 창을 띄워주자
		int result=chooser.showOpenDialog(this);
		
		File file=null; // if문 안에 넣으면 아래 fis를 사용하지 못하기 때문
		if(result==JFileChooser.APPROVE_OPTION) { // 열기를 누르면
			// 유저가 선택한 파일을 얻어와서 스트림을 생성하자
			file=chooser.getSelectedFile(); // 파일을 줌
		}
		
		FileInputStream fis=null; // 파일을 대상으로 한 입력 스트림
		try {
			fis = new FileInputStream(file);
			// 파일의 끝까지 1byte씩 읽어가면서 area에 추가
			int data=-1;
			while(true) {
				data=fis.read(); // next 1byte를 읽음, wrapper클래스 고려
				if(data==-1)break;
				area.append(Character.toString((char)data));
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==item[2]) {
			openFile();
		}else if(JOptionPane.showConfirmDialog(this, "프로그램 종료하실건가요?")==JOptionPane.OK_OPTION) {
			if(e.getSource()==item[item.length-1]){
				System.exit(0); // 프로그래밍적으로 프로세스 종료
			}
		}
	}
	
	public static void main(String[] args) {
		new Editor();
	}
}
