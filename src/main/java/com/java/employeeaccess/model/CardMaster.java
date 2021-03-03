package com.java.employeeaccess.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sl_no")
	private Long id;
	
	@Column(name="card_id")
	private Long cardID;
	
	@Column(name="status")
	private Long status;
	
	@Column(name="encoding")
	private Long encoding;

	public CardMaster() {
	}

	public CardMaster(Long id, Long cardID, Long status, Long encoding) {
		this.id = id;
		this.cardID = cardID;
		this.status = status;
		this.encoding = encoding;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCardID() {
		return cardID;
	}

	public void setCardID(Long cardID) {
		this.cardID = cardID;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getEncoding() {
		return encoding;
	}

	public void setEncoding(Long encoding) {
		this.encoding = encoding;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardID == null) ? 0 : cardID.hashCode());
		result = prime * result + ((encoding == null) ? 0 : encoding.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CardMaster other = (CardMaster) obj;
		if (cardID == null) {
			if (other.cardID != null)
				return false;
		} else if (!cardID.equals(other.cardID))
			return false;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardMaster [id=" + id + ", cardID=" + cardID + ", status=" + status + ", encoding=" + encoding + "]";
	}
	
	

}
