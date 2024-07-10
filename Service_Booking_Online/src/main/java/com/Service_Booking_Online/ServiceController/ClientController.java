package com.Service_Booking_Online.ServiceController;

import org.apache.catalina.connector.Response;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Service_Booking_Online.Repository.AdRepository;
import com.Service_Booking_Online.Repository.ReservationRepository;
import com.Service_Booking_Online.dto.AdDto;
import com.Service_Booking_Online.dto.ReservationDTO;
import com.Service_Booking_Online.service.AdService;
import com.Service_Booking_Online.service.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private AdService adService;
	
	@Autowired
	private AdRepository adRepo;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ReservationRepository reRepo;
	
	@GetMapping("/clientData")
	public ResponseEntity<?> clientData(){
		return new ResponseEntity<>(clientService.clientData(),HttpStatus.OK);
	}
	
	@GetMapping("/clientSearch")
	public ResponseEntity<?> clientSearchData(@RequestParam String serviceName){
		java.util.List<AdDto> search=clientService.searchClientData(serviceName);
		
		if(!search.isEmpty()) {
			System.out.println(search);
			return new ResponseEntity<>(clientService.searchClientData(serviceName),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Matches here!",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/bookService/{ad}/{user}/{bookDate}")
	public ResponseEntity<?> bookingServiceData(
				@PathVariable("ad") int ad,
				@PathVariable("user") int user,
				@PathVariable("bookDate") String bookDate
			){
		if(clientService.bookService(ad,user, bookDate)) {
			return new ResponseEntity<>("Booked",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Something went wrong",HttpStatus.NOT_ACCEPTABLE);	
		}
	}
	
	
	@GetMapping("/viewAd/{id}")
	public ResponseEntity<?> viewSingleAd(@PathVariable int id){
		if(clientService.viewAdCheck(id)) {
			return new ResponseEntity<>(clientService.viewAd(id),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Something went wrong",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getAllBookings")
	public ResponseEntity<?> getAllBookings(){
		if(!clientService.getAllRerservation().isEmpty()) {
			return new ResponseEntity<>(clientService.getAllRerservation(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Data Here!",HttpStatus.GONE);			
		}
	}
	
	
	@GetMapping("/getCompanyAds/{refid}")
	public ResponseEntity<?> getCompanyAds(@PathVariable("refid") int refid){
		if(!clientService.getCompanyReservation(refid).isEmpty()) {
			return new ResponseEntity<>(clientService.getCompanyReservation(refid),HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<>("No Data Here!",HttpStatus.GONE);				
		}
	}
	
	
	@PutMapping("/accepted/{reservid}")
	public ResponseEntity<?> updateByAccept(@PathVariable("reservid") int reservid){
		if(clientService.updatedByAccept(reservid)) {
			return new ResponseEntity<>("Succesfully Updated",HttpStatus.OK);				
		}
		else {
			return new ResponseEntity<>("Updated Failed",HttpStatus.GONE);	
		}
	}
	
	
	@PutMapping("/rejected/{reservid}")
	public ResponseEntity<?> rejectByAccept(@PathVariable("reservid") int reservid){
		if(clientService.rejectByAccept(reservid)) {
			return new ResponseEntity<>("Succesfully Updated",HttpStatus.OK);				
		}
		else {
			return new ResponseEntity<>("Updated Failed",HttpStatus.GONE);	
		}
	}
}
