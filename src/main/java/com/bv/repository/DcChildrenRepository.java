package com.bv.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.DcChildrensEntity;

public interface DcChildrenRepository extends JpaRepository<DcChildrensEntity, Serializable> {

	
	public List<DcChildrensEntity> findByCaseNum(Long caseNum);
}
