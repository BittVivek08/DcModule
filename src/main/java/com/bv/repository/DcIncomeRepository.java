package com.bv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.DcIncomeEntity;

public interface DcIncomeRepository extends JpaRepository<DcIncomeEntity, Serializable> {

	public DcIncomeEntity findByCaseNum(Long caseNum);
}
