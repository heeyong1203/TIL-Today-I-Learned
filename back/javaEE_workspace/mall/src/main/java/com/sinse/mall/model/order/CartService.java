package com.sinse.mall.model.order;

import com.sinse.mall.domain.Cart;

public interface CartService {
	public void regist(Cart cart); //db뿐 아니라 기타 업무를 수행할 수도 있기 때문에 insert보단 더 광범위한 명칭을 주는 것이 좋다.
	
}
