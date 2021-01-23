package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.categories;

@Repository
public interface categoriesRepository extends JpaRepository<categories, Integer>{
	List<categories> findByParentId(int parentId);	
}
