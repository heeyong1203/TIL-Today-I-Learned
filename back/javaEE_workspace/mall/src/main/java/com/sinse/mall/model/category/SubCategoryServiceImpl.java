package com.sinse.mall.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinse.mall.domain.SubCategory;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	
	@Qualifier("mybatisSubCategoryDAO")
	@Autowired
	private SubCategoryDAO subCategoryDAO;
	
	@Transactional
	public List selectAll() {
		return subCategoryDAO.selectAll();
	}
	
	@Override
	public List selectByTopCategoryId(int topcategory_id) {
		return subCategoryDAO.selectByTopCategoryId(topcategory_id);
	}

	@Override
	public SubCategory select(int subcategory_id) {
		return subCategoryDAO.select(subcategory_id);
	}

}
