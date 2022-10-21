package com.bv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.DcEducationEntity;

public interface DcEducationRepository extends JpaRepository<DcEducationEntity, Serializable>{

	
	public DcEducationEntity findByCaseNum(Long caseNum);
}
