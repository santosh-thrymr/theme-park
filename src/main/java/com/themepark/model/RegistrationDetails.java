package com.themepark.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.themepark.enums.PaymentMode;

@Entity
public class RegistrationDetails extends BaseEntity {

	private String identityNumber;

	private Float topup;

	private Float totalPaidForPackages;

	private Float totalPaidForSingleEntryPass;

	private Float totalPaidForAnnualPass;

	private Float totalPaidForBigLondonFee;

	private Float totalPaid;

	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	private String otherPayment;
	
	private Date paymentDate;

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

	public Float getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Float totalPaid) {
		this.totalPaid = totalPaid;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOtherPayment() {
		return otherPayment;
	}

	public void setOtherPayment(String otherPayment) {
		this.otherPayment = otherPayment;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
}
