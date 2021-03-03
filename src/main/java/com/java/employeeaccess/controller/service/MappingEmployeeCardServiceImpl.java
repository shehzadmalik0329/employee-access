package com.java.employeeaccess.controller.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.java.employeeaccess.controller.repository.LocationRepository;
import com.java.employeeaccess.controller.repository.MappingEmployeeCardRepository;
import com.java.employeeaccess.dto.Criteria;
import com.java.employeeaccess.dto.FilterCriteria;
import com.java.employeeaccess.dto.SortCriteria;
import com.java.employeeaccess.model.CardMaster;
import com.java.employeeaccess.model.Employee;
import com.java.employeeaccess.model.Location;
import com.java.employeeaccess.model.MappingEmployeeCard;
@Service
public class MappingEmployeeCardServiceImpl implements MappingEmployeeCardService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String MAPPING = "mapping";
	
	private static final String CARD_MASTER = "cardMaster";
	
	private static final String CARDS = "cards";
	
	private static final String EMPLOYEE = "employee";
	
	private static final String LOCATION = "location";
	
	private static final String ASCENDING = "ASC";
	
	@Autowired
	private MappingEmployeeCardRepository mappingEmployeeCardRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<MappingEmployeeCard> getMappingEmployeeCard(Criteria criteria) {
		
		logger.info("Inside getMappingEmployeeCard");

		List<Predicate> list = new ArrayList<>();

		List<Order> orders = new LinkedList<>();
		
		List<String> locationList = getLocations(criteria.getFilterCriterias());

		Specification<MappingEmployeeCard> joins = (mapping, query, cb) ->  {

			Join<CardMaster, MappingEmployeeCard> cards = mapping.join(CARD_MASTER, JoinType.INNER);

			Join<Employee, MappingEmployeeCard> employee = mapping.join(EMPLOYEE, JoinType.INNER);
			
			Join<Location, Employee> location = employee.join(LOCATION, JoinType.INNER);
			
			List<FilterCriteria> filterCriterias = criteria.getFilterCriterias();
			if(!CollectionUtils.isEmpty(filterCriterias)){
				addFilterCriteria(list, locationList, mapping, cb, cards, employee, location, filterCriterias);
			}
			
			
			List<SortCriteria> sortCriterias = criteria.getSortCriterias();
			if(!CollectionUtils.isEmpty(sortCriterias)){
				addSortCriteria(orders, mapping, cb, cards, employee, location, sortCriterias);
			}
			
			query.orderBy(orders);
			Predicate[] p = new Predicate[list.size()];
			return cb.and(list.toArray(p));
		};

		PageRequest pageRequest = PageRequest.of(criteria.getPage(), criteria.getSize());

		Page<MappingEmployeeCard> employeePage = mappingEmployeeCardRepository.findAll(joins, pageRequest);
		return employeePage.getContent();

	}

	private void addSortCriteria(List<Order> orders, Root<MappingEmployeeCard> mapping, CriteriaBuilder cb,
			Join<CardMaster, MappingEmployeeCard> cards, Join<Employee, MappingEmployeeCard> employee,
			Join<Location, Employee> location, List<SortCriteria> sortCriterias) {
		for(SortCriteria sortCriteria: sortCriterias){
			if(sortCriteria.getKey().equals(MAPPING) && sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.asc(mapping.get(sortCriteria.getSortBy())));
			} else if(sortCriteria.getKey().equals(MAPPING) && !sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.desc(mapping.get(sortCriteria.getSortBy())));
			}
			
			if(sortCriteria.getKey().equals(CARDS) && sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.asc(cards.get(sortCriteria.getSortBy())));
			} else if(sortCriteria.getKey().equals(CARDS) && !sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.desc(cards.get(sortCriteria.getSortBy())));
			}
			
			if(sortCriteria.getKey().equals(EMPLOYEE) && sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.asc(employee.get(sortCriteria.getSortBy())));
			} else if(sortCriteria.getKey().equals(EMPLOYEE) && !sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.desc(employee.get(sortCriteria.getSortBy())));
			}
			
			if(sortCriteria.getKey().equals(LOCATION) && sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.asc(location.get(sortCriteria.getSortBy())));
			} else if(sortCriteria.getKey().equals(LOCATION) && !sortCriteria.getSortDirection().equalsIgnoreCase(ASCENDING)){
				orders.add(cb.desc(location.get(sortCriteria.getSortBy())));
			}
		}
	}

	private void addFilterCriteria(List<Predicate> list, List<String> locationList, Root<MappingEmployeeCard> mapping,
			CriteriaBuilder cb, Join<CardMaster, MappingEmployeeCard> cards,
			Join<Employee, MappingEmployeeCard> employee, Join<Location, Employee> location,
			List<FilterCriteria> filterCriterias) {
		for(FilterCriteria filterCriteria: filterCriterias){
			if(filterCriteria.getKey().equals(MAPPING)){
				list.add(cb.equal(mapping.get(filterCriteria.getFilterBy()), filterCriteria.getFilterValue()));
			}
			if(filterCriteria.getKey().equals(CARDS)){
		        list.add(cb.equal(cards.get(filterCriteria.getFilterBy()), filterCriteria.getFilterValue()));
			}
			if(filterCriteria.getKey().equals(EMPLOYEE)){
		        list.add(cb.equal(employee.get(filterCriteria.getFilterBy()),  filterCriteria.getFilterValue()));
			}
			if(filterCriteria.getKey().equals(LOCATION)){
				if(filterCriteria.getFilterBy().equalsIgnoreCase("locationName")){
					list.add(location.get(filterCriteria.getFilterBy()).in(locationList));
				} else {
					list.add(cb.equal(location.get(filterCriteria.getFilterBy()),  filterCriteria.getFilterValue()));
				}
			}
		}
	}
	
	private List<String> getLocations(List<FilterCriteria> filterCriterias){
		
		List<String> distinctLocations = new ArrayList<>();
		if(!CollectionUtils.isEmpty(filterCriterias)){
			List<String> locations = filterCriterias.stream().filter(criteria -> criteria.getKey().equalsIgnoreCase(LOCATION))
					.map(FilterCriteria::getFilterValue).collect(Collectors.toList());
			
			List<Location> locationList = locationRepository.findByLocationNameIn(locations);
			
			List<String> locationWithSubLocation = locationList.stream()
				    .flatMap(MappingEmployeeCardServiceImpl::flatten)
				    .map(Location::getLocationName)
				    .collect(Collectors.toList());
			
			distinctLocations = locationWithSubLocation.stream().distinct().collect(Collectors.toList());
		}
		
		return distinctLocations;
	}
	
	public static Stream<Location> flatten(Location location) {
        return Stream.concat(
            Stream.of(location), 
            location.getSubLocation().stream().flatMap(MappingEmployeeCardServiceImpl::flatten)); // recursion here
    }

}
