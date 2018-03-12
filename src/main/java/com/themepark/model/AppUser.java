package com.themepark.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;


@Data
@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String displayName;
	
	@Lob
	private byte[] avatar;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Boolean enableSmsUpdate;

	private Boolean enableEmailUpdate;

	private Long phoneNumber;

	private Long mobileNumber;

	private Date dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(columnDefinition = "TEXT")
	private String address;

	private String countryOfResidence;

	private String nationality;

	private Long postalCode;

	private String identityNumber;
	
	private Integer noOfChilds;
	
	private Integer noOfAdults;
	
	private Float topup;
	
	private Float amountToBePaid;

	public AppUser() {
	}
	
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

	public byte[] getAvatar() {
		return avatar;
	}
	
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
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
		return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + ", password='" + "*********" + '\'' + ", role=" + role + '}';
	}
}
