package com.sinse.mall.model.order;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.Cart;
import com.sinse.mall.exception.CartException;

@Repository
public class MybatisCartDAO implements CartDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Cart cart) throws CartException {
		int result = sqlSessionTemplate.insert("Cart.insert", cart);
		if(result<1) {
			throw new CartException("장바구니 등록에 실패하였습니다");
		}
	}
}
