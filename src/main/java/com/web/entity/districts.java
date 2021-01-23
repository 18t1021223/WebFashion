package com.web.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "districts")
public class districts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "smallint")
	private int districtId;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String districtName;

	@Column(columnDefinition = "nvarchar(50) null")
	private String districtPrefix;
	
	//========================================
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provinceId" ,nullable = false)
	private provinces province;
	
	@JsonIgnore
	@OneToMany( mappedBy = "district",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<wards> wards;
	//========================================

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictPrefix() {
		return districtPrefix;
	}

	public void setDistrictPrefix(String districtPrefix) {
		this.districtPrefix = districtPrefix;
	}

	public provinces getProvince() {
		return province;
	}

	public void setProvince(provinces province) {
		this.province = province;
	}

	public List<wards> getWards() {
		return wards;
	}

	public void setWards(List<wards> wards) {
		this.wards = wards;
	}
	
}
