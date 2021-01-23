package com.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetails")
public class orderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderDetailsId;

	@Column(nullable = false)
	private int quantity;

	@Column(columnDefinition = "money not null")
	private double salePrice;

	@Column(columnDefinition = "money null default(0)")
	private double discount;

	@Column(columnDefinition = "nvarchar(50) null")
	private String size;

	@Column(columnDefinition = "nvarchar(50) null")
	private String color;

	@Column(columnDefinition = "nvarchar(150) null")
	private String image;

	@Column(columnDefinition = "nvarchar(150) null")
	private String productName;
	// ====================================================
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", nullable = false)
	private orders order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = true)
	private products product;
	// ====================================================
	
	public orderDetails() {
		// TODO Auto-generated constructor stub
	}

	public long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public products getProduct() {
		return product;
	}

	public void setProduct(products product) {
		this.product = product;
	}

	public long getOrderDetaisId() {
		return orderDetailsId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setOrderDetaisId(long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public orders getOrder() {
		return order;
	}

	public void setOrder(orders order) {
		this.order = order;
	}

}
