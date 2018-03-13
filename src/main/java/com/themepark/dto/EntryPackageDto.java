package com.themepark.dto;

public class EntryPackageDto {
	private Long id;
	private Integer selectedCount;

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

	@Override
	public String toString() {
		return "EntryPackageDto [id=" + id + ", selectedCount=" + selectedCount + "]";
	}
}
