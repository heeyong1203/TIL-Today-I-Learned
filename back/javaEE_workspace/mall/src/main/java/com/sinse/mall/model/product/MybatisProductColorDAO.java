package com.sinse.mall.model.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.ProductColor;
import com.sinse.mall.exception.ProductColorException;

@Repository //구현체이므로 선언해주어야 한다.
public class MybatisProductColorDAO implements ProductColorDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(ProductColor productColor) throws ProductColorException {
		int result = sqlSessionTemplate.insert("ProductColor.insert", productColor);
		if(result<1) {
			throw new ProductColorException("상품의 지원 색상 등록 실패");
		}
	}

}
