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
@Table(name = "wards")
public class wards {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "smallint")
	private int wardId;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String wardName;
	
	@Column(columnDefinition = "nvarchar(50) not null")
	private String wardPrefix;
	
	//==================================
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "districtId", nullable = false)
	private districts district;
	//==================================

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getWardPrefix() {
		return wardPrefix;
	}

	public void setWardPrefix(String wardPrefix) {
		this.wardPrefix = wardPrefix;
	}

	public districts getDistrict() {
		return district;
	}

	public void setDistrict(districts district) {
		this.district = district;
	}
	
}
