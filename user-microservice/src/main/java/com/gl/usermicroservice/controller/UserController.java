package com.gl.usermicroservice.controller;


import com.gl.usermicroservice.dto.UserCreatedDTO;
import com.gl.usermicroservice.dto.UserInfoDTO;
import com.gl.usermicroservice.dto.UserRequestDTO;
import com.gl.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserController {


	private final UserService service;

	@PostMapping("/sign-up")
	public ResponseEntity<UserCreatedDTO> signUp(@Valid @RequestBody UserRequestDTO user) {

		UserCreatedDTO userCreated = service.createUser(user);
		
		return new ResponseEntity<UserCreatedDTO>(userCreated, null, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserInfoDTO> login(@RequestHeader("Authorization") String token) {
		
		UserInfoDTO userFound = service.getUserByToken(token);
		
		return new ResponseEntity<UserInfoDTO>(userFound, null, HttpStatus.OK);
	}
	
}
