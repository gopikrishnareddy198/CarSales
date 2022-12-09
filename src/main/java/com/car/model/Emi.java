package com.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emi")
public class Emi {
	
	@Id
	String id;
	String financeId;
	double paidAmount;
	String paymentMode;
	String paymentDate;


	public Emi() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Emi(String id, String financeId, double paidAmount, String paymentMode, String paymentDate) {
		this.id = id;
		this.financeId = financeId;
		this.paidAmount = paidAmount;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
	}


	@Override
	public String toString() {
		return "Emi [id=" + id + ", financeId=" + financeId + ", paidAmount=" + paidAmount + ", paymentMode="
				+ paymentMode + ", paymentDate=" + paymentDate + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFinanceId() {
		return financeId;
	}


	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}


	public double getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


}
