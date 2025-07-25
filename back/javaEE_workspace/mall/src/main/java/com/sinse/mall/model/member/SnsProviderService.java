package com.sinse.mall.model.member;

import java.util.List;

import com.sinse.mall.domain.SnsProvider;

public interface SnsProviderService {
	public List selectAll();
	public SnsProvider selectByName(String name);
}
