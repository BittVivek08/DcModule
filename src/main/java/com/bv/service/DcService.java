package com.bv.service;

import java.util.Map;

import com.bv.binding.ChildRequest;
import com.bv.binding.DcSummary;
import com.bv.binding.Education;
import com.bv.binding.Income;
import com.bv.binding.PlanSelection;

public interface DcService {
	
	public Long loadCaseNum(Integer appId);
	
	public Map<Integer, String> getPlanNames();
	
	public Long savePlanSelection(PlanSelection planSelection);
	
	public Long saveIncomeData(Income income);
	
	public Long saveEducation(Education education);
	
	public Long saveChildren(ChildRequest request);
	
	public DcSummary getSummary(Long caseNum);

}
