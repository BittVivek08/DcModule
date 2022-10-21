package com.bv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.DcCasesEntity;

public interface DcCasesRepository extends JpaRepository<DcCasesEntity, Serializable> {
	
	public DcCasesEntity findByAppId(Integer appId);

}
