package com.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.constants.constants;
import com.web.converted.categoriesConverted;
import com.web.dto.ajaxPageProductDto;
import com.web.dto.categoriesDto;
import com.web.dto.paginateDto;
import com.web.entity.categories;
import com.web.service.categoriesService;
import com.web.service.paginatesService;
import com.web.service.productsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = { "/ajax" })
public class ajaxController {

	@Autowired
	private productsService prodService;
	@Autowired
	private categoriesService categoriesService;
	@Autowired
	private paginatesService pagService;

	@GetMapping(value = { "/product/category" })
	public ResponseEntity<?> pageProducts(@RequestParam(value = "categoryId") int categoryId,
			@RequestParam(value = "orderBy") int orderBy, @RequestParam(value = "page") int page,
			@RequestParam(value = "pageSize", defaultValue = constants.PAGE_SIZE_LIST
					+ "", required = false) int pageSize,
			@RequestParam(value = "productStatus", defaultValue = true + "", required = false) boolean productStatus,
			@RequestParam(value = "keywordSearch", defaultValue = "", required = false) String keywordSearch)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		ajaxPageProductDto ajax = new ajaxPageProductDto();

		/* THANH LINK */
		List<categories> parentCategory = prodService.getParentCategories(categoryId);
		/* DANH MUC CHA LẤY RA TỪ parentCategory CUỐI CÙNG */
		/* NẾU NHU DANH MỤC CHA KHÔNG CÓ (ID KHÔNG TÒN TẠI) THÌ BÁO LỖI */
		categories parent = parentCategory.size() > 0 ? parentCategory.get(parentCategory.size() - 1) : null;

		/*
		 * nếu danh mục cha của id rỗng nghĩa : nó là danh mục cha thứ 0 , lấy các danh
		 * mục con của categoryId truyền vào , nếu như nó rỗng thì nghĩa id đó là danh
		 * mục con cuối cùng -> lấy lại danh mục trước đó bằng parentId của nó,
		 */
		List<categories> subCategory = categoriesService.findByParentId(categoryId);
		if (parent != null && subCategory.size() == 0) {
			subCategory = categoriesService.findByParentId(parent.getParentId());
		}
		List<categoriesDto> subCategoryDto = categoriesConverted.EntityToDto(subCategory);
		ajax.setSubCategoriesDto(subCategoryDto);

		List<categoriesDto> convertDto = categoriesConverted.EntityToDto(parentCategory);
		ajax.setCategoryDto(convertDto);

		/* TỔNG SẢN PHẨM */
		ajax.setTotalProduct(prodService.count(categoryId, productStatus, keywordSearch));

		/* DANH SÁCH SẢN PHẨM */
		ajax.setProducts(prodService.getProducts(page, pageSize, orderBy, categoryId, productStatus, keywordSearch));

		/* PHÂN TRANG */
		paginateDto pag = pagService.getInfo(ajax.getTotalProduct(), page, pageSize, orderBy,
				constants.NUMBER_PAGE_VIEW);
		ajax.setPag(pag);

		/* keywordSearch */
		ajax.setKeywordSearch(keywordSearch);

		String json = mapper.writeValueAsString(ajax);
		return ResponseEntity.ok(json);
	}
}
