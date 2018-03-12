package com.themepark.service;

import org.springframework.web.multipart.MultipartFile;

import com.themepark.model.AppUser;
import com.themepark.web.dto.UserRegistrationDto;

//public interface UserService extends UserDetailsService {
public interface AppUserService {

	AppUser findByEmail(String email);

	AppUser save(UserRegistrationDto registration, MultipartFile multipartFile);
}
