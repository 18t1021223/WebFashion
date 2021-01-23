package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.districts;
import com.web.repository.districtRepository;
import com.web.service.districtService;

@Service
public class districtServiceImpl implements districtService {
	@Autowired
	private districtRepository districtRepository;

	@Override
	public List<districts> findByProvinceId(int provinceId) {
		return districtRepository.findByProvinceId(provinceId);
	}

}
