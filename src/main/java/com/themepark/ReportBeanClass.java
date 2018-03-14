package com.themepark;

import java.math.BigDecimal;

/**
 * @author Bharath P
 * @createdOn 14-Mar-2018
 */
public class ReportBeanClass {

	public ReportBeanClass() {
		/*this.bookingDate = "bookingDate";
		this.packageDetails = "packageDetails packageDetails packageDetails packageDetails packageDetails \n packageDetails packageDetails packageDetails packageDetails packageDetails \n packageDetails packageDetails packageDetails packageDetails packageDetails \n packageDetails packageDetails packageDetails packageDetails packageDetails \n";
		this.totalAmount = BigDecimal.ZERO;
		this.guestName = "guestName";
		this.guestId = "guestId";
		this.email = "email";
		this.mobile = "mobile";
		this.paymentDate = "paymentDate";
		this.paymentMethod = "paymentMethod";*/
	}

	public ReportBeanClass(final String string, final String string2, final String string3, final BigDecimal string4,
			final String string5, final String string6, final String string7, final String string8,
			final String string9, final String string10) {
		this.bookingDate = string;
		this.packageDetails = string3;
		this.totalAmount = string4;
		this.guestName = string5;
		this.guestId = string6;
		this.email = string7;
		this.mobile = string8;
		this.paymentDate = string9;
		this.paymentMethod = string10;
	}

	public String bookingDate;
	public String packageDetails;
	public BigDecimal totalAmount;
	public String guestName;
	public String guestId;
	public String email;
	public String mobile;
	public String paymentDate;
	public String paymentMethod;

	public String getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(final String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getPackageDetails() {
		return this.packageDetails;
	}

	public void setPackageDetails(final String packageDetails) {
		this.packageDetails = packageDetails;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(final BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getGuestName() {
		return this.guestName;
	}

	public void setGuestName(final String guestName) {
		this.guestName = guestName;
	}

	public String getGuestId() {
		return this.guestId;
	}

	public void setGuestId(final String guestId) {
		this.guestId = guestId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(final String mobile) {
		this.mobile = mobile;
	}

	public String getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(final String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(final String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
