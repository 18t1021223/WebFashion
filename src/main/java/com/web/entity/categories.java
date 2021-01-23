package com.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
public class categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	@Column(columnDefinition = "nvarchar(100) not null")
	private String categoryName;

	@Column(columnDefinition = "int default(0) not null")
	private int parentId;

	// =========================================================
	@JsonIgnore
	/* đánh dấu khoong đc tuần tự hóa */
	@OneToMany(mappedBy = "category", cascade = { CascadeType.PERSIST })
	private List<products> products;
	// =========================================================

	public categories() {
		// TODO Auto-generated constructor stub
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

	public List<products> getProducts() {
		return products;
	}

	public void setProducts(List<products> products) {
		this.products = products;
	}

}
