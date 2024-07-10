package com.Service_Booking_Online.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Service_Booking_Online.Entity.Reservation;
import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.dto.AdDto;
import com.Service_Booking_Online.dto.ReservationDTO;
import com.Service_Booking_Online.Entity.AdEntity;



@Repository
@Component
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	String query="select * from reservation where refid =:refid";
	
	@Query(nativeQuery = true,value = query)
	List<Reservation> findAllByRefid(@Param(value = "refid") int refid);
	
}
