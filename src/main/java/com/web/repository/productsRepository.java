package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.web.entity.products;

@Repository
public interface productsRepository extends JpaRepository<products, Long> {
//	@Procedure(name    = "proc_products_select")
//	List<products> getProducts(int page,  int pageSize);
	@Query(value = "select count(*) from products p where p.productStatus = ?1")
	long getTotalProduct(Boolean status);


}
