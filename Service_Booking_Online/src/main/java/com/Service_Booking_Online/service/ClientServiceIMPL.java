package com.Service_Booking_Online.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service_Booking_Online.Entity.AdEntity;
import com.Service_Booking_Online.Entity.Reservation;
import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.Repository.AdRepository;
import com.Service_Booking_Online.Repository.ReservationRepository;
import com.Service_Booking_Online.Repository.ServiceRepository;
import com.Service_Booking_Online.dto.AdDto;
import com.Service_Booking_Online.dto.ReservationDTO;

@Service
public class ClientServiceIMPL implements ClientService{

	@Autowired
	private AdRepository adRepo;

	@Autowired
	private ServiceRepository serviceRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	
	@Override
	public List<AdDto> clientData() {
		List<AdDto> adData=adRepo.findAll().stream().map(AdEntity::getDto).collect(Collectors.toList());
		return adData;
	}
	
	
	public List<AdDto> searchClientData(String serviceName){
		
			List<AdDto> serviceData= adRepo.findByServiceNameContains(serviceName).stream().map(AdEntity::getDto).collect(Collectors.toList());
			return serviceData;
	}
	
	
	public boolean bookService(int ad,int user,String bookDate){
		Optional<AdEntity> adEntity=adRepo.findById(ad);
		Optional<ServiceEntity> serviceEntity=serviceRepo.findById(user);
		
		if(adEntity.isPresent() && serviceEntity.isPresent()) {
			ReservationDTO reserDto=new ReservationDTO();
			Reservation reser=new Reservation();
			reser.setAd(adEntity.get());
			reser.setBookDate(bookDate);
			reser.setCompany(adEntity.get().getServiceEntity());
			reser.setReservationStatus(reserDto.getReservationStatus().PENDING);
			reser.setReviewStatus(reserDto.getReviewStatus().FALSE);
			reser.setUser(serviceEntity.get());

			reser.setCompanyname(serviceEntity.get().getFname());
			reser.setUsername(serviceEntity.get().getFname()+" "+serviceEntity.get().getLname());
			reser.setServicename(adEntity.get().getServiceName());
			
			reser.setRefid(user);
			reservationRepo.save(reser);
			return true;
		}
		else {
			return false;	
		}
	}
	
	
	public AdDto viewAd(int id) {
		Optional<AdDto> ad=adRepo.findById(id).map(AdEntity::getDto);
		return ad.get();
	
	}
	
	public boolean viewAdCheck(int id) {
		Optional<AdDto> ad=adRepo.findById(id).map(AdEntity::getDto);
		if(ad.isPresent()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<ReservationDTO> getAllRerservation(){
		List<ReservationDTO> result=reservationRepo.findAll().stream().map(Reservation::reservationDto).collect(Collectors.toList());
		
		return result;
	}
	
	public List<ReservationDTO> getCompanyReservation(int refid){
		List<ReservationDTO> result=reservationRepo.findAllByRefid(refid).stream().map(Reservation::reservationDto).collect(Collectors.toList());
		
		return result;
	}
	
	public boolean updatedByAccept(int reservid) {
		Optional<Reservation> result=reservationRepo.findById(reservid);

		Optional<AdEntity> adEntity=adRepo.findById(result.get().getAd().getId());
		Optional<ServiceEntity> serviceEntity=serviceRepo.findById(result.get().getUser().getId());
		
		if(!result.isEmpty()) {
			
			Reservation reser=new Reservation();
			reser.setReservid(reservid);
			
			reser.setAd(adEntity.get());
			reser.setBookDate(result.get().getBookDate());
			reser.setCompany(adEntity.get().getServiceEntity());
			reser.setReservationStatus(result.get().getReservationStatus().APPROVED);
			reser.setReviewStatus(result.get().getReviewStatus().FALSE);
			reser.setUser(serviceEntity.get());

			reser.setCompanyname(serviceEntity.get().getFname());
			reser.setUsername(serviceEntity.get().getFname()+" "+serviceEntity.get().getLname());
			reser.setServicename(adEntity.get().getServiceName());
			
			reser.setRefid(result.get().getRefid());
			reservationRepo.save(reser);
			return true;		
		}
		else {
			return false;
		}
			
	}


	public boolean rejectByAccept(int reservid) {
		Optional<Reservation> result=reservationRepo.findById(reservid);

		Optional<AdEntity> adEntity=adRepo.findById(result.get().getAd().getId());
		Optional<ServiceEntity> serviceEntity=serviceRepo.findById(result.get().getUser().getId());
		
		if(!result.isEmpty()) {
			
			Reservation reser=new Reservation();
			reser.setReservid(reservid);
			
			reser.setAd(adEntity.get());
			reser.setBookDate(result.get().getBookDate());
			reser.setCompany(adEntity.get().getServiceEntity());
			reser.setReservationStatus(result.get().getReservationStatus().REJECTED);
			reser.setReviewStatus(result.get().getReviewStatus().FALSE);
			reser.setUser(serviceEntity.get());

			reser.setCompanyname(serviceEntity.get().getFname());
			reser.setUsername(serviceEntity.get().getFname()+" "+serviceEntity.get().getLname());
			reser.setServicename(adEntity.get().getServiceName());
			
			reser.setRefid(result.get().getRefid());
			reservationRepo.save(reser);
			return true;		
		}
		else {
			return false;
		}
			
	}


}
