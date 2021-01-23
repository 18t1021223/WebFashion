package com.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.categoriesDto;
import com.web.entity.categories;
import com.web.repository.categoriesRepository;
import com.web.service.categoriesService;

@Service
public class categoriesServiceImpl implements categoriesService {

	@Autowired
	private categoriesRepository categoriesRepository;

	@Override
	public List<categories> findByParentId(int parentId) {
		return categoriesRepository.findByParentId(parentId);
	}

	@Override
	public List<categories> findAll() {
		return categoriesRepository.findAll();
	}

	@Override
	public List<categoriesDto> getSubCategories(List<categories> data, int id, int level) {
		List<categoriesDto> kq = new ArrayList<>();
		for (categories c : data) {
			if (c.getParentId() == id) {
				kq.add(new categoriesDto(c.getCategoryId(), c.getCategoryName(), c.getParentId(), level));
				List<categoriesDto> child = getSubCategories(data, c.getCategoryId(), level + 1);
				kq.addAll(child);
			}
		}
		return kq;
	}

	@Override
	public categories findById(int categoryId) {
		Optional<categories> o = categoriesRepository.findById(categoryId);
		return o.isPresent() ? o.get() : null;
	}
	
	
}
