package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.sizes;

@Repository
public interface sizesRepository extends JpaRepository<sizes, Long> {
	@Query("select s from sizes s where s.product.productId = ?1")
	List<sizes> findByProductId(long productId);
}
