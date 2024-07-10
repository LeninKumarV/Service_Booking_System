package com.Service_Booking_Online.service;

import java.util.List;

import com.Service_Booking_Online.dto.AdDto;
import com.Service_Booking_Online.dto.ReservationDTO;

public interface ClientService {

	public List<AdDto> clientData();

	public List<AdDto> searchClientData(String serviceName);
	
	public boolean bookService(int ad,int user,String bookDate);
	
	public AdDto viewAd(int id);
	
	public boolean viewAdCheck(int id);
	
	public List<ReservationDTO> getAllRerservation();

	public List<ReservationDTO> getCompanyReservation(int refid);
	
	public boolean updatedByAccept(int reservid);
	
	public boolean rejectByAccept(int reservid);
}
