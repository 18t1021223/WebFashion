package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.contact;

@Repository
public interface contactRepository extends JpaRepository<contact, Integer>{

}
