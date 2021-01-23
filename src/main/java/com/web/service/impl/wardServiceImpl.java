package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.wards;
import com.web.repository.wardRepository;
import com.web.service.wardService;

@Service
public class wardServiceImpl implements wardService {
	@Autowired
	private wardRepository wardRepository;

	@Override
	public List<wards> findByDistrictId(int districtId) {
		return wardRepository.findByDistrictId(districtId);
	}

}
