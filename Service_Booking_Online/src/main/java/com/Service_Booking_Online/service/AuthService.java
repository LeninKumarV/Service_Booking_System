package com.Service_Booking_Online.service;

import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.dto.LoginDto;
import com.Service_Booking_Online.dto.SignupRequestDTO;
import com.Service_Booking_Online.dto.UserDto;
import com.Service_Booking_Online.userRole.UserRole;

public interface AuthService {

	public UserDto clientAuth(SignupRequestDTO signupRequestDto);

	public boolean presentByEmail(String email);

	public UserDto companyAuth(SignupRequestDTO signupRequestDTO);

	public LoginDto loginProcess(String email,String password);
}
