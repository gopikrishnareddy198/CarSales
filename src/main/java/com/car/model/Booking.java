package com.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {
	
	@Id
	String id;
	String bookingId;
	String carId;
	String sellerId;
	String buyerId;
	String bookingDate;
	double amount;
	String paymentMode;
	String paymentStatus;
	String status;


	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Booking(String id, String bookingId, String carId, String sellerId, String buyerId, String bookingDate,
			double amount, String paymentMode, String paymentStatus, String status) {
		this.id = id;
		this.bookingId = bookingId;
		this.carId = carId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.bookingDate = bookingDate;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingId=" + bookingId + ", carId=" + carId + ", sellerId=" + sellerId
				+ ", buyerId=" + buyerId + ", bookingDate=" + bookingDate + ", amount=" + amount + ", paymentMode="
				+ paymentMode + ", paymentStatus=" + paymentStatus + ", status=" + status + "]";
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


	public String getCarId() {
		return carId;
	}


	public void setCarId(String carId) {
		this.carId = carId;
	}


	public String getSellerId() {
		return sellerId;
	}


	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}


	public String getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}


	public String getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


}
