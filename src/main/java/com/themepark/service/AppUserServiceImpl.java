package com.themepark.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.themepark.model.AppUser;
import com.themepark.model.Gender;
import com.themepark.model.Role;
import com.themepark.repository.AppUserRepository;
import com.themepark.web.dto.UserRegistrationDto;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    /*@Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

    public AppUser findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public AppUser save(UserRegistrationDto registrationDto, MultipartFile multipartFile){
        AppUser user = new AppUser();
        
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setDisplayName(registrationDto.getDisplayName());
        user.setRole(Role.USER);
        
		if (multipartFile != null && !multipartFile.isEmpty()) {
			try {
				user.setAvatar(multipartFile.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        user.setEnableSmsUpdate(registrationDto.getEnableSmsUpdate());
        user.setEnableEmailUpdate(registrationDto.getEnableEmailUpdate());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setMobileNumber(registrationDto.getMobileNumber());
        
		if (!StringUtils.isEmpty(registrationDto.getDob())) {
			try {
				user.setDob(new SimpleDateFormat("dd-MM-yyyy").parse(registrationDto.getDob()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        if (!StringUtils.isEmpty(registrationDto.getGender())) {
        		user.setGender(Gender.valueOf(registrationDto.getGender()));
        }
        
        user.setAddress(registrationDto.getAddress());
        user.setCountryOfResidence(registrationDto.getCountryOfResidence());
        user.setNationality(registrationDto.getNationality());
        user.setPostalCode(registrationDto.getPostalCode());
        user.setIdentityNumber(registrationDto.getIdentityNumber());
        
        Float  amountToBePaid = 0F;
        if (registrationDto.getNoOfChilds() != null) {
	        	user.setNoOfChilds(registrationDto.getNoOfChilds());
	        	amountToBePaid += registrationDto.getNoOfChilds() * 100F;
	        	user.setAmountToBePaid(amountToBePaid);
        }
        if (registrationDto.getNoOfAdults() != null) {
        		user.setNoOfAdults(registrationDto.getNoOfAdults());
	        	amountToBePaid += registrationDto.getNoOfAdults() * 200F;
	        	user.setAmountToBePaid(amountToBePaid);
	    }
        
        user.setTopup(registrationDto.getTopup());
        
        return userRepository.save(user);
    }

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }*/
}
