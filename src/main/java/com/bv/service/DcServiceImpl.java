package com.bv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bv.binding.Child;
import com.bv.binding.ChildRequest;
import com.bv.binding.DcSummary;
import com.bv.binding.Education;
import com.bv.binding.Income;
import com.bv.binding.PlanSelection;
import com.bv.entity.CitizenAppEntity;
import com.bv.entity.DcCasesEntity;
import com.bv.entity.DcChildrensEntity;
import com.bv.entity.DcEducationEntity;
import com.bv.entity.DcIncomeEntity;
import com.bv.entity.PlanEntity;
import com.bv.repository.CitizenAppRepository;
import com.bv.repository.DcCasesRepository;
import com.bv.repository.DcChildrenRepository;
import com.bv.repository.DcEducationRepository;
import com.bv.repository.DcIncomeRepository;
import com.bv.repository.PlanRepository;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private DcCasesRepository dcCaseRepo;

	@Autowired
	private PlanRepository planRepo;

	@Autowired
	private DcIncomeRepository incomeRepo;

	@Autowired
	private DcEducationRepository eduRepo;

	@Autowired
	private DcChildrenRepository childRepo;

	@Autowired
	private CitizenAppRepository appRepo;

	@Override
	public Long loadCaseNum(Integer appId) {

		Optional<CitizenAppEntity> app = appRepo.findById(appId);

		if (app.isPresent()) {
			DcCasesEntity entity = new DcCasesEntity();
			entity.setAppId(appId);

			entity = dcCaseRepo.save(entity);

			return entity.getCaseNum();
		}
		return (long) 01;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		
		List<PlanEntity> findAll = planRepo.findAll();
	
        Map<Integer, String> plansMap = new HashMap<>();
        
		for (PlanEntity entity : findAll) {
			plansMap.put(entity.getPId(), entity.getPName());
		}
		return plansMap;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {

		Optional<DcCasesEntity> findById = dcCaseRepo.findById(planSelection.getCaseNum());

		if (findById.isPresent()) {
			DcCasesEntity dcCasesEntity = findById.get();
			dcCasesEntity.setPlanId(planSelection.getPlanId());

			dcCaseRepo.save(dcCasesEntity);

			return planSelection.getCaseNum();
		}
		return null;
	}

	@Override
	public Long saveIncomeData(Income income) {

		DcIncomeEntity entity = new DcIncomeEntity();
		BeanUtils.copyProperties(income, entity);

		incomeRepo.save(entity);
		return income.getCaseNum();
	}

	@Override
	public Long saveEducation(Education education) {

		DcEducationEntity entity = new DcEducationEntity();
		BeanUtils.copyProperties(education, entity);

		eduRepo.save(entity);

		return education.getCaseNum();
	}

	@Override
	public Long saveChildren(ChildRequest request) {
		
		List<Child> childs = request.getChilds();

		for (Child c : childs) {

			DcChildrensEntity entity = new DcChildrensEntity();
			BeanUtils.copyProperties(c, entity);

			childRepo.save(entity);
		}
		return request.getCaseNum();
	}

	@Override
	public DcSummary getSummary(Long caseNum) {

		String planName = "";

		DcIncomeEntity incomeEntity = incomeRepo.findByCaseNum(caseNum);
		DcEducationEntity educationEntity = eduRepo.findByCaseNum(caseNum);
		List<DcChildrensEntity> childrenEntity = childRepo.findByCaseNum(caseNum);

		Optional<DcCasesEntity> dcCase = dcCaseRepo.findById(caseNum);

		if (dcCase.isPresent()) {
			Integer planId = dcCase.get().getPlanId();
			Optional<PlanEntity> plan = planRepo.findById(planId);
			if (plan.isPresent()) {
				planName = plan.get().getPName();

			}
		}

		DcSummary summary = new DcSummary();
		summary.setPlanName(planName);

		Income income = new Income();
		BeanUtils.copyProperties(incomeEntity, income);
		summary.setIncome(income);

		Education edu = new Education();
		BeanUtils.copyProperties(educationEntity, edu);
		summary.setEducation(edu);

		List<Child> childs = new ArrayList<>();
		for (DcChildrensEntity entity : childrenEntity) {
			Child ch = new Child();
			BeanUtils.copyProperties(entity, ch);
			childs.add(ch);
		}
		summary.setChilds(childs);

		return summary;
	}

}
