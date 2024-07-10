package com.Service_Booking_Online.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.dto.UserDto;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer>{

	ServiceEntity findFirstByEmail(String email);
	ServiceEntity findFirstByPassword(String password);
	
}
