package com.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "finance")
public class Finance {
	
	@Id
	String id;
	String bookingId;
	String buyerId;
	double loanAmount;
	int tenure;
	double interestRate;
	double emi;
	int paidEmis;

	public Finance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Finance(String id, String bookingId, String buyerId, double loanAmount, int tenure, double interestRate,
			double emi, int paidEmis) {
		this.id = id;
		this.bookingId = bookingId;
		this.buyerId = buyerId;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.interestRate = interestRate;
		this.emi = emi;
		this.paidEmis = paidEmis;
	}

	@Override
	public String toString() {
		return "Finance [id=" + id + ", bookingId=" + bookingId + ", buyerId=" + buyerId + ", loanAmount=" + loanAmount
				+ ", tenure=" + tenure + ", interestRate=" + interestRate + ", emi=" + emi + ", paidEmis=" + paidEmis
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public int getPaidEmis() {
		return paidEmis;
	}

	public void setPaidEmis(int paidEmis) {
		this.paidEmis = paidEmis;
	}



}
