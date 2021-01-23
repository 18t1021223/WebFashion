package com.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
//@NamedStoredProcedureQuery(name = "proc_products_select", procedureName = "proc_products_select", parameters = {
//		@StoredProcedureParameter(mode = ParameterMode.IN,name = "page" ,type = Integer.class),
//		@StoredProcedureParameter(mode = ParameterMode.IN,name = "pageSize" ,type = Integer.class)
//} ,resultClasses = products.class)
public class products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint")
	private long productId;

	@Column(columnDefinition = "nvarchar(150) not null")
	private String productName;

	@Column(columnDefinition = "money not null")
	private double productPrice;

	@Column(columnDefinition = "money not null default(0) ")
	private double productDiscount;

	@Column(columnDefinition = "nvarchar(150) null")
	private String productTitle;

	@Column(columnDefinition = "nvarchar(2000) null")
	private String description;

	@Column(columnDefinition = "bit null default(0)")
	private boolean productNew;

	@Column(columnDefinition = "bit null default(0)")
	private boolean productHighLight;

	@Column(columnDefinition = "bit not null default(1)")
	private boolean productStatus;

	@Column(columnDefinition = "smalldatetime not null default(getdate())")
	private LocalDateTime createTime;

	@Column(columnDefinition = "smalldatetime null default(getdate())")
	private LocalDateTime updateTime;

	@Column(columnDefinition = "nvarchar(150) not null")
	private String productImage;
	// ===================================================================
	// CATEGORY
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "categoryId")
	private categories category;

	// IMAGE
	@OneToMany(mappedBy = "product", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<images> images;

	// COLOR
	@OneToMany(mappedBy = "product", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<colors> colors;

	// SIZE
	@OneToMany(mappedBy = "product", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private List<sizes> sizes;

	// ORDERDETAIS
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<orderDetails> orderDetails;
	// ===================================================================

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

	public categories getCategory() {
		return category;
	}

	public void setCategory(categories category) {
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

	public List<orderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetais(List<orderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
