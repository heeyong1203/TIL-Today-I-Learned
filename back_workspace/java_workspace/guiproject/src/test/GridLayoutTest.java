/*
GridLayout : 행과 열을 지원하는 배치 방법
*/
package test;

import java.awt.*;

class GridLayoutTest{
	public static void main(String[] args){
		Frame f = new Frame("그리드 배치");
		
		f.setLayout(new GridLayout(3,4));
		for(int j=3; j>1; j--){
			for(int i=1; i<4; i++){
				Button bt = new Button(j+"0"+i+"호");
				
				// Color 클래스가 보유한 YELLOW 상수(static)
				bt.setBackground(Color.YELLOW);
				f.add(bt);
				
			}
		}
		
		f.setSize(200,400);
		f.setVisible(true);
	}
}