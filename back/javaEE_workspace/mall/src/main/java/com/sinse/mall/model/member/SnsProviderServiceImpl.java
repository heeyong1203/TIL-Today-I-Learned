package com.sinse.mall.model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinse.mall.domain.SnsProvider;

@Service
public class SnsProviderServiceImpl implements SnsProviderService{
	
	@Autowired
	private SnsProviderDAO snsProviderDAO;
	
	@Override
	public List selectAll() {
		return snsProviderDAO.selectAll();
	}
	
	@Override
	public SnsProvider selectByName(String name) {
		return snsProviderDAO.selectByName(name);
	}
}
