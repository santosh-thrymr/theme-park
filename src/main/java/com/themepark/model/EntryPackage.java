package com.themepark.model;

import javax.persistence.Entity;

@Entity
public class EntryPackage extends BaseEntity {
	
	private String name;
	
	private String description;
	
	private Float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
