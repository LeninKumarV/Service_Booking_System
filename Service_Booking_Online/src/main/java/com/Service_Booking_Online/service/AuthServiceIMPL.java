package com.Service_Booking_Online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.Repository.ServiceRepository;
import com.Service_Booking_Online.dto.LoginDto;
import com.Service_Booking_Online.dto.SignupRequestDTO;
import com.Service_Booking_Online.dto.UserDto;
import com.Service_Booking_Online.userRole.UserRole;

@Service
public class AuthServiceIMPL implements AuthService{

	@Autowired
	private ServiceRepository repo;
	
	public UserDto clientAuth(SignupRequestDTO signupRequestDto) {
		ServiceEntity se=new ServiceEntity();
		se.setEmail(signupRequestDto.getEmail());
		se.setFname(signupRequestDto.getFname());
		se.setLname(signupRequestDto.getLname());
		se.setPassword(signupRequestDto.getPassword());
		se.setPhone(signupRequestDto.getPhone());
		se.setRole(UserRole.CLIENT);
		
		repo.save(se);
		
		return new UserDto(signupRequestDto.getId()
				, signupRequestDto.getFname()
				, signupRequestDto.getLname()
				, signupRequestDto.getEmail()
				, signupRequestDto.getPassword(),
				UserRole.CLIENT, 
				signupRequestDto.getPhone());
	}
	
	
	public boolean presentByEmail(String email) {
		return repo.findFirstByEmail(email)!=null; 
	}

	
	@Override
	public UserDto companyAuth(SignupRequestDTO signupRequestDTO) {
		ServiceEntity userDto=new ServiceEntity();
		userDto.setEmail(signupRequestDTO.getEmail());
		userDto.setFname(signupRequestDTO.getFname());
		userDto.setPassword(signupRequestDTO.getPassword());
		userDto.setPhone(signupRequestDTO.getPhone());
	
		userDto.setRole(UserRole.COMPANY);
		
		repo.save(userDto);
		
		return  new UserDto(signupRequestDTO.getId()
				, signupRequestDTO.getFname()
				, signupRequestDTO.getEmail()
				, signupRequestDTO.getPassword(),
				UserRole.COMPANY, 
				signupRequestDTO.getPhone());
	}


	@Override
	public LoginDto loginProcess(String email,String password) {		
		ServiceEntity se=repo.findFirstByEmail(email);
		LoginDto loginDto=new LoginDto();
		
		if(se.getEmail().toString().equals(email.toString()) && 
		   se.getPassword().toString().equals(password.toString())) {
			System.out.println("True");

			loginDto.setId(se.getId());
			loginDto.setRole(se.getRole());
			return loginDto;
		}	
		
		loginDto.setRole(UserRole.ERROR);
		return loginDto;

	}

	
}
