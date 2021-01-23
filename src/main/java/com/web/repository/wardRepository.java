package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.entity.wards;

@Repository
public interface wardRepository extends JpaRepository<wards, Integer> {
	@Query(value = "select w from wards w where w.district.districtId =?1")
	List<wards> findByDistrictId(int districtId);
}
