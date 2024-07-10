package com.Service_Booking_Online.Entity;

import com.Service_Booking_Online.userRole.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class ServiceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
	private String fname;
	
	private String lname;

	private String email;
	
	private String password;
	
	private UserRole role;
	
	private long phone;

	public ServiceEntity(int userid, String fname, String lname, String email, String password, long phone) {
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	public ServiceEntity() {
		
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
	
	
}

