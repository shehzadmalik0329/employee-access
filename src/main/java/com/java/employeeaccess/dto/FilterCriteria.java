package com.java.employeeaccess.dto;

public class FilterCriteria {
	
	private String key;
	
	private String filterBy;
	
	private String filterValue;

	public FilterCriteria() {
	}

	public FilterCriteria(String key, String filterBy, String filterValue) {
		this.key = key;
		this.filterBy = filterBy;
		this.filterValue = filterValue;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	
	
}
