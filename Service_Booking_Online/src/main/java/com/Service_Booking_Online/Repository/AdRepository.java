package com.Service_Booking_Online.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Service_Booking_Online.Entity.AdEntity;
import com.Service_Booking_Online.dto.AdDto;

@Repository
@Component
public interface AdRepository extends JpaRepository<AdEntity, Integer>{

	List<AdEntity> findByUserid(int userid);
	
	List<AdEntity> findByServiceName(String serviceName);
	
	boolean existsByServiceName(String serviceName);
	
	List<AdEntity> findByServiceNameContains(String serviceName);

}
