package com.Service_Booking_Online.dto;

import com.Service_Booking_Online.userRole.UserRole;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {

	private int userid;
	
	private String fname;
	
	private String lname;
	
	private String email;

	private String password;
	
	private UserRole role;
	
	private long phone;
	
	public UserDto(int userid, String fname, String lname, String email, String password, UserRole role, long phone) {
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phone = phone;
	}

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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDto [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", role=" + role + ", phone=" + phone + "]";
	}
	
	public UserDto(int userid, String fname, String email, String password, UserRole role, long phone) {
		this.userid = userid;
		this.fname = fname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phone = phone;
	}

	public UserDto() {
		
	}
}
