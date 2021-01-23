package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.orders;

@Repository
public interface ordersRepository extends JpaRepository<orders, Long> {

}
