package com.java.employeeaccess.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.employeeaccess.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
	
	List<Location> findByLocationNameIn(List<String> locations);

}
