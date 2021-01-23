package com.web.service;

import java.util.List;

import com.web.entity.districts;

public interface districtService {
	List<districts> findByProvinceId(int provinceId);
}
