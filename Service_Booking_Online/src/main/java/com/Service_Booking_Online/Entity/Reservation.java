package com.Service_Booking_Online.Entity;

import java.sql.Date;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.Service_Booking_Online.dto.ReservationDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reservid; 
	
	private ReservationStatus reservationStatus;

	private ReviewStatus reviewStatus;
	
	private String bookDate;
	
	private String companyname;
	
	private String username;
	
	private String servicename;
	
	private int refid;
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(nullable = false,name = "userid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ServiceEntity user;

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(nullable = false,name = "companyid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ServiceEntity company;

	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(nullable = false,name = "adid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AdEntity ad;



	
	
	
	public int getRefid() {
		return refid;
	}


	public void setRefid(int refid) {
		this.refid = refid;
	}


	public int getReservid() {
		return reservid;
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






	public void setReservid(int reservid) {
		this.reservid = reservid;
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




	public String getBookDate() {
		return bookDate;
	}




	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}




	public ServiceEntity getUser() {
		return user;
	}




	public void setUser(ServiceEntity user) {
		this.user = user;
	}




	public ServiceEntity getCompany() {
		return company;
	}




	public void setCompany(ServiceEntity company) {
		this.company = company;
	}




	public AdEntity getAd() {
		return ad;
	}




	public void setAd(AdEntity ad) {
		this.ad = ad;
	}
	

	@Override
	public String toString() {
		return "Reservation [reservid=" + reservid + ", reservationStatus=" + reservationStatus + ", reviewStatus="
				+ reviewStatus + ", bookDate=" + bookDate + ", companyname=" + companyname + ", username=" + username
				+ ", servicename=" + servicename + ", refid=" + refid + ", user=" + user + ", company=" + company
				+ ", ad=" + ad + "]";
	}


	public Reservation() {
	
	}

	public ReservationDTO reservationDto() {
		ReservationDTO reservDto=new ReservationDTO();
		
		reservDto.setBookDate(bookDate);
		reservDto.setReservationStatus(reservationStatus);
		reservDto.setReservid(reservid);
		reservDto.setServiceName(ad.getServiceName());
		reservDto.setUserName(user.getFname()+user.getLname());
		reservDto.setReviewStatus(reviewStatus);
		
		reservDto.setAdid(ad.getId());
		reservDto.setCompanyid(company.getId());
		reservDto.setUserid(user.getId());
		
		reservDto.setCompanyname(companyname);
		reservDto.setUsername(username);
		reservDto.setServicename(servicename);
		
		reservDto.setRefid(refid);
		
		return reservDto;
	}
}
