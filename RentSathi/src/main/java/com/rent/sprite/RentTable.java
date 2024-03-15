package com.rent.sprite;

public class RentTable {

	private String rentType;
	
	private String location;
	
	private String PropertySpecification;
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

	public String getPropertySpecification() {
		return PropertySpecification;
	}

	public void setPropertySpecification(String propertySpecification) {
		PropertySpecification = propertySpecification;
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
		return "RentTable [rentType=" + rentType + ", location=" + location + ", PropertySpecification="
				+ PropertySpecification + ", title=" + title + ", price=" + price + ", description=" + description
				+ "]";
	}

	
	
}
