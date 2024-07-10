package com.Service_Booking_Online.dto;

import com.Service_Booking_Online.userRole.UserRole;

public class LoginDto {

	private int userid;
	
	private UserRole role;

	public LoginDto(int userid, UserRole role) {
		this.userid = userid;
		this.role = role;
	}
	
	public LoginDto() {
	}

	public int getId() {
		return userid;
	}

	public void setId(int userid) {
		this.userid = userid;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginDto [userid=" + userid + ", role=" + role + "]";
	}
	
	
	

}
