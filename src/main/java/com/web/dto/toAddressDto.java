package com.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class toAddressDto {

	@Length(min = 3, message = "Họ tên không hợp lệ!")
	private String name;

	@Pattern(regexp = "^0{1}(9|3|7|8|5){1}[0-9]{8}$", message = "Số điện thoại Không hợp lệ")
	private String phone;

	@NotNull(message = "Điền thông tin")
	private String province;

	@NotNull(message = "Điền thông tin")
	private String district;

	@NotNull(message = "Điền thông tin")
	private String ward;

	@NotBlank(message = "Điền thông tin")
	private String street;

	public toAddressDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
