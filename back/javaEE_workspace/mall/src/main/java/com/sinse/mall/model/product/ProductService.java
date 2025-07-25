package com.sinse.mall.model.product;

import java.util.List;

import com.sinse.mall.domain.Product;

public interface ProductService {
	public void regist(Product product, String savePath);  //단순 sql insert + 파일업로드, 트랜잭션
	public List selectAll();
	public Product select(int product_id);
	public void edit(Product product);
	public void delete(Product product);
	
	public void remove(Product product, String savePath); //상품 등록과정에서 트랜잭션으로 처리할 수 없는 파일 삭제 처리
	
}
