package com.web.service;

import java.util.List;

import com.web.entity.provinces;


public interface provinceService {
	provinces findById(int provinceId);
	List<provinces> findbyAll();
}
