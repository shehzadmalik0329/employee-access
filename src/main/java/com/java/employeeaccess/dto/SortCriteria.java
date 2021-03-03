package com.java.employeeaccess.dto;

public class SortCriteria {
	
	private String key;
	
	private String sortBy;
	
	private String sortDirection;

	public SortCriteria() {
	}

	public SortCriteria(String key, String sortBy, String sortDirection) {
		this.key = key;
		this.sortBy = sortBy;
		this.sortDirection = sortDirection;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	

}
