package com.web.converted;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.dto.categoriesDto;
import com.web.entity.categories;

@Repository
public class categoriesConverted {
	/**
	 * 
	 * @param t -DANH SÁCH CATEGORIES
	 * @return TRẢ VỀ DANH SÁCH DTO SAU KHI CONVERTED
	 */
	public static List<categoriesDto> EntityToDto(List<categories> t) {
		List<categoriesDto> data = new ArrayList<categoriesDto>();
		for (categories c : t) {
			data.add(new categoriesDto(c));
		}
		return data;
	}

	public static categoriesDto EntityToDto(categories c) {
		return new categoriesDto(c);
	}
}
