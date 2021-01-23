package com.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class slides {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "smallint")
	private int slideId;
	
	@Column(columnDefinition = "nvarchar(150) not null")
	private String slideImage;
	
	@Column(columnDefinition = "nvarchar(50) null")
	private String slideCaption;
	
	@Column(columnDefinition = "nvarchar(255) null")
	private String slideContext;
	
	@Column(columnDefinition = "nvarchar(255) null")
	private String slideLink;
	
	//===========================================================
	public slides() {
		// TODO Auto-generated constructor stub
	}

	public int getSlideId() {
		return slideId;
	}

	public void setSlideId(int slideId) {
		this.slideId = slideId;
	}

	public String getSlideImage() {
		return slideImage;
	}

	public void setSlideImage(String slideImage) {
		this.slideImage = slideImage;
	}

	public String getSlideCaption() {
		return slideCaption;
	}

	public void setSlideCaption(String slideCaption) {
		this.slideCaption = slideCaption;
	}

	public String getSlideContext() {
		return slideContext;
	}

	public void setSlideContext(String slideContext) {
		this.slideContext = slideContext;
	}

	public String getSlideLink() {
		return slideLink;
	}

	public void setSlideLink(String slideLink) {
		this.slideLink = slideLink;
	}
	
	
}
