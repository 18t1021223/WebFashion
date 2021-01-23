package com.web.dto;

public class cartDto {
	private int quantity;
	private double totalPrice;
	private productsDto prod;

	public cartDto() {
	}

	public cartDto(int quantity, double totalPrice, productsDto prod) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.prod = prod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public productsDto getProd() {
		return prod;
	}

	public void setProd(productsDto prod) {
		this.prod = prod;
	}

	
}
