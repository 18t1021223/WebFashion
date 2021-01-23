package com.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.sizes;
import com.web.repository.sizesRepository;
import com.web.service.sizesService;

@Service
public class sizesServiceImpl implements sizesService {
	@Autowired
	private sizesRepository sizesRepository;

	@Override
	public sizes findById(long sizeId) {
		Optional<sizes> s = sizesRepository.findById(sizeId);
		return s.isPresent() ? s.get() : null;
	}

	@Override
	public List<sizes> findByProductId(long productId) {
		return sizesRepository.findByProductId(productId);
	}

}
