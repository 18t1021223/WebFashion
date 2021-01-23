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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sizes")
public class sizes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint")
	private long sizeId;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String sizeName;

	//======================================================
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false , name = "productId")
	private products product;
	//======================================================
	
	public sizes() {
		// TODO Auto-generated constructor stub
	}

	public long getSizeId() {
		return sizeId;
	}

	public void setSizeId(long sizeId) {
		this.sizeId = sizeId;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public products getProduct() {
		return product;
	}

	public void setProduct(products product) {
		this.product = product;
	}

	
}
