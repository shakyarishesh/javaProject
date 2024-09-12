package com.rent.sprite;

public class UploadTable {

	private String rentType;
	
	private String location;
	
	private String bhk;
	private String title;
	
	private long price;
	
	private String description;

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBhk() {
		return bhk;
	}

	public void setBhk(String bhk) {
		this.bhk = bhk;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UploadTable [rentType=" + rentType + ", location=" + location + ", bhk=" + bhk + ", title=" + title
				+ ", price=" + price + ", description=" + description + "]";
	}

	
}
