package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.colors;

@Repository
public interface colorsRepository extends JpaRepository<colors, Long>{
	@Query("select c from colors c where c.product.productId = ?1")
	List<colors> findByProductId(long productId);
}
