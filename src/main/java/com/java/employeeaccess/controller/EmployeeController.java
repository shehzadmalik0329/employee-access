package com.java.employeeaccess.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.employeeaccess.controller.service.MappingEmployeeCardService;
import com.java.employeeaccess.dto.Criteria;
import com.java.employeeaccess.model.MappingEmployeeCard;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MappingEmployeeCardService mappingEmployeeCardService;
	
	@GetMapping
	public ResponseEntity<List<MappingEmployeeCard>> getMappingEmployeeCard(@RequestBody Criteria criteria){
		logger.info("Inside getMappingEmployeeCard");
		List<MappingEmployeeCard> mapping = mappingEmployeeCardService.getMappingEmployeeCard(criteria);
		return ResponseEntity.status(200).body(mapping);
	}

}
