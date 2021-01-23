package com.web.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint")
	private long orderId;

	@Column(columnDefinition = "smalldatetime not null default(getdate())")
	private Date createTime;

	@Column(columnDefinition = "tinyint default(0) not null")
	private int status;

	@Column(columnDefinition = "smalldatetime default(null)")
	private Date finishedTime;

	@Column(columnDefinition = "varchar(20) not null")
	private String phone;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String name;

	@Column(columnDefinition = "nvarchar(255) not null")
	private String address;

	// =======================================================
	@OneToMany(mappedBy = "order", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<orderDetails> orderDetails;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "paymentId")
	private payments payment;
	// =======================================================

	public orders() {
		// TODO Auto-generated constructor stub
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(Date finishedTime) {
		this.finishedTime = finishedTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<orderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<orderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public payments getPayment() {
		return payment;
	}

	public void setPayment(payments payment) {
		this.payment = payment;
	}
}
