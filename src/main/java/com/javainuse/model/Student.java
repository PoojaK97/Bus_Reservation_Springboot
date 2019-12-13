package com.javainuse.model;

public class Student {

	private String busId;
	private String name, source, destination, date, departure, arrival,price;
	private Integer rating;

	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	/*@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}*/
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String d) {
		this.departure = d;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}