package com.sinse.mall.model.member;

import java.util.List;

import com.sinse.mall.domain.SnsProvider;

public interface SnsProviderDAO {
	public List selectAll();
	public SnsProvider selectByName(String name);
}
