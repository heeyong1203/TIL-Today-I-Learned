package mvcproject.blood.model;

// MVC에서 모델은 비즈니스 로직이 구현된 코드이므로 재사용 대상이 된다. (자본..)
// MVC에서 개발자의 노력이 가장 많이 들어가는 영역
public class ColorManager {
	
	public ColorManager() {
	}
	
	public String getAdvice(String color) { // 제외 대상없이 모델로 재사용 가능
		// 혈액형에 대한 판단
		String msg = null;
		if(color.equals("red")){
			msg="열정적이고 활동적";
		} else if (color.equals("blue")){
			msg="신중하고 분석적";
		} else if (color.equals("yellow")){
			msg="낙천적이고 외향적";
		} else if (color.equals("green")){
			msg="온화하고 배려심 깊음";
		}
		return msg;
	}
}
