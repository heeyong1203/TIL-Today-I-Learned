package com.sinse.mall.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.TopCategory;

@Qualifier("mybatisTopCategoryDAO")
@Repository
public class MybatisTopCategoryDAO implements TopCategoryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("TopCategory.selectAll");
	}

	@Override
	public TopCategory select(int topcategory_id) {
		return sqlSessionTemplate.selectOne("TopCategory.select", topcategory_id);
	}

}
