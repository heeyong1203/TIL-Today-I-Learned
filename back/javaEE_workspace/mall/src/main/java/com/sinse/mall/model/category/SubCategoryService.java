package com.sinse.mall.model.category;

import java.util.List;

import com.sinse.mall.domain.SubCategory;

public interface SubCategoryService {
	public List selectAll();
	public List selectByTopCategoryId(int topcategory_id);
	public SubCategory select(int subcategory_id);
}
