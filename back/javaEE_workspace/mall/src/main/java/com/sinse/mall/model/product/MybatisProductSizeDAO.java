package com.sinse.mall.model.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.ProductSize;
import com.sinse.mall.exception.ProductSizeException;

@Repository
public class MybatisProductSizeDAO implements ProductSizeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(ProductSize productSize) throws ProductSizeException {
		int result = sqlSessionTemplate.insert("ProductSize.insert", productSize);
		
		//result=0; //고의 예외 유발! transaction 적용 확인 테스트
		
		if(result<1) {
			throw new ProductSizeException("상품의 지원 사이즈 등록 실패");
		}
	}
	
}
