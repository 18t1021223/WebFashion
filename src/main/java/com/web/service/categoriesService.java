package com.web.service;

import java.util.List;

import com.web.dto.categoriesDto;
import com.web.entity.categories;

public interface categoriesService {
	List<categories> findByParentId(int parentId);

	categories findById(int categoryId);

	List<categories> findAll();

	/**
	 * 
	 * @param data  : dữ liệu toàn bộ categories
	 * @param id
	 * @param level
	 * @return trả về danh sách categories đã đc phân cấp
	 */
	List<categoriesDto> getSubCategories(List<categories> data, int id, int level);

}
