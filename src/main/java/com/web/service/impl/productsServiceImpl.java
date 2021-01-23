package com.web.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.categories;
import com.web.entity.products;
import com.web.repository.productsRepository;
import com.web.service.imagesService;
import com.web.service.productsService;

@Service
public class productsServiceImpl implements productsService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private productsRepository prod;

	@Override
	public long getTotalProduct(Boolean status) {
		return prod.getTotalProduct(status);
	}

	@Override
	public List<products> getProducts(int page, int pageSize, int orderBy, int categoryId, boolean productStatus,
			String keywordSearch) {
		StoredProcedureQuery proc = em.createStoredProcedureQuery("proc_products_select", products.class);
		proc.registerStoredProcedureParameter("page", Integer.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("pageSize", Integer.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("orderBy", Integer.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("productStatus", Boolean.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("keywordSearch", String.class, ParameterMode.IN);
		proc.setParameter("page", page);
		proc.setParameter("pageSize", pageSize);
		proc.setParameter("orderBy", orderBy);
		proc.setParameter("categoryId", categoryId);
		proc.setParameter("productStatus", productStatus);
		proc.setParameter("keywordSearch", keywordSearch);
		return proc.getResultList();
	}

	@Override
	public long count(int categoryId, Boolean categoryStatus, String keywordSearch) {
		StoredProcedureQuery proc = em.createStoredProcedureQuery("proc_quantity_product");
		proc.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("categoryStatus", boolean.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("keywordSearch", String.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("quantity", Long.class, ParameterMode.OUT);
		proc.setParameter("categoryId", categoryId);
		proc.setParameter("categoryStatus", categoryStatus);
		proc.setParameter("keywordSearch", keywordSearch);
		return (long) proc.getOutputParameterValue("quantity");
	}

	@Override
	public List<categories> getParentCategories(int categoryId) {
		StoredProcedureQuery proc = em.createStoredProcedureQuery("proc_categories_parent", categories.class);
		proc.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN);
		proc.setParameter("categoryId", categoryId);
		proc.execute();
		return proc.getResultList();
	}

	public products findById(long productId) {
		StoredProcedureQuery proc = em.createStoredProcedureQuery("proc_product_info", products.class);
		proc.registerStoredProcedureParameter("productId", Long.class, ParameterMode.IN);
		proc.setParameter("productId", productId);
		proc.execute();
		List<products> data = proc.getResultList();
		if (data.size() <= 0)
			return null;
		return data.get(0);
	}

	public boolean productExists(long productId, long sizeId, long colorId) {
		StoredProcedureQuery proc = em.createStoredProcedureQuery("proc_product_exists");
		proc.registerStoredProcedureParameter("productId", Long.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("sizeId", Long.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("colorId", Long.class, ParameterMode.IN);
		proc.registerStoredProcedureParameter("result", Boolean.class, ParameterMode.OUT);
		proc.setParameter("productId", productId);
		proc.setParameter("sizeId", sizeId);
		proc.setParameter("colorId", colorId);
		return (boolean) proc.getOutputParameterValue("result");
	}
}
