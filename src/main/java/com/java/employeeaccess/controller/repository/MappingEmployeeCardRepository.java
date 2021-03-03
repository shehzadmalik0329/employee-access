package com.java.employeeaccess.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.java.employeeaccess.model.MappingEmployeeCard;

public interface MappingEmployeeCardRepository extends JpaRepository<MappingEmployeeCard, Long>, JpaSpecificationExecutor<MappingEmployeeCard>{

}
