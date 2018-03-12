package com.themepark.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/*@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})*/
@Data
public class UserRegistrationDto {

	private String firstName;

	private String lastName;

	@Email
	private String email = "ask@ask.com";

	@NotEmpty
	private String displayName;
	
	private Boolean enableSmsUpdate;

	private Boolean enableEmailUpdate;

	private Long phoneNumber;

	private Long mobileNumber;

	private String dob;

	private String gender;

	private String address;

	private String countryOfResidence;

	private String nationality;

	private Long postalCode;

	private String identityNumber;
	
	private Integer noOfChilds;
	
	private Integer noOfAdults;
	
	private Float topup;
	
	private Float amountToBePaid;

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Integer getNoOfChilds() {
		return noOfChilds;
	}

	public void setNoOfChilds(Integer noOfChilds) {
		this.noOfChilds = noOfChilds;
	}

	public Integer getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(Integer noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public Float getTopup() {
		return topup;
	}

	public void setTopup(Float topup) {
		this.topup = topup;
	}

	public Float getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(Float amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", displayName=" + displayName + ", enableSmsUpdate=" + enableSmsUpdate
				+ ", enableEmailUpdate=" + enableEmailUpdate + ", phoneNumber=" + phoneNumber + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", countryOfResidence=" + countryOfResidence + ", nationality=" + nationality + ", postalCode="
				+ postalCode + ", identityNumber=" + identityNumber + ", noOfChilds=" + noOfChilds + ", noOfAdults="
				+ noOfAdults + ", topup=" + topup + "]";
	}
}
