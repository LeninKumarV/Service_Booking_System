package com.Service_Booking_Online.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.Service_Booking_Online.Entity.AdEntity;
import com.Service_Booking_Online.dto.AdDto;

public interface AdService {
	public boolean postAd(int id,String description,MultipartFile file, double price,String service_name) throws IOException;

	public List<AdDto> displayAd(int userid );
	
	public AdEntity updateAd(int id,int userid,String description,String service_name, double price, MultipartFile img) throws IOException;

	public boolean checkUpdateAd(int id);
	
	public boolean deleteAd(int id);
	
	public List<AdDto> displaySingleAd(int id);

}
