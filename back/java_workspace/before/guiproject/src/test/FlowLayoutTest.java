package test;
/*
FlowLayout : 흐르는 배치 방법
*/
import java.awt.*;

class FlowLayoutTest{
	public static void main(String[] args){
		Frame f = new Frame("FlowLayout 배치 방식");
		
		// 아무것도 명시하지 않으면, 컨테이너류 디폴트 배치 관리자가 적용되는데, frame의 경우 디폴트는 BorderLayout임
		// BorderLayout 내에 배치된 컴포넌트는 Frame의 경계선까지 확장
		// FlowLayout은 컴포넌트 본연의 크기를 유지해줌
		
		f.setLayout(new FlowLayout());
		
		for(int i=0;i<20;i++){
			f.add(new Button(i+"번 째 버튼"));
		}
	
	f.setSize(200,250);
	f.setVisible(true);
	}

}