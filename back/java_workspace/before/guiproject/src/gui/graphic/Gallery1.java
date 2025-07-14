package gui.graphic;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Gallery1 extends JFrame implements ActionListener{
	JPanel p_north;
	JButton bt_prev;
	JButton bt_next;
	JLabel la_title;
	Toolkit kit; // 시스템의 이미지를 개발자 대신 얻어주는 객체
	MyCanvas myCanvas;
	
	// 이미지를 위한 배열 생성
	// 자바스크립트와는 달리 대부분의 언어는 배열이 고정배열
	// 반드시!! 배열 선언 시 그 크기를 명시해야만 함
	Image[] imgArray=new Image[10];	
	int index=0; // 이미지 배열을 접근하기 위한 인덱스... 즉 몇 번째 이미지를 보고 싶은지 결정해 줌
	
	public Gallery1(){
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		la_title = new JLabel("사진"+(index+1));
		myCanvas =new MyCanvas();
		kit = Toolkit.getDefaultToolkit(); // 툴킷의 인스턴스 얻기, 클래스 메서드
		
		// 스타일 적용
		myCanvas.setBackground(Color.YELLOW);
		
		//북쪽 패널에 버튼과 라벨 부착
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		//북쪽 패널을 프레임의 북쪽에 부착
		add(p_north,BorderLayout.NORTH);
		
		//중앙 패널을 프레임의 중앙에 부착
		add(myCanvas);
		
		// 초기 이미지 보여주기
		createImage();
		
		// 패널에 이미지 초기 이미지 한 개를 전달해주자
		myCanvas.setImage(imgArray[index]); // 이미지 전달...
		
		// 이전버튼 리스너 연결
		bt_prev.addActionListener(this);
		// 다음버튼 리스너 연결
		bt_next.addActionListener(this);
		
		//윈도우 크기
		setSize(600,500);
		setVisible(true);
	}
	
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
		// 그래픽 프로그래밍에서 컴포넌트의 약간의 변화라도 생기면 그 그림은 지워지고 다시 그려져야 하는데,
		// 개발자가 처리하는 것이 아닌 시스템이 알아서 렌더링을 담당하게 됨
		// 컴포넌트에 변경이 생기면 다음의 과정을 거쳐서 그래픽이 구현된다
		/*
		[AWT]
		최초 컴포넌트 등장 시 paint()에 의해 눈에 보여짐
		사용자가 컴포넌트 그림에 변화를 주게 되면, JVM은 기존 그림을 지워기 위해 update() 메서드를 컴퓨터 스스로 호출하여 그림을 깨끗이 지움.. 
		그리고 내부적으로 paint() 메서드 재호출하여 변경된 그림을 화면에 보여줌
		
		[Swing]
		사용자가 컴포넌트에 변화를 주게되면 update() 메서드가 호출되는 것이 아니라 paintComponent()를 호출하여 화면을 깨끗이 지움...
		변경된 그림을 다시 보여주기 위해 스스로 paint() 메서드를 호출함
		
		*/
		public void showImage(){
			if (index<0) {
				index=0;
			}else if(index>imgArray.length-1) {
				index=imgArray.length-1;
			}
			// index++; // 다음 사진일 경우 인덱스 증가
			myCanvas.setImage(imgArray[index]);
			// 변경된 이미지를 보기 위해서는 사용자의 윈도우 조작이 아니라, 프로그래밍적으로 지우고 다시 그릴 것을 요청해야 함
			// 이 때 호출할 수 있는 메서드는 repaint(), 즉 다시 그려줄 것을 부탁하는 메서드임
			// 개발자는 절대로 paint()를 직접 호출해서는 안됨
			// 그림은 시스템이 알아서 그리기 때문
			// repaint() → update() [awt]					 -----> paint()
			//				 → paintComponent() [swing]	--> paint()
			la_title.setText("사진"+(index+1));
			myCanvas.repaint();
		}
	
	public void actionPerformed(ActionEvent e){
		// 이벤트를 일으킨 컴포넌트를 가리켜 이벤트 소스라 한다.
		Object obj=e.getSource();
		
		// 버튼 인스턴스의 주소값만 비교하면 되므로, 굳이 형변환 필요 없음
		if(obj==bt_prev){ // 이전 버튼이라면...
			index--;
			showImage();
		}else if(obj==bt_next){ // 다음 버튼이라면...
			index++;
			showImage();
		}
	}
	
	// 공부 목적 상, 프레임의 그림을 뺏어서 그려보자
	/*
	public void paint(java.awt.Graphics g){
		System.out.println("나 그려짐");
	}
	*/
	public static void main(String[] args) {
		new Gallery1();
	}
}