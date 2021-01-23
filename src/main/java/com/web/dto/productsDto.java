package com.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.web.converted.categoriesConverted;
import com.web.entity.colors;
import com.web.entity.images;
import com.web.entity.products;
import com.web.entity.sizes;

public class productsDto {
	private long productId;

	private String productName;

	private double productPrice;

	private double productDiscount;

	private String productTitle;

	private String description;

	private boolean productNew;

	private boolean productHighLight;

	private boolean productStatus;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	private String productImage;

	private categoriesDto category;

	private List<images> images;

	private List<colors> colors;

	private List<sizes> sizes;

	// =========================================================
	public productsDto() {

	}

	public productsDto(products p) {
		super();
		this.productId = p.getProductId();
		this.productName = p.getProductName();
		this.productPrice = p.getProductPrice();
		this.productDiscount = p.getProductDiscount();
		this.productTitle = p.getProductTitle();
		this.description = p.getDescription();
		this.productNew = p.isProductNew();
		this.productHighLight = p.isProductHighLight();
		this.productStatus = p.isProductStatus();
		this.createTime = p.getCreateTime();
		this.updateTime = p.getUpdateTime();
		this.productImage = p.getProductImage();
		this.category = categoriesConverted.EntityToDto(p.getCategory());
		this.images = p.getImages();
		this.colors = p.getColors();
		this.sizes = p.getSizes();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isProductNew() {
		return productNew;
	}

	public void setProductNew(boolean productNew) {
		this.productNew = productNew;
	}

	public boolean isProductHighLight() {
		return productHighLight;
	}

	public void setProductHighLight(boolean productHighLight) {
		this.productHighLight = productHighLight;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public categoriesDto getCategory() {
		return category;
	}

	public void setCategory(categoriesDto category) {
		this.category = category;
	}

	public List<images> getImages() {
		return images;
	}

	public void setImages(List<images> images) {
		this.images = images;
	}

	public List<colors> getColors() {
		return colors;
	}

	public void setColors(List<colors> colors) {
		this.colors = colors;
	}

	public List<sizes> getSizes() {
		return sizes;
	}

	public void setSizes(List<sizes> sizes) {
		this.sizes = sizes;
	}

}
