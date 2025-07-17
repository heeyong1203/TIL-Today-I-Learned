package com.sinse.mall.model.category;

import java.util.List;

import com.sinse.mall.domain.TopCategory;

public interface TopCategoryDAO {
	
	public List selectAll();
	public TopCategory select(int topcategory_id);
}
