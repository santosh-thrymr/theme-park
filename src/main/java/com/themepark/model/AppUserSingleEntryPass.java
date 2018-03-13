package com.themepark.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AppUserSingleEntryPass extends BaseEntity {
	
	@ManyToOne
	private AppUser appUser;

	@ManyToOne
	private SingleEntryPass singleEntryPass;

	private Integer standardCount;
	
	private Integer myKidOrMyKadCount;
	
	private Float price; 

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public SingleEntryPass getSingleEntryPass() {
		return singleEntryPass;
	}

	public void setSingleEntryPass(SingleEntryPass singleEntryPass) {
		this.singleEntryPass = singleEntryPass;
	}

	public Integer getStandardCount() {
		return standardCount;
	}

	public void setStandardCount(Integer standardCount) {
		this.standardCount = standardCount;
	}

	public Integer getMyKidOrMyKadCount() {
		return myKidOrMyKadCount;
	}

	public void setMyKidOrMyKadCount(Integer myKidOrMyKadCount) {
		this.myKidOrMyKadCount = myKidOrMyKadCount;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
