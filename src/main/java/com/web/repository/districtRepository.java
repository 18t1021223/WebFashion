package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.districts;

@Repository
public interface districtRepository extends JpaRepository<districts, Integer> {
	@Query(value = "select t from districts t where t.province.provinceId = ?1")
	List<districts> findByProvinceId(int provinceId);
}
