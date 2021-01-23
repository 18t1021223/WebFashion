package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.provinces;

@Repository
public interface provincesRepository extends JpaRepository<provinces, Integer>{
	
}
