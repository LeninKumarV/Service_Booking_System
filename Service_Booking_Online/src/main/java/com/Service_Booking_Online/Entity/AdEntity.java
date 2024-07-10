package com.Service_Booking_Online.Entity;

import java.util.Arrays;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.web.multipart.MultipartFile;

import com.Service_Booking_Online.dto.AdDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ads")
public class AdEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name  = "service_name")
	private String serviceName;
	
	@Column(name  = "description")
	private String description;
	
	@Column(name  = "price")
	private double price;
		
	@Lob
	@Column(name  = "img")
	private byte[] img;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	//UserDetails
	@JoinColumn(name = "userdet")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ServiceEntity serviceEntity;
	
	@Column(name = "userid")
	private int userid;
	
	
	//file format for image usage
	@Column(name = "filename")
	private String filename;
	
	@Column(name = "filetype")
	private String filecontenttype;;
	
	@Column(name = "originalfile")
	private String originalfilename;
	
	

	
	public AdEntity(int id, String serviceName, String description, double price, byte[] img,
			ServiceEntity serviceEntity, int userid, String filename, String filecontenttype, String originalfilename) {
		this.id = id;
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		this.img = img;
		this.serviceEntity = serviceEntity;
		this.userid = userid;
		this.filename = filename;
		this.filecontenttype = filecontenttype;
		this.originalfilename = originalfilename;
	}

	public AdEntity() {
	
	}

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

	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}


	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilecontenttype() {
		return filecontenttype;
	}

	public void setFilecontenttype(String filecontenttype) {
		this.filecontenttype = filecontenttype;
	}

	public String getOriginalfilename() {
		return originalfilename;
	}

	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}


	@Override
	public String toString() {
		return "AdEntity [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price="
				+ price + ", img=" + Arrays.toString(img) + ", serviceEntity=" + serviceEntity + ", userid=" + userid
				+ ", filename=" + filename + ", filecontenttype=" + filecontenttype + ", originalfilename="
				+ originalfilename + "]";
	}
	
	
//	public MultipartFile getImg() {
//		return img;
//	}
//
//	public void setImg(MultipartFile img) {
//		this.img = img;
//	}


	public AdDto getDto() {
		AdDto adDto=new AdDto();
		adDto.setDescription(description);
		adDto.setId(id);
		adDto.setReturnedImg(img);
		adDto.setPrice(price);
		adDto.setServiceName(serviceName);
//		adDto.setServiceEntity(serviceEntity);
		adDto.setUserid(userid);
		
		return adDto;
	}
	
	
}
