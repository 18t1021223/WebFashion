package com.web.service;

import java.util.List;

import com.web.entity.colors;

public interface colorsService {
	colors findById(long colorId);

	List<colors> findByProductId(long productId);
}
