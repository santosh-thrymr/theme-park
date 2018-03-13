package com.themepark.service;

import org.springframework.web.multipart.MultipartFile;

import com.themepark.dto.UserRegistrationDto;
import com.themepark.model.AppUser;

//public interface UserService extends UserDetailsService {
public interface AppUserService {

	AppUser findByEmail(String email);

	AppUser save(UserRegistrationDto registration, MultipartFile multipartFile);
}
