package com.themepark.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AppUserBLAdmissionFee extends BaseEntity {
	
	@ManyToOne
	private AppUser appUser;

	@ManyToOne
	private BigLondonAdmissionFee bigLondonAdmissionFee;

	private Integer adultSelectedCount;

	private Integer kidsOrSrCitizenSelectedCount;

	private Float adultsPrice;

	private Float kidsOrSrCitizenPrice;

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public BigLondonAdmissionFee getBigLondonAdmissionFee() {
		return bigLondonAdmissionFee;
	}

	public void setBigLondonAdmissionFee(BigLondonAdmissionFee bigLondonAdmissionFee) {
		this.bigLondonAdmissionFee = bigLondonAdmissionFee;
	}

	public Integer getAdultSelectedCount() {
		return adultSelectedCount;
	}

	public void setAdultSelectedCount(Integer adultSelectedCount) {
		this.adultSelectedCount = adultSelectedCount;
	}

	public Integer getKidsOrSrCitizenSelectedCount() {
		return kidsOrSrCitizenSelectedCount;
	}

	public void setKidsOrSrCitizenSelectedCount(Integer kidsOrSrCitizenSelectedCount) {
		this.kidsOrSrCitizenSelectedCount = kidsOrSrCitizenSelectedCount;
	}

	public Float getAdultsPrice() {
		return adultsPrice;
	}

	public void setAdultsPrice(Float adultsPrice) {
		this.adultsPrice = adultsPrice;
	}

	public Float getKidsOrSrCitizenPrice() {
		return kidsOrSrCitizenPrice;
	}

	public void setKidsOrSrCitizenPrice(Float kidsOrSrCitizenPrice) {
		this.kidsOrSrCitizenPrice = kidsOrSrCitizenPrice;
	}
}
