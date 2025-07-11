package mvcproject.blood.model;

// MVC에서 모델은 비즈니스 로직이 구현된 코드이므로 재사용 대상이 된다. (자본..)
// MVC에서 개발자의 노력이 가장 많이 들어가는 영역
public class BloodManager {
	
	public BloodManager() {
	}
	
	public String getAdvice(String blood) { // 제외 대상없이 모델로 재사용 가능
		// 혈액형에 대한 판단
		String msg = null;
		
		if(blood!=null) {
			if(blood.equals("A")){
				msg="신중하고 꼼꼼함";
			} else if (blood.equals("B")){
				msg="자유롭고 개성이 강함";
			} else if (blood.equals("O")){
				msg="외향적이고 리더십이 강함";
			} else if (blood.equals("AB")){
				msg="이성적이고 독특함";
			}
		}
		return msg;
	}
}
