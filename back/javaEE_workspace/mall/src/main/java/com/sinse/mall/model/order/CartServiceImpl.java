package com.sinse.mall.model.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinse.mall.domain.Cart;
import com.sinse.mall.exception.CartException;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void regist(Cart cart) throws CartException {
		cartDAO.insert(cart);
	}
	
}
