package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.slides;
import com.web.repository.slidesRepository;
import com.web.service.slidesService;

@Service
public class slidesServiceImpl implements slidesService {
	@Autowired
	private slidesRepository slidesRepository;

	@Override
	public List<slides> findAll() {
		return slidesRepository.findAll();

	}
}
