package com.java.employeeaccess.controller.service;

import java.util.List;

import com.java.employeeaccess.dto.Criteria;
import com.java.employeeaccess.model.MappingEmployeeCard;

public interface MappingEmployeeCardService {
	
	public List<MappingEmployeeCard> getMappingEmployeeCard(Criteria criteria);

}
