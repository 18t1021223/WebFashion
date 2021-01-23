package com.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.images;
import com.web.repository.imagesRepository;
import com.web.service.imagesService;

@Service
public class imagesServiceImpl implements imagesService {
	@Autowired
	private imagesRepository imagesRepository;

	@Override
	public images getImage(long productId) {
		List<images> i = imagesRepository.findByProducId(productId);
		return i.size() > 0 ? i.get(0) : null;
	}

}
