package com.bv.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bv.entity.CitizenAppEntity;

public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity, Serializable>{

}
