package com.sinse.mall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinse.mall.domain.Product;
import com.sinse.mall.domain.ProductColor;
import com.sinse.mall.domain.ProductImg;
import com.sinse.mall.domain.ProductSize;
import com.sinse.mall.exception.ProductColorException;
import com.sinse.mall.exception.ProductException;
import com.sinse.mall.exception.ProductImgException;
import com.sinse.mall.exception.ProductSizeException;
import com.sinse.mall.exception.UploadException;
import com.sinse.mall.util.FileManager;

@Service //서비스는 모델 영역의 객체이기는 하나, 직접 일하지 않고 주로 객체들에게 일을 할당한다. (service가 없을 경우 Controller가 복잡해짐. 이를 의무 오버래핑이라고 함)
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductColorDAO productColorDAO;
	
	@Autowired
	private ProductSizeDAO productSizeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ProductImgDAO productImgDAO;
	
	//상품등록+색상등록+사이즈등록+이미지등록+파일저장
	@Transactional  //아래의 DAO가 가진 DML 메서드 중 한 하나라도 Exception이 발생되면 
							//스프링이 알아서 rollback
	public void regist(Product product, String savePath) throws ProductException, ProductColorException, ProductSizeException, ProductImgException, UploadException {
		//1) 상품 등록 후, product_id 취득, mybatis selectkey에  의해 자동으로 채워져있음
		productDAO.insert(product);
		
		//2) 유저가 선택한 색상 수 만큼 반복문으로 insert 수행
		for(ProductColor productColor : product.getColorList()) {
			//누락되어 있었던 product 을 대입해주자 
			productColor.setProduct(product); //mybatis에 의해 pk가 채워진 product 대입
			productColorDAO.insert(productColor);
		}
		
		//3)유저가 선택한 사이즈 수 만큼 반복문을 insert 수행 
		for(ProductSize  productSize : product.getSizeList()) {
			productSize.setProduct(product);
			productSizeDAO.insert(productSize);
		}
		
		//4) 이미지 저장 
		fileManager.save(product, savePath);
		
		//5) 이미지 파일명도 채워진 상태이므로 db 저장
		List<ProductImg> imgList =  product.getImgList(); 
			for(ProductImg productImg : imgList) {
			productImg.setProduct(product);
			productImgDAO.insert(productImg);
		}
	}
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}
	
	@Override
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}
	
	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void remove(Product product, String savePath) {
		fileManager.remove(product, savePath);
	}
}
