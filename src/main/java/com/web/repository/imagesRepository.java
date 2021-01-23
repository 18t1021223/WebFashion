package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.images;

@Repository
public interface imagesRepository extends JpaRepository<images, Long> {
	@Query(value = "select i from images i where i.product.productId = ?1")
	List<images> findByProducId(long productId);
}
