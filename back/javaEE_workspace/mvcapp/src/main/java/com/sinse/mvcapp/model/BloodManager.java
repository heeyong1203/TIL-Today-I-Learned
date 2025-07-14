package com.sinse.mvcapp.model;

public class BloodManager {
	public String getAdvice(String blood) {
		
		String msg = "";
		if(blood.equals("A")){
			msg="신중하고 꼼꼼함";
		} else if (blood.equals("B")){
			msg="자유롭고 개성이 강함";
		} else if (blood.equals("O")){
			msg="외향적이고 리더십이 강함";
		} else if (blood.equals("AB")){
			msg="이성적이고 독특함";
		}
		return msg;
	}
}
