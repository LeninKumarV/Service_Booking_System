package com.Service_Booking_Online.ServiceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service_Booking_Online.Entity.ServiceEntity;
import com.Service_Booking_Online.dto.LoginDto;
import com.Service_Booking_Online.dto.SignupRequestDTO;
import com.Service_Booking_Online.dto.UserDto;
import com.Service_Booking_Online.service.AuthService;
import com.Service_Booking_Online.userRole.UserRole;

@CrossOrigin("*")
@RestController
@RequestMapping("/service_booking")
public class ServiceController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/client-signup")
	public ResponseEntity<?> clientSignup(@RequestBody SignupRequestDTO signRequestDTO ) {
		
		if(authService.presentByEmail(signRequestDTO.getEmail())) {
			return new ResponseEntity<>("Client email is already exist",HttpStatus.NOT_ACCEPTABLE);
		}
		
		UserDto userDto=authService.clientAuth(signRequestDTO);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
		
	}

	@PostMapping("/company-signup")
	public ResponseEntity<?> companySignup(@RequestBody SignupRequestDTO signupRequestDTO){
		
		if(authService.presentByEmail(signupRequestDTO.getEmail())) {
			return new ResponseEntity<>("Company email is already exist",HttpStatus.NOT_ACCEPTABLE);
		}
		
		UserDto userDto=authService.companyAuth(signupRequestDTO);
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<?> checkLogin(@PathVariable String email,@PathVariable String password){
		
		if(authService.presentByEmail(email)) {
			LoginDto userDto=authService.loginProcess(email,password);
			return new ResponseEntity<>(userDto,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Email is not signed here !",HttpStatus.NOT_ACCEPTABLE);	
	}
}
