package com.themepark.model;

import javax.persistence.Entity;

@Entity
public class SingleEntryPass extends BaseEntity {

	private String type;

	private String description;

	private Float standardRate;

	private Float myKadOrMyKidRate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getStandardRate() {
		return standardRate;
	}

	public void setStandardRate(Float standardRate) {
		this.standardRate = standardRate;
	}

	public Float getMyKadOrMyKidRate() {
		return myKadOrMyKidRate;
	}

	public void setMyKadOrMyKidRate(Float myKadOrMyKidRate) {
		this.myKadOrMyKidRate = myKadOrMyKidRate;
	}
}
