package com.sinse.mall.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinse.mall.domain.TopCategory;


@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	
	@Qualifier("hibernateTopCategoryDAO")
	@Autowired
	TopCategoryDAO topCategoryDAO;
	
	@Transactional
	public List selectAll() {
		return topCategoryDAO.selectAll();
	}

	@Override
	public TopCategory select(int topcategory_id) {
		return topCategoryDAO.select(topcategory_id);
	}

}
