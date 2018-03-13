package com.themepark.model;

import javax.persistence.Entity;

@Entity
public class BigLondonAdmissionFee extends BaseEntity {
	
	private String type;
	
	private String description;
	
	private Float adultsStandardRate;
	
	private Float kidsOrSrCitizenStandardRate;
	
	private Float adultsMyKRate;
	
	private Float kidsOrSrCitizenMyKRate;

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

	public Float getAdultsStandardRate() {
		return adultsStandardRate;
	}

	public void setAdultsStandardRate(Float adultsStandardRate) {
		this.adultsStandardRate = adultsStandardRate;
	}

	public Float getKidsOrSrCitizenStandardRate() {
		return kidsOrSrCitizenStandardRate;
	}

	public void setKidsOrSrCitizenStandardRate(Float kidsOrSrCitizenStandardRate) {
		this.kidsOrSrCitizenStandardRate = kidsOrSrCitizenStandardRate;
	}

	public Float getAdultsMyKRate() {
		return adultsMyKRate;
	}

	public void setAdultsMyKRate(Float adultsMyKRate) {
		this.adultsMyKRate = adultsMyKRate;
	}

	public Float getKidsOrSrCitizenMyKRate() {
		return kidsOrSrCitizenMyKRate;
	}

	public void setKidsOrSrCitizenMyKRate(Float kidsOrSrCitizenMyKRate) {
		this.kidsOrSrCitizenMyKRate = kidsOrSrCitizenMyKRate;
	}
}
