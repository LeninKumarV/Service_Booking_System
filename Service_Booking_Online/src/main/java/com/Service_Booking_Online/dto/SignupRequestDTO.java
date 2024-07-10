package com.Service_Booking_Online.dto;

import com.Service_Booking_Online.userRole.UserRole;

import lombok.Data;

@Data
public class SignupRequestDTO {

	private int userid;
	
	private String fname;
	
	private String lname;

	private String email;
	
	private String password;

	private long phone;

	public int getId() {
		return userid;
	}

	public void setId(int userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	
}
