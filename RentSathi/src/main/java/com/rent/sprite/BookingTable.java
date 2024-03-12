package com.rent.sprite;

import java.sql.Timestamp;
import java.util.Date;

public class BookingTable {
	
	private String name;

	private String email;

	private long mobileno;

	private String comment;
	
	private String rentType;
	
	private Date checkin;
	
	private Date checkout;
	
	private int duration;

	private Timestamp createdAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BookingTable [name=" + name + ", email=" + email + ", mobileno=" + mobileno + ", comment=" + comment
				+ ", rentType=" + rentType + ", checkin=" + checkin + ", checkout=" + checkout + ", duration="
				+ duration + ", createdAt=" + createdAt + "]";
	}
	
	

}
