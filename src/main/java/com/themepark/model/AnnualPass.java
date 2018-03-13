package com.themepark.model;

import javax.persistence.Entity;

@Entity
public class AnnualPass extends BaseEntity {

	private String type;

	private String description;

	private Float price;

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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
