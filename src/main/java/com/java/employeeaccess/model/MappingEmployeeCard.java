package com.java.employeeaccess.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class MappingEmployeeCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sl_no")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="emp_sl_no", referencedColumnName="sl_no")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name="card_sl_no", referencedColumnName="sl_no")
	private CardMaster cardMaster;
	
	@Column(name="access_attributes")
	private Long accessAttributes;
	
	

	public MappingEmployeeCard() {
	}

	public MappingEmployeeCard(Long id, Employee employee, CardMaster cardMaster, Long accessAttributes) {
		this.id = id;
		this.employee = employee;
		this.cardMaster = cardMaster;
		this.accessAttributes = accessAttributes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public CardMaster getCardMaster() {
		return cardMaster;
	}

	public void setCardMaster(CardMaster cardMaster) {
		this.cardMaster = cardMaster;
	}

	public Long getAccessAttributes() {
		return accessAttributes;
	}

	public void setAccessAttributes(Long accessAttributes) {
		this.accessAttributes = accessAttributes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessAttributes == null) ? 0 : accessAttributes.hashCode());
		result = prime * result + ((cardMaster == null) ? 0 : cardMaster.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MappingEmployeeCard other = (MappingEmployeeCard) obj;
		if (accessAttributes == null) {
			if (other.accessAttributes != null)
				return false;
		} else if (!accessAttributes.equals(other.accessAttributes))
			return false;
		if (cardMaster == null) {
			if (other.cardMaster != null)
				return false;
		} else if (!cardMaster.equals(other.cardMaster))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MappingEmployeeCard [id=" + id + ", employee=" + employee + ", cardMaster=" + cardMaster
				+ ", accessAttributes=" + accessAttributes + "]";
	}

}
