package com.web.service;

import java.util.List;

import com.web.entity.sizes;

public interface sizesService {
	/**
	 * 
	 * @param sizeId
	 * @return trả về 1 size hoac null
	 */
	sizes findById(long sizeId);
	
	List<sizes> findByProductId(long productId);
}
