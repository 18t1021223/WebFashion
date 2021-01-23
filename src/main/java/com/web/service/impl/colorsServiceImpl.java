package com.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.colors;
import com.web.repository.colorsRepository;
import com.web.service.colorsService;

@Service
public class colorsServiceImpl implements colorsService {
	@Autowired
	private colorsRepository colorsRepository;

	@Override
	public colors findById(long colorId) {
		Optional<colors> c = colorsRepository.findById(colorId);
		return c.isPresent() ? c.get() : null;
	}

	@Override
	public List<colors> findByProductId(long productId) {
		return colorsRepository.findByProductId(productId);
	}
}
