package gui.graphic;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Image;

public class Gallery extends JFrame{
	GalleryButton bt_prev;
	GalleryButton bt_next;
	GalleryPanel p_north;
	GalleryPanel p_center;
	GalleryLabel la_title;
	Toolkit kit; // 시스템의 이미지를 개발자 대신 얻어주는 객체

	// 이미지를 위한 배열 생성
	// 자바스크립트와는 달리 대부분의 언어는 배열이 고정배열
	// 반드시!! 배열 선언 시 그 크기를 명시해야만 함
	Image[] imgArray=new Image[10];	
	
	
	public Gallery(){
		bt_prev = new GalleryButton("◀");
		bt_next = new GalleryButton("▶");
		p_north = new GalleryPanel();
		la_title = new GalleryLabel("제목");
		p_center = new GalleryPanel();
		kit = Toolkit.getDefaultToolkit(); // 툴킷의 인스턴스 얻기, 클래스 메서드
		
		// 스타일 적용
		p_center.setBackground(Color.YELLOW);
		
		p_north.add(bt_prev);
		p_north.add(bt_next);
		p_north.add(la_title);
		
		// 북쪽 패널을 프레임의 북쪽에 부착
		add(p_north, BorderLayout.NORTH);
		
		// 중앙 패널을 프레임의 중앙에 부착
		add(p_center);
		
		// 초기 이미지 보여주기
		createImage();
		
		// 패널에 이미지 초기 이미지 한 개를 전달해주자
		GalleryPanel.setImage(imgArray[0]); // 이미지 전달...
		
		// 윈도우 크기
		setSize(800,600);
		setVisible(true);
		
		// 멤버변수로 선언된 이미지 배열에, 이미지 인스턴스 10개를 준비해두어야
		// 프로그램 가동과 동시에 사용자가 사용할 수 있음
		public void createImage(){
			String[] path={
				"geographic1",
				"geographic2",
				"geographic3",
				"geographic4",
				"geographic5",
				"geographic6",
				"geographic7",
				"geographic8",
				"geographic9",
				"geographic10"
			};
			
			for(int i=0;i<path.length;i++){
				// 툴킷으로부터 이미지인스턴스 10개를 생성하여 image 배열에 넣어주기
				imgArray[i]=kit.getImage("E:/Lecture_workspace/back_workspace/java_workspace/guiproject/res/geographic/"+path[i]+".jpg");
			}
				

		}
		
		// p_center 영역에 이미지 출력하기
		public void showImage(){
			
		}
		
	}
	
	public static void main(String[] args){
		new Gallery();
	}
}