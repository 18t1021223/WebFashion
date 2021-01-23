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
@Table(name = "provinces")
public class provinces {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "smallint")
	private int provinceId;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String provinceName;

	@Column(columnDefinition = "varchar(5) not null")
	private String provinceCode;
	
	//=========================================
	@JsonIgnore
	@OneToMany( mappedBy = "province",cascade = {CascadeType.REMOVE , CascadeType.PERSIST})
	private List<districts> districts;
	
	//========================================
	public provinces() {
		// TODO Auto-generated constructor stub
	}
	
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public List<districts> getDistricts() {
		return districts;
	}

	public void setDistricts(List<districts> districts) {
		this.districts = districts;
	}
	
}
