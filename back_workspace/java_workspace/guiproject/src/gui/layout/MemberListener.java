package gui.layout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class MemberListener implements ActionListener{
	JoinForm joinForm;
	Button bt_login;
	Button bt_join;
	
	// 누군가가 이 객체를 생성할 때 호출하는 생성자 호출로 매개변수값을 받아오자
	// 즉 가입버튼과 로그인버튼을 받아내자
	public MemberListener(JoinForm joinForm, Button bt_login, Button bt_join){
		this.joinForm=joinForm;
		this.bt_login=bt_login;
		this.bt_join=bt_join;
	}
	
	// 오버라이딩
	public void actionPerformed(ActionEvent e){
		Button bt=(Button)e.getSource(); // 이벤트를 일으킨 컴포넌트가 반환 Object 형으로 반환됨
		// ActionEvent는 버튼만 일으킬 수 있는 것이 아니라 
		// 클릭이 가능한 거의 모든 컴포넌트가 Action이 적용될 수 있음
		// 따라서 Button이 국한되지 않는 상위 자료형으로 받아버린다.
		JoinForm joinForm=(JoinForm)e.getSource();
		
		if(bt==bt_login){
			System.out.println("로그인 버튼 누름");
			joinForm.checkForm();
		}else if(bt==bt_join){
			System.out.println("가입 버튼 누름");
			joinForm.checkForm();
		}
	}
}