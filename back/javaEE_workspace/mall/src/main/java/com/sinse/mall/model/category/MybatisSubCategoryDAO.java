package com.sinse.mall.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.SubCategory;

@Qualifier("mybatisSubCategoryDAO")
@Repository
public class MybatisSubCategoryDAO implements SubCategoryDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; //순수 Mybatis의 SqlSession과 동일한 역할을 한다.
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByTopCategoryId(int topcategory_id) {
		return  sqlSessionTemplate.selectList("SubCategory.selectByTopCategoryId", topcategory_id);
	}

	@Override
	public SubCategory select(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
