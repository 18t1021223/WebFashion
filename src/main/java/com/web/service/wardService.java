package com.web.service;

import java.util.List;

import com.web.entity.wards;

public interface wardService {
	List<wards> findByDistrictId(int districtId);
}
