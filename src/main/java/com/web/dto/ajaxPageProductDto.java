package com.web.dto;

import java.util.List;
import java.util.Locale.Category;

import com.web.entity.categories;
import com.web.entity.products;

public class ajaxPageProductDto {
	/**
	 * CHỨA DANH SÁCH CÁC DANH MỤC CHA CỦA DANH MỤC CON
	 */
	private List<categories> parentCategories;

	/**
	 * CHỨA DANH MỤC CHA CUỐI CÙNG
	 */
	private categories category;

	/**
	 * DANH SÁCH CÁC DANH MỤC CON CỦA DANH MỤC CHA
	 */
	private List<categories> subCategories;

	/**
	 * TỔNG SẢN PHẨM
	 */
	private long totalProduct;

	/**
	 * THÔNG TIN ĐỐI TƯỢNG PHÂN TRANG
	 */
	private paginateDto pag;

	/**
	 * CHỨA DANH SÁCH SẢN PHẨM THEO PHÂN TRANG
	 */
	private List<products> products;

	/**
	 * convert categories ->
	 */
	private List<categoriesDto> categoryDto;

	private List<categoriesDto> subCategoriesDto;

	private String keywordSearch;

	public ajaxPageProductDto() {
		// TODO Auto-generated constructor stub
	}

	public String getKeywordSearch() {
		return keywordSearch;
	}

	public void setKeywordSearch(String keywordSearch) {
		this.keywordSearch = keywordSearch;
	}

	public List<categoriesDto> getCategoryDto() {
		return categoryDto;
	}

	public List<categoriesDto> getSubCategoriesDto() {
		return subCategoriesDto;
	}

	/**
	 * CHỨA DANH SÁCH DANH MỤC CON , CONVERTED TỪ CATEGORIES
	 * 
	 * @param subCategoriesDto
	 */
	public void setSubCategoriesDto(List<categoriesDto> subCategoriesDto) {
		this.subCategoriesDto = subCategoriesDto;
	}

	/**
	 * DÙNG KHI SỬ DỤNG AJAX ĐỂ CONVERT CATEGORIES -> CATEGORYDTO
	 * 
	 * @param categoryDto
	 */
	public void setCategoryDto(List<categoriesDto> categoryDto) {
		this.categoryDto = categoryDto;
	}

	public List<categories> getParentCategories() {
		return parentCategories;
	}

	public void setParentCategories(List<categories> parentCategories) {
		this.parentCategories = parentCategories;
	}

	public categories getCategory() {
		return category;
	}

	public void setCategory(categories category) {
		this.category = category;
	}

	public List<categories> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<categories> subCategories) {
		this.subCategories = subCategories;
	}

	public long getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(long totalProduct) {
		this.totalProduct = totalProduct;
	}

	public paginateDto getPag() {
		return pag;
	}

	public void setPag(paginateDto pag) {
		this.pag = pag;
	}

	public List<products> getProducts() {
		return products;
	}

	public void setProducts(List<products> products) {
		this.products = products;
	}

}
