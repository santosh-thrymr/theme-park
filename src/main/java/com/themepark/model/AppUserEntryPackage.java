package com.themepark.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AppUserEntryPackage extends BaseEntity {

	@ManyToOne
	private AppUser appUser;

	@ManyToOne
	private EntryPackage entryPackage;

	private Integer selectedCount;

	private Float price;

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public EntryPackage getEntryPackage() {
		return entryPackage;
	}

	public void setEntryPackage(EntryPackage entryPackage) {
		this.entryPackage = entryPackage;
	}

	public Integer getSelectedCount() {
		return selectedCount;
	}

	public void setSelectedCount(Integer selectedCount) {
		this.selectedCount = selectedCount;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
