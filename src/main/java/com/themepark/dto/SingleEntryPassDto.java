package com.themepark.dto;

public class SingleEntryPassDto {

	private Long id;

	private Integer selectedCount;

	private String type;

	private String description;
	
	private Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSelectedCount() {
		return selectedCount;
	}

	public void setSelectedCount(Integer selectedCount) {
		this.selectedCount = selectedCount;
	}

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

	@Override
	public String toString() {
		return "SingleEntryPassDto [id=" + id + ", selectedCount=" + selectedCount + "]";
	}
}
