package com.bv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PLAN_MASTER")
public class PlanEntity {
	@Id
	@Column(name = "PLAN_ID")
	private Integer pId;

	@Column(name = "PLAN_NAME")
	private String pName;

	@Column(name = "PLAN_START_DATE")
	private Date pStartDate;

	@Column(name = "PLAN_END_DATE")
	private Date pEndDate;

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer pCategoryId;

	@Column(name = "ACTIVE_SW")
	private char activeSw;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;
}
