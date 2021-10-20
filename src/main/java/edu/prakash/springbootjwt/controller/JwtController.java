package edu.prakash.springbootjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.prakash.springbootjwt.model.JwtRequestModel;
import edu.prakash.springbootjwt.model.JwtResponseModel;
import edu.prakash.springbootjwt.service.CustomUserDetailService;
import edu.prakash.springbootjwt.util.JwtUtility;

@RestController
public class JwtController {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("token")
	public ResponseEntity<?> generateToke(@RequestBody JwtRequestModel jwtRequestModel) throws Exception {
		System.out.println(jwtRequestModel);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					jwtRequestModel.getUserName(), jwtRequestModel.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Unauthticated!!");
		}
		UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequestModel.getUserName());
		String token = jwtUtility.generateToken(userDetails);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponseModel(token));
	}
}
