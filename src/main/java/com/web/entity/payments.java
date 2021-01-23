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
@Table
public class payments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "tinyint")
	private int paymentId;

	@Column(columnDefinition = "nvarchar(150) not null")
	private String paymentName;

	@Column(columnDefinition = "nvarchar(50)")
	private String paymentImage;

	// ========================================
	@JsonIgnore
	@OneToMany(mappedBy = "payment", cascade = { CascadeType.PERSIST })
	private List<orders> orders;

	// ========================================
	public payments() {
		// TODO Auto-generated constructor stub
	}

	public List<orders> getOrders() {
		return orders;
	}

	public void setOrders(List<orders> orders) {
		this.orders = orders;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getPaymentImage() {
		return paymentImage;
	}

	public void setPaymentImage(String paymentImage) {
		this.paymentImage = paymentImage;
	}

}
