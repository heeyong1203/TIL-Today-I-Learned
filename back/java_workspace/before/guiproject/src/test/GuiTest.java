/*
GUI = Graphic User Interface ; 그림으로 조작하는 프로그램(편함)
CLI = Command Line Interface ; cmd창과 같이 명령으로 조작하는 프로그램(불편함)

Java의 그래픽 관련 API는 java.awt 패키지에 들어 있음
모든 데스크탑 기반의 GUI 프로그램에서 최상단에 존재하는 그래픽 요소(컴포넌트)는 window이다.
java에서는 윈동는 상징적 존재에 불과하고 그 바로 하위의 Frame으로 대체함
*/
package test;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.FlowLayout;

class GuiTest{
	public static void main(String[] args){
	// html에서 요소들을 부모 컨테이너에 부착해야 하듯이 java도 마찬가지로 GUI적인 요소들을 윈도우라는 컨테이너에 부착해야 함(그래야 눈에 보임)
	// 윈도우 생성!!
	Frame f = new Frame(); // 일반 클래스? 추상 클래스? 인터페이스? // java docs api 홈페이지에서 확인해보니 일반 class임 // 생성자를 확인해보니 네 가지로 오버로딩 되어 있음
	
	// html 등에서 익숙하게 봐왔던 UI컴포넌트 요소들을 자바 버전으로 생성하여 확인해보자
	Button bt = new Button("나 버튼"); // button은 일반 클래스
	TextField t = new TextField(20); // TextField 역시 일반 클래스
	Choice ch1 = new Choice(); // Choice 역시 일반 클래스
	TextArea area = new TextArea(12,20);
	
	Checkbox[] chArray = new Checkbox[3]; // C, C3 등 고전적 프로그램은 생성 시 반드시 배열 크기 지정해야 함
	chArray[0] = new Checkbox("java", true); // true이면, check 표시가 된 채로 생성되고 false이면, check 표시가 해제된 채로 생성됨
	chArray[1] = new Checkbox("JSP", false);
	chArray[2] = new Checkbox("Oracle", true);
	for(int i=0; i<chArray.length; i++){
		f.add(chArray[i]);
	}
	
	Label la = new Label("제목 등 일반텍스트 입력");
	
	// 메뉴바와 메뉴 만들기
	Menu m_file, m_edit, m_style, m_view, m_help;
	m_file = new Menu("파일(F)");
	m_edit = new Menu("편집(E)");
	m_style = new Menu("서식(O)");
	m_view = new Menu("보기(V)");
	m_help = new Menu("도움말(H)");
	
	MenuBar bar = new MenuBar();
	
	// Frame에 Button 부착
	f.add(bt);
	f.add(t);
	f.add(ch1);
	f.add(area);
	f.add(la);
	f.setMenuBar(bar); // 윈도우에 메뉴바 부착
	bar.add(m_file);
	bar.add(m_edit);
	bar.add(m_style);
	bar.add(m_view);
	bar.add(m_help);
	
	// 버튼이 너무 크게 나오는 이유는, 아직 배치(레이아웃) 방법을 지정하지 않았기 때문 (default가 적용되어 있기 때문)
	f.setLayout(new FlowLayout());
	ch1.add("@google.com");
	ch1.add("@naver.com");
	ch1.add("@daum.net");
	
	// 자바의 윈도우를 사용하려면 너비, 높이 지정해야 함
	f.setSize(1500, 756);

	// 또한 윈도우의 default 보기 옵션은 비활성화 되어 있음 → 눈에 보이지 않음, 따라서 활성화가 필요함
	f.setVisible(true);
	}
}