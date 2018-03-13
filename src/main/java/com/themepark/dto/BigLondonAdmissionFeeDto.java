package com.themepark.dto;

public class BigLondonAdmissionFeeDto {
	private Long id;
	private Integer adultSelectedCount;
	private Integer kidsOrSrCitizenSelectedCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "BigLondonAdmissionFeeDto [id=" + id + ", adultSelectedCount=" + adultSelectedCount
				+ ", kidsOrSrCitizenSelectedCount=" + kidsOrSrCitizenSelectedCount + "]";
	}
}
