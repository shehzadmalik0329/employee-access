package com.java.employeeaccess.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="location_id")
	private Long id;
	
	@Column(name="location_name")
	private String locationName;
	
	@OneToMany
	@JoinColumn(name="parent_id", referencedColumnName="location_id")
	@JsonIgnore
    private Set<Location> subLocation;
	
	public Location() {
	}

	public Location(Long id, String locationName, Set<Location> subLocation) {
		this.id = id;
		this.locationName = locationName;
		this.subLocation = subLocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Set<Location> getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(Set<Location> subLocation) {
		this.subLocation = subLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((subLocation == null) ? 0 : subLocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (subLocation == null) {
			if (other.subLocation != null)
				return false;
		} else if (!subLocation.equals(other.subLocation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", locationName=" + locationName + ", subLocation=" + subLocation + "]";
	}

	

}
