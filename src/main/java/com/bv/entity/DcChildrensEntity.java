package com.bv.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CHILDREN")
public class DcChildrensEntity {
	
	@Id
	@GeneratedValue
	private Integer chidrenId;
	
	private Long caseNum;
	
	private LocalDate childDOB;
	
	private Long childSsn;

}
