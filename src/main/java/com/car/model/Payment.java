package com.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {
	
	@Id
	String id;
	String bookingId;
	double paidAmount;
	String paymentMode;
	String paymentDate;


	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Payment(String id, String bookingId, double paidAmount, String paymentMode, String paymentDate) {
		this.id = id;
		this.bookingId = bookingId;
		this.paidAmount = paidAmount;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
	}


	@Override
	public String toString() {
		return "Payment [id=" + id + ", bookingId=" + bookingId + ", paidAmount=" + paidAmount + ", paymentMode="
				+ paymentMode + ", paymentDate=" + paymentDate + "]";
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
