package com.Service_Booking_Online.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.Service_Booking_Online.Entity.AdEntity;
import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.Repository.AdRepository;
import com.Service_Booking_Online.Repository.ServiceRepository;
import com.Service_Booking_Online.dto.AdDto;

@Service
public class AdServiceIMPL implements AdService{

	@Autowired
	private ServiceRepository serviceRepo;
	
	@Autowired
	private AdRepository adRepo;
	
	
	public boolean postAd(int id,String description,MultipartFile file, double price,String service_name) throws IOException{
		Optional<ServiceEntity> ser=serviceRepo.findById(id);
		
		if(ser.isPresent()) {
				AdEntity ad=new AdEntity();
				ad.setDescription(description);
				ad.setPrice(price);
				ad.setServiceEntity(ser.get());
				ad.setImg(file.getBytes());
				ad.setServiceName(service_name);
				ad.setUserid(ser.get().getId());
				ad.setFilecontenttype(file.getContentType());
				ad.setFilename(file.getName());
				ad.setOriginalfilename(file.getOriginalFilename());
				
				adRepo.save(ad);
				System.out.println(ad);		
				
				return true;
		}
		return false;
	}
	
	public List<AdDto> displayAd(int userid ) {
		List<AdDto> result=adRepo.findByUserid(userid).stream().map(AdEntity::getDto).collect(Collectors.toList());
		
		return result;
	}
	
	
	public AdEntity updateAd(int id,int userid,String description,String service_name, double price, MultipartFile img) throws IOException {
		Optional<AdEntity> ad=adRepo.findById(id);
		Optional<ServiceEntity> ser=serviceRepo.findById(userid);
		
		if(ad.isPresent()) {
			AdEntity result=new AdEntity();
			result.setId(id);
			result.setDescription(description);
			result.setImg(img.getBytes());
			result.setPrice(price);
			result.setServiceEntity(ser.get());
			result.setUserid(userid);
			result.setServiceName(service_name);
			result.setFilecontenttype(img.getContentType());
			result.setFilename(img.getName());
			result.setOriginalfilename(img.getOriginalFilename());
			
			adRepo.save(result);
			return result;
		}
		else {
			return null;
		}
	}
	
	public boolean checkUpdateAd(int id) {
		
		return adRepo.existsById(id);
	}
	
	public boolean deleteAd(int id){

		if(adRepo.existsById(id)) {
			adRepo.deleteById(id);
			return true;
		}
		else {
			return false;	
		}
	}
	
	
	public List<AdDto> displaySingleAd(int id) {
		List<AdDto> ops= adRepo.findById(id).stream().map(AdEntity::getDto).collect(Collectors.toList());
		
		return ops;
	}
}