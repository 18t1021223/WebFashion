package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.payments;

@Repository
public interface paymentsRepository extends JpaRepository<payments, Integer>{
	
}
