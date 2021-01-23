package com.web.service;

import org.springframework.stereotype.Service;

import com.web.entity.images;
@Service
public interface imagesService {

	images getImage(long productId);
}
