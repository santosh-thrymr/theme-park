package com.themepark.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AppUserAnnualPass extends BaseEntity {
	
	@ManyToOne
	private AppUser appUser;

	@ManyToOne
	private AnnualPass annualPass;
	
	private Integer selectedCount;
	
	private Float price;

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public AnnualPass getAnnualPass() {
		return annualPass;
	}

	public void setAnnualPass(AnnualPass annualPass) {
		this.annualPass = annualPass;
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
