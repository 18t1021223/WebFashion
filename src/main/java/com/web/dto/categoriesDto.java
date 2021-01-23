package com.web.dto;

import com.web.entity.categories;

public class categoriesDto {
	private int categoryId;
	private String categoryName;
	private int parentId;
	private int level;

	public categoriesDto() {
		// TODO Auto-generated constructor stub
	}

	public categoriesDto(int categoryId, String categoryName, int parentId, int level) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.level = level;
	}

	public categoriesDto(categories category) {
		this.categoryId = category.getCategoryId();
		this.categoryName = category.getCategoryName();
		this.parentId = category.getParentId();
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
