package com.themepark.dto;

public class BigLondonAdmissionFeeDto {

	private Long id;

	private Integer adultSelectedCount;

	private Integer kidsOrSrCitizenSelectedCount;

	private String type;

	private String description;
	
	private Float adultPrice;
	
	private Float kidsOrSrCitizenPrice;

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

	public Float getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Float adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Float getKidsOrSrCitizenPrice() {
		return kidsOrSrCitizenPrice;
	}

	public void setKidsOrSrCitizenPrice(Float kidsOrSrCitizenPrice) {
		this.kidsOrSrCitizenPrice = kidsOrSrCitizenPrice;
	}

	@Override
	public String toString() {
		return "BigLondonAdmissionFeeDto [id=" + id + ", adultSelectedCount=" + adultSelectedCount
				+ ", kidsOrSrCitizenSelectedCount=" + kidsOrSrCitizenSelectedCount + "]";
	}
}
