package com.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contact")
public class contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "tinyint")
	private int id; 
	
	@Column(columnDefinition = "nvarchar(150)")
	private String address;

	@Column(columnDefinition = "nvarchar(20)")
	@Pattern(regexp = "^0{1}(9|3|7|8|5){1}[0-9]{8}$", message = "Số điện thoại Không hợp lệ")
	private String phone;

	@Column(columnDefinition = "nvarchar(50)")
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email sai định dạng.")
	private String email;

	public contact() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
