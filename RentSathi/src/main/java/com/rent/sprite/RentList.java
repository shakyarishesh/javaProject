package com.rent.sprite;

import java.sql.Timestamp;
import java.util.Arrays;

public class RentList {

	String rentType;

	String location;

	String bhk;

	String title;

	long price;

	String description;
	
	Timestamp created_at;

	String imgpath;
	
	String imgname;

	public RentList(String rentType, String location, String bhk, String title, long price, String description,
			Timestamp created_at, String imgpath, String imgname) {
		super();
		this.rentType = rentType;
		this.location = location;
		this.bhk = bhk;
		this.title = title;
		this.price = price;
		this.description = description;
		this.created_at = created_at;
		this.imgpath = imgpath;
		this.imgname = imgname;
	}

	public RentList() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	@Override
	public String toString() {
		return "RentList [rentType=" + rentType + ", location=" + location + ", bhk=" + bhk + ", title=" + title
				+ ", price=" + price + ", description=" + description + ", created_at=" + created_at + ", imgpath="
				+ imgpath + ", imgname=" + imgname + "]";
	}

	
	

}
