package com.themepark.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.themepark.enums.Gender;
import com.themepark.enums.Role;

@Entity
public class AppUser extends BaseEntity implements Authentication {

	private String firstName;

	private String lastName;

	@NotNull
	private String email;

	private String password;

	@NotNull
	private String displayName;

	@Lob
	private byte[] avatar;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Boolean enableSmsUpdate;

	private Boolean enableEmailUpdate;

	private Integer phoneIntCallingCode;

	private Long phoneNumber;

	private Integer mobileIntCallingCode;

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

	private Float topup;

	private Float totalPaidForPackages;

	private Float totalPaidForSingleEntryPass;

	private Float totalPaidForAnnualPass;

	private Float totalPaidForBigLondonFee;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Float getTopup() {
		return topup;
	}

	public void setTopup(Float topup) {
		this.topup = topup;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        // TODO : check role.toString()
        list.add(new SimpleGrantedAuthority(this.role.toString()));

        return list;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
}
