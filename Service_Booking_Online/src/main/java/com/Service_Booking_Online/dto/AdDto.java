package com.Service_Booking_Online.dto;

import java.util.Arrays;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

import com.Service_Booking_Online.Entity.ServiceEntity;

import lombok.Data;

@Data
public class AdDto {

	private int id;
	
	private String serviceName;
	
	private String description;
	
	private Double price;
	
	private ServiceEntity serviceEntity;

	private MultipartFile img;
	
	private byte[] returnedImg;
	
	private int userid;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public byte[] getReturnedImg() {
		return returnedImg;
	}

	public void setReturnedImg(byte[] returnedImg) {
		this.returnedImg = returnedImg;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	
	@Override
	public String toString() {
		return "AdDto [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price=" + price
				+ ", serviceEntity=" + serviceEntity + ", img=" + img + ", returnedImg=" + Arrays.toString(returnedImg)
				+ ", userid=" + userid + "]";
	}
}
