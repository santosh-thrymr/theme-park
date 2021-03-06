package com.themepark.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/*@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})*/
@Data
public class UserRegistrationDto {

	private Long id;

	private String firstName;

	private String lastName;

	@Email
	private String email;

	@NotEmpty
	private String displayName;

	private Boolean enableSmsUpdate;

	private Boolean enableEmailUpdate;

	private Integer phoneIntCallingCode;

	private Long phoneNumber;

	private Integer mobileIntCallingCode;

	private Long mobileNumber;

	private String dob;

	private String gender;

	private String address;

	private String countryOfResidence;

	private String nationality;

	private Long postalCode;

	private String identityNumber;

	private Float topup;

	private List<EntryPackageDto> entryPackageDtos = new ArrayList<>();

	private List<SingleEntryPassDto> singleEntryPassDtos = new ArrayList<>();

	private List<AnnualPassDto> annualPassDtos = new ArrayList<>();

	private List<BigLondonAdmissionFeeDto> bigLondonAdmissionFeeDtos = new ArrayList<>();
	
	private String paymentMode;
	
	private String otherPayment;
	
	private Long createdById;
	
	private String createdByName;
	
	private String createdByEmail;
	
	private Float totalPaidForPackages;

	private Float totalPaidForSingleEntryPass;

	private Float totalPaidForAnnualPass;

	private Float totalPaidForBigLondonFee;

	private Float totalPaid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getEnableSmsUpdate() {
		return enableSmsUpdate;
	}

	public void setEnableSmsUpdate(Boolean enableSmsUpdate) {
		this.enableSmsUpdate = enableSmsUpdate;
	}

	public Boolean getEnableEmailUpdate() {
		return enableEmailUpdate;
	}

	public void setEnableEmailUpdate(Boolean enableEmailUpdate) {
		this.enableEmailUpdate = enableEmailUpdate;
	}

	public Integer getPhoneIntCallingCode() {
		return phoneIntCallingCode;
	}

	public void setPhoneIntCallingCode(Integer phoneIntCallingCode) {
		this.phoneIntCallingCode = phoneIntCallingCode;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getMobileIntCallingCode() {
		return mobileIntCallingCode;
	}

	public void setMobileIntCallingCode(Integer mobileIntCallingCode) {
		this.mobileIntCallingCode = mobileIntCallingCode;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public Float getTopup() {
		return topup;
	}

	public void setTopup(Float topup) {
		this.topup = topup;
	}

	public List<EntryPackageDto> getEntryPackageDtos() {
		return entryPackageDtos;
	}

	public void setEntryPackageDtos(List<EntryPackageDto> entryPackageDtos) {
		this.entryPackageDtos = entryPackageDtos;
	}

	public List<SingleEntryPassDto> getSingleEntryPassDtos() {
		return singleEntryPassDtos;
	}

	public void setSingleEntryPassDtos(List<SingleEntryPassDto> singleEntryPassDtos) {
		this.singleEntryPassDtos = singleEntryPassDtos;
	}

	public List<AnnualPassDto> getAnnualPassDtos() {
		return annualPassDtos;
	}

	public void setAnnualPassDtos(List<AnnualPassDto> annualPassDtos) {
		this.annualPassDtos = annualPassDtos;
	}

	public List<BigLondonAdmissionFeeDto> getBigLondonAdmissionFeeDtos() {
		return bigLondonAdmissionFeeDtos;
	}

	public void setBigLondonAdmissionFeeDtos(List<BigLondonAdmissionFeeDto> bigLondonAdmissionFeeDtos) {
		this.bigLondonAdmissionFeeDtos = bigLondonAdmissionFeeDtos;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOtherPayment() {
		return otherPayment;
	}

	public void setOtherPayment(String otherPayment) {
		this.otherPayment = otherPayment;
	}

	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
	}

	public Float getTotalPaidForPackages() {
		return totalPaidForPackages;
	}

	public void setTotalPaidForPackages(Float totalPaidForPackages) {
		this.totalPaidForPackages = totalPaidForPackages;
	}

	public Float getTotalPaidForSingleEntryPass() {
		return totalPaidForSingleEntryPass;
	}

	public void setTotalPaidForSingleEntryPass(Float totalPaidForSingleEntryPass) {
		this.totalPaidForSingleEntryPass = totalPaidForSingleEntryPass;
	}

	public Float getTotalPaidForAnnualPass() {
		return totalPaidForAnnualPass;
	}

	public void setTotalPaidForAnnualPass(Float totalPaidForAnnualPass) {
		this.totalPaidForAnnualPass = totalPaidForAnnualPass;
	}

	public Float getTotalPaidForBigLondonFee() {
		return totalPaidForBigLondonFee;
	}

	public void setTotalPaidForBigLondonFee(Float totalPaidForBigLondonFee) {
		this.totalPaidForBigLondonFee = totalPaidForBigLondonFee;
	}

	public Float getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Float totalPaid) {
		this.totalPaid = totalPaid;
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", displayName=" + displayName + ", enableSmsUpdate=" + enableSmsUpdate
				+ ", enableEmailUpdate=" + enableEmailUpdate + ", phoneIntCallingCode=" + phoneIntCallingCode
				+ ", phoneNumber=" + phoneNumber + ", mobileIntCallingCode=" + mobileIntCallingCode + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", countryOfResidence=" + countryOfResidence + ", nationality=" + nationality + ", postalCode="
				+ postalCode + ", identityNumber=" + identityNumber + ", topup=" + topup + ", entryPackageDtos="
				+ entryPackageDtos + ", singleEntryPassDtos=" + singleEntryPassDtos + ", annualPassDtos="
				+ annualPassDtos + ", bigLondonAdmissionFeeDtos=" + bigLondonAdmissionFeeDtos + ", paymentMode="
				+ paymentMode + "]";
	}
}
