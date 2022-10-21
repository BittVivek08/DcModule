package com.bv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable>{

}
