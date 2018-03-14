package com.themepark.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.themepark.dto.LoginDto;
import com.themepark.dto.UserRegistrationDto;
import com.themepark.model.AppUser;

//public interface UserService extends UserDetailsService {
public interface AppUserService {

	AppUser findByEmail(String email);

	AppUser save(UserRegistrationDto registration, MultipartFile multipartFile, AppUser createdBy);

	AppUser getLoggedInUser(Object appUserId);
	
	AppUser validateUser(LoginDto loginDto);
	
	List<UserRegistrationDto> getRegisteredUsers();
	
	List<UserRegistrationDto> mapRegisteredUsers(List<AppUser> appUsers);
}
