package com.Service_Booking_Online.ServiceController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Service_Booking_Online.Entity.AdEntity;
import com.Service_Booking_Online.Repository.AdRepository;
import com.Service_Booking_Online.dto.AdDto;
import com.Service_Booking_Online.service.AdService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/company")
public class AdController {
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private AdRepository adRepo;
	
	
	@PostMapping("/postAd/{id}/{description}/{price}/{service_name}")
	public ResponseEntity<?> postAd(
		@PathVariable("id") int id,
		@PathVariable("description") String description,
		@RequestParam("img") MultipartFile file,
		@PathVariable("price") double price,
		@PathVariable("service_name") String service_name
			) {
		System.out.println(file+" "+id+" "+description+" "+price+" "+service_name);
		
		boolean success=false;
		try {
			success=adService.postAd(id,description,file,price,service_name);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		if(success) {
			return new ResponseEntity<>(success,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(success,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/displayAd/{userid}")
	public ResponseEntity<List<AdDto>> displayData(@PathVariable("userid") int userid ){
		return new ResponseEntity<List<AdDto>>(adService.displayAd(userid),HttpStatus.OK);
	}
	
	@PutMapping("/updateAd/{id}/{userid}/{description}/{price}/{service_name}")
	public ResponseEntity<?> updateData(
			@PathVariable("id") int id,
			@PathVariable("userid")int userid,
			@PathVariable("description") String description,
			@RequestParam("img") MultipartFile img,
			@PathVariable("price") double price,
			@PathVariable("service_name") String service_name
			){
		
			System.out.println(img+" "+id+" "+description+" "+price+" "+service_name);				

			if(adService.checkUpdateAd(id)) {
				try {
					adService.updateAd(id, userid, description, service_name, price, img);
					return new ResponseEntity<>("Succssfully Updated",HttpStatus.ACCEPTED);
				}
				catch(Exception e) {
					System.err.println(e);
				}
			}
			else {
				return new ResponseEntity<>("Updated Failed",HttpStatus.NOT_MODIFIED);
			}
			return null;
	}
	

	@DeleteMapping("/deleteAd/{id}")
	public ResponseEntity<?> deleteData(@PathVariable("id") int id){
		if(adService.deleteAd(id)) {
			return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Something went wrong",HttpStatus.FAILED_DEPENDENCY);
		}
	}

	
	@GetMapping("/displaySingleData/{id}")
	public ResponseEntity<?> displaySingledata(@PathVariable int id){
		if(adRepo.existsById(id)){
			return new ResponseEntity<>(adService.displaySingleAd(id),HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>("Data's not getting here!",HttpStatus.NOT_FOUND);			
		}
	}	
}

