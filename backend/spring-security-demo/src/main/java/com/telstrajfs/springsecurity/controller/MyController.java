package com.telstrajfs.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telstrajfs.springsecurity.model.AuthenticationRequest;
import com.telstrajfs.springsecurity.model.AuthenticationResponse;
import com.telstrajfs.springsecurity.util.JwtUtil;

@RestController
public class MyController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to Spring Security. You are Authorized! ";
	}
	
	@GetMapping("/hello/{name}")
	public String getGreeting(@PathVariable("name") String name) {
		return "Welcome "+name+" You  are authorized to access this page";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{
		try {
			System.out.println(request.getUsername()+" "+request.getPassword());
			//static user and password here
			final String usr="root";
			final String pass="ok";
			if(!request.getUsername().equals(usr) || !request.getPassword().equals(pass)) {
				throw new BadCredentialsException("Incorrecct username or passowrd");
			}
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
//					(request.getUsername(), request.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrecct username or passowrd",e);
		}
		
		final UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUsername());
		final String jwt=jwtUtil.generateToken(userDetails);
		System.out.println("hey  "+jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
