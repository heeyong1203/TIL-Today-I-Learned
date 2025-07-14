/*
패널에 그림을 그리기 위해... 즉 paint() 메서드를 재정의 하기 위해
JPanel은 컨테이너형이므로, 내부에 그림이 없음... 따라서 재정의하기 좋음
*/

package gui.graphic;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class GalleryPanel extends JPanel{
	Image image;
	// 1) 이미지를 넘겨받을 메서드를 선언하자
	public void setImage(Image image){
		this.image=image;
	}
	
	// 2)  프레임을 보유하면, 프레임이 보유한 배열도 사용 가능함
	
	public void paint(Graphics g){
		// 이미지 그리기
		// (이미지 추상클래스인스턴스, x, y, width, height, observer)
		// ImageObserver? 이미지를 로드는 비동기이기 때문에 이미지가 완료되지 않은 상황에서,
		// 옵저버에 의해 이미지가 완전히 로드될 수 있도록 내부적인 처리가 지원되는데, 
		// 이 때 옵저버 역할을 수행할 객체를 개발자가 선택할 수 있는데
		// JPanel은 ImageObserver 인터페이스를 구현한 객체이므로, 옵저버 역할이 가능함
		g.drawImage(image, 0, 0, 600, 450, this);
	}
}