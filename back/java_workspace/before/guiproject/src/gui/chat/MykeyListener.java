public class MykeyListener{
	// KeyListener가 보유한 추상메서드를 재정의 {} 붙이자...
	
	// 키보드 눌럿다가 뗄 때
	public void keyReleased(KeyEvent e){
		System.out.println("눌렀다가 뗀거야?");
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void keyPressed(KeyEvent e){
		System.out.println("눌렀어?");
	}
}