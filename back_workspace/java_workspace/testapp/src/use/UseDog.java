/*
	다른 클래스를 사용하기 위한 클래스이므로, 실행부를 정읳자ㅏ
*/
package use; // 개발자가 패키지를 선언하면 javac -d 옵션 사용 시 
					   // 선언한 패키지에 해당하는 디렉토리를 자동 생성해준다.

/*
import E:\Lecture_workspace\back_workspace\java_workspace\testapp\bin\animal\Dog;
os에 따라 경로가 달라질 수 있으므로, 환경변수를 이용해야 함 
animal이 패키지이기 때문에, 패키지의 상위 디렉토리들은 환경변수로 등록
*/
import animal.Dog; // classpath 환경변수를 기준으로.. 그 밑의 animal 밑의 Dog.class를 임포트 한다.
class UseDog {
	public static void main(String[] args) {
		Dog d= new Dog();
		d.bark();
	}
	
}