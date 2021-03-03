package com.java.employeeaccess.dto;

import java.util.List;

public class Criteria {
	
	private Integer page;
	
	private Integer size;
	
	private List<SortCriteria> sortCriterias;
	
	private List<FilterCriteria> filterCriterias;

	public Criteria() {
	}

	public Criteria(Integer page, Integer size, List<SortCriteria> sortCriterias,
			List<FilterCriteria> filterCriterias) {
		this.page = page;
		this.size = size;
		this.sortCriterias = sortCriterias;
		this.filterCriterias = filterCriterias;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<SortCriteria> getSortCriterias() {
		return sortCriterias;
	}

	public void setSortCriterias(List<SortCriteria> sortCriterias) {
		this.sortCriterias = sortCriterias;
	}

	public List<FilterCriteria> getFilterCriterias() {
		return filterCriterias;
	}

	public void setFilterCriterias(List<FilterCriteria> filterCriterias) {
		this.filterCriterias = filterCriterias;
	}

}
