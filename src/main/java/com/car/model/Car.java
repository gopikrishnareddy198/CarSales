package com.car.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car")
public class Car {
	
	@Id
	String id;
	String carId;
	String sellerId;
	String brand;
	String model;
	String color;
	String engine;
	String fuelType;
	String mileage;
	String regYear;
	int noOfOwner;
	double price;
	String description;
	String imgUrl;
	String postedDate;
	String status;
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String id, String carId, String sellerId, String brand, String model, String color, String engine,
			String fuelType, String mileage, String regYear, int noOfOwner, double price, String description,
			String imgUrl, String postedDate, String status) {
		this.id = id;
		this.carId = carId;
		this.sellerId = sellerId;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.engine = engine;
		this.fuelType = fuelType;
		this.mileage = mileage;
		this.regYear = regYear;
		this.noOfOwner = noOfOwner;
		this.price = price;
		this.description = description;
		this.imgUrl = imgUrl;
		this.postedDate = postedDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carId=" + carId + ", sellerId=" + sellerId + ", brand=" + brand + ", model=" + model
				+ ", color=" + color + ", engine=" + engine + ", fuelType=" + fuelType + ", mileage=" + mileage
				+ ", regYear=" + regYear + ", noOfOwner=" + noOfOwner + ", price=" + price + ", description="
				+ description + ", imgUrl=" + imgUrl + ", postedDate=" + postedDate + ", status=" + status + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getRegYear() {
		return regYear;
	}
	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}
	public int getNoOfOwner() {
		return noOfOwner;
	}
	public void setNoOfOwner(int noOfOwner) {
		this.noOfOwner = noOfOwner;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
