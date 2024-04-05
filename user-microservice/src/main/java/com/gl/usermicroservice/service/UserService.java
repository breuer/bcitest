package com.gl.usermicroservice.service;

import com.gl.usermicroservice.constants.Constants;
import com.gl.usermicroservice.dto.UserCreatedDTO;
import com.gl.usermicroservice.dto.UserInfoDTO;
import com.gl.usermicroservice.dto.UserRequestDTO;
import com.gl.usermicroservice.exception.InputDataException;
import com.gl.usermicroservice.exception.UserAlreadyExistsException;
import com.gl.usermicroservice.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
 	
	public UserCreatedDTO createUser(UserRequestDTO request) {
		User user = modelMapper.map(request, User.class);
		if(!checkEmail(user)) { 
			throw new InputDataException(Constants.EMAIL_MALFORMED);
		}
		if(userExist(user)) {
			throw new UserAlreadyExistsException(Constants.USER_ALREADY_EXISTS);
		}
		if(!checkPassword(user))
			throw new InputDataException(Constants.PASSWORD_MALFORMED);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreated(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		User userCreated = repository.save(user);
		UserCreatedDTO response = modelMapper.map(userCreated, UserCreatedDTO.class);
		response.setToken(jwtService.generateToken(user.getEmail()));
		return response;
	}
	
    public boolean userExist(User user) {
    	return repository.findByEmail(user.getEmail()) != null;
    }
    
    public UserInfoDTO getUserByToken(String token) {
    	String username = jwtService.getUsernameFromToken(token);
    	User userFound = repository.findByEmail(username);
    	UserInfoDTO response = modelMapper.map(userFound, UserInfoDTO.class);
        response.setToken(jwtService.generateToken(username));
        response.setLastLogin(LocalDateTime.now());
    	return response;
    }
    
    public Boolean checkEmail(User user) {
    	return Pattern.matches(Constants.REGEX_EMAIL, user.getEmail());
    }
    
    public Boolean checkPassword(User user) {
		return Pattern.matches(Constants.REGEX_PASSWORD, user.getPassword());
    }
}
