package com.web.converted;

import com.web.dto.productsDto;
import com.web.entity.products;

public class productsConverted {
	public static productsDto entityToDto(products p) {
		return new productsDto(p);
	}

	public static products dtoToEntity(productsDto p) {
		products prod = new products();
		prod.setProductId(p.getProductId());
		prod.setProductName(p.getProductName());
		prod.setProductPrice(p.getProductPrice());
		prod.setProductDiscount(p.getProductDiscount());
		prod.setProductTitle(p.getProductTitle());
		prod.setDescription(p.getDescription());
		prod.setProductNew(p.isProductNew());
		prod.setProductHighLight(p.isProductHighLight());
		prod.setProductStatus(p.isProductStatus());
		prod.setCreateTime(p.getCreateTime());
		prod.setUpdateTime(p.getUpdateTime());
		prod.setImages(p.getImages());
		// prod.setCategory(p.getca);
		prod.setColors(p.getColors());
		prod.setSizes(p.getSizes());
		return prod;
	}
}
