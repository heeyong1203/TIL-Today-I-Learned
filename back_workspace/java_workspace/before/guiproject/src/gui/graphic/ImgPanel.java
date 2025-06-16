/*
컴포넌트 중 주로 컨테이너형은 아무것도 그려지지 않은 투명도화지 같기 때문에 개발자가 커스터마이징 하기에 매우 좋음
JPanel, Canvas 등...  JFrame도 가능은 함...
*/
package gui.graphic;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Font;

public class ImgPanel extends JPanel{
	// 이미지를 얻는 것은 개발자의 능력밖이므로, 시스템상의 이미지를 대신 구해주는 객체를 통해
	// 추상클래스인 Image 객체의 인스턴스를 얻어와 보자.
	Toolkit kit=Toolkit.getDefaultToolkit(); // 이미지를 개발자 대신 얻어옴...
	Image image; // 추상 클래스이므로, 툴킷으로부터 얻어오자
	
	public ImgPanel(){
		setBackground(Color.YELLOW);
		
		// 그림을 그리기 전에, 이미지를 먼저 얻어두자
		image = kit.getImage("E:/Lecture_workspace/back_workspace/java_workspace/guiproject/res/geographic10.jpg");
		
		// 270*350 크기 지정
		this.setPreferredSize(new Dimension(270, 350));
	}
	
	// 패널이 보유한 그리기 메서드를 재정의한다
	// 붓에 해당됨
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, this); // 이미지 그리기
		
		// 페인트통 교체 (팔레트 색상 선택)
		g.setColor(Color.red);
		
		// 선 그리기
		g.drawLine(100, 0, 50, 200);
		
		// 타원 그리기
		g.drawOval(0,0,50,50);
		
		// 글씨 그리기
		g.setColor(Color.blue);
		g.setFont(new Font("Gulim", Font.BOLD, 20));
		g.drawString("난 그래픽 텍스트야", 50,100);
		
		// 사각형 그리기
		g.setColor(Color.black);
		g.drawRect(150,250,100,100);
	}
}