/*
모든 GUI 프로그램은 컴포넌트들을 조합하여 화면을 구성하기 때문에,
각자의 배치(Layout)방법을 지원한다.

AWT의 배치방법은 다음과 같다.
1) BorderLayout
	 동, 서, 남, 북, 가운데(center)의 방위를 갖는 배치 방법
	 Frame은 개발자가 아무것도 지정하지 않으면, 디폴트로 BorderLayout 적용됨
	 
2) FlowLayout
	 
	 
3) GridLayout 
--------------------- 1)~3)으로 대부분 수행
4) GridBagLayout
*/
package test;

import java.awt.*;

class BorderLayoutTest{
	public static void main(String[] args){
		/*
		UI 컴포넌트는 다른 컴포넌트를 포함할 수 있는 능력을 기준으로 두 가지 유형으로 나뉨
		1) Container 유형 : 다른 컴포넌트를 포함할 수 있음 (html에서의 div, p...)
									  ex) Frame
									  배치 능력이 있으므로, 여러 유형의 배치관리자(Layout 종류 3가지)를 적용할 수 있음
		2) Visual 컴포넌트 :  컨테이너 안에 소속되는 대상 ex) Button, CheckBox, Choice... 
		*/
		
		Frame frame = new Frame(); // 윈도우 생성 
		BorderLayout border = new BorderLayout();

		// 프레임에 보더배치 적용
		frame.setLayout(border);
		
		Button bt_east = new Button("동쪽");
		Button bt_west = new Button("서쪽");
		Button bt_south = new Button("남쪽");
		Button bt_north = new Button("북쪽");
		Button bt_center = new Button("센터");
		
		frame.add(bt_north, BorderLayout.NORTH); // 북쪽에 버튼 부착
		frame.add(bt_south, BorderLayout.SOUTH); // 북쪽에 버튼 부착
		frame.add(bt_west, BorderLayout.WEST); // 북쪽에 버튼 부착
		frame.add(bt_east, BorderLayout.EAST); // 북쪽에 버튼 부착

		frame.add(bt_center); // 개발자가 방위 설정하지 않을 시, 센터임
		
		frame.setSize(500, 450);
		frame.setVisible(true);
	}
}