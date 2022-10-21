package com.bv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bv.binding.ChildRequest;
import com.bv.binding.DcSummary;
import com.bv.service.DcService;

@RestController
public class ChildRestController {
	
	@Autowired
	private DcService dcService;
	
	public ResponseEntity<DcSummary> saveChilds(@RequestBody ChildRequest request){
		
		Long caseNum = dcService.saveChildren(request);
		
		DcSummary summary = dcService.getSummary(caseNum);
		
		return new ResponseEntity<> (summary, HttpStatus.OK);
		
	}

}
