package com.Service_Booking_Online.dto;

import java.sql.Date;

import com.Service_Booking_Online.Entity.ReservationStatus;
import com.Service_Booking_Online.Entity.ReviewStatus;


public class ReservationDTO {

	private int reservid; 
		
	private String bookDate;
	
	private String serviceName;
	
	private ReservationStatus reservationStatus;

	private ReviewStatus reviewStatus;

	private int userid;
	
	private String userName;
	
	private int companyid;
	
	private int adid;
	
	private String companyname;
	
	private String username;
	
	private String servicename;

	private int refid;
	
	
	
	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public int getReservid() {
		return reservid;
	}

	public void setReservid(int reservid) {
		this.reservid = reservid;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate2) {
		this.bookDate = bookDate2;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public int getAdid() {
		return adid;
	}

	public void setAdid(int adid) {
		this.adid = adid;
	}

	
	@Override
	public String toString() {
		return "ReservationDTO [reservid=" + reservid + ", bookDate=" + bookDate + ", serviceName=" + serviceName
				+ ", reservationStatus=" + reservationStatus + ", reviewStatus=" + reviewStatus + ", userid=" + userid
				+ ", userName=" + userName + ", companyid=" + companyid + ", adid=" + adid + ", companyname="
				+ companyname + ", username=" + username + ", servicename=" + servicename + ", refid=" + refid + "]";
	}

	
	public ReservationDTO(int reservid, String bookDate, String serviceName, ReservationStatus reservationStatus,
			ReviewStatus reviewStatus, int userid, String userName, int companyid, int adid) {
		this.reservid = reservid;
		this.bookDate = bookDate;
		this.serviceName = serviceName;
		this.reservationStatus = reservationStatus;
		this.reviewStatus = reviewStatus;
		this.userid = userid;
		this.userName = userName;
		this.companyid = companyid;
		this.adid = adid;
	}

	public ReservationDTO() {

	}	
}
