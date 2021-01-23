package com.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.web.entity.orders;
import com.web.entity.provinces;
import com.web.repository.provincesRepository;
import com.web.service.provinceService;

@Service
public class provinceServiceImpl implements provinceService {
	@Autowired
	provincesRepository prov;

	@Override
	public provinces findById(int provinceId) {
		Optional<provinces> rs = prov.findById(provinceId);
		return rs.isPresent() ? rs.get() : null;
	}

	@Override
	public List<provinces> findbyAll() {
		return prov.findAll(Sort.by(Sort.Direction.ASC, "provinceId"));
	}

}
