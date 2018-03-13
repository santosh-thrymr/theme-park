package com.themepark.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.themepark.dto.AnnualPassDto;
import com.themepark.dto.BigLondonAdmissionFeeDto;
import com.themepark.dto.EntryPackageDto;
import com.themepark.dto.SingleEntryPassDto;
import com.themepark.dto.UserRegistrationDto;
import com.themepark.enums.Gender;
import com.themepark.model.AnnualPass;
import com.themepark.model.AppUser;
import com.themepark.model.AppUserAnnualPass;
import com.themepark.model.AppUserBLAdmissionFee;
import com.themepark.model.AppUserEntryPackage;
import com.themepark.model.AppUserSingleEntryPass;
import com.themepark.model.BigLondonAdmissionFee;
import com.themepark.model.EntryPackage;
import com.themepark.model.SingleEntryPass;
import com.themepark.repository.AnnualPassRepository;
import com.themepark.repository.AppUserAnnualPassRepository;
import com.themepark.repository.AppUserBLAdmissionFeeRepository;
import com.themepark.repository.AppUserEntryPackageRepository;
import com.themepark.repository.AppUserRepository;
import com.themepark.repository.AppUserSingleEntryPassRepository;
import com.themepark.repository.BLAdmissionFeeRepository;
import com.themepark.repository.EntryPackageRepository;
import com.themepark.repository.SingleEntryPassRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository userRepository;
    
    @Autowired
    private EntryPackageRepository entryPackageRepository;
    
    @Autowired
    private AppUserEntryPackageRepository appUserEntryPackageRepository;
    
    @Autowired
    private SingleEntryPassRepository singleEntryPassRepository;
    
    @Autowired
    private AppUserSingleEntryPassRepository appUserSingleEntryPassRepository;
    
    @Autowired
    private AnnualPassRepository annualPassRepository;
    
    @Autowired
    private AppUserAnnualPassRepository appUserAnnualPassRepository;
    
    @Autowired
    private BLAdmissionFeeRepository blAdmissionFeeRepository;
    
    @Autowired
    private AppUserBLAdmissionFeeRepository appUserBLAdmissionFeeRepository;

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
        
        user.setTopup(registrationDto.getTopup());
        
        AppUser appUser = userRepository.save(user);
        
        //Saving packages data
        saveEntryPackages(appUser, registrationDto);
        
        //Saving Single entry pass data
        saveSingleEntryPass(appUser, registrationDto);
        
        //Saving Annual pass data
        saveAnnualPass(appUser, registrationDto);
        
        //Saving Big london admission fee data
        saveBigLondonAdmissionFee(appUser, registrationDto);
        
        return appUser;
    }
    
	private void saveEntryPackages(AppUser appUser, UserRegistrationDto registrationDto) {
		Float totalAmountPaid = 0F;
		for (EntryPackageDto dto : registrationDto.getEntryPackageDtos()) {
			if (dto.getId() != null && dto.getSelectedCount() != null) {
				EntryPackage entryPackage = this.entryPackageRepository.findOne(dto.getId());

				AppUserEntryPackage appUserEntryPackage = this.appUserEntryPackageRepository
						.findByAppUserAndEntryPackage(appUser, entryPackage);
				if (appUserEntryPackage == null) {
					appUserEntryPackage = new AppUserEntryPackage();
				}

				appUserEntryPackage.setAppUser(appUser);
				appUserEntryPackage.setEntryPackage(entryPackage);
				appUserEntryPackage.setSelectedCount(dto.getSelectedCount());
				if (entryPackage.getPrice() != null) {
					appUserEntryPackage.setPrice(dto.getSelectedCount() * entryPackage.getPrice());
					totalAmountPaid += dto.getSelectedCount() * entryPackage.getPrice();
				}
				appUserEntryPackageRepository.save(appUserEntryPackage);
			}
		}
		appUser.setTotalPaidForPackages(totalAmountPaid);
	}

	private void saveSingleEntryPass(AppUser appUser, UserRegistrationDto registrationDto) {
		Float totalAmountPaid = 0F;
		for (SingleEntryPassDto dto : registrationDto.getSingleEntryPassDtos()) {
			if (dto.getId() != null && dto.getSelectedCount() != null) {
				SingleEntryPass singleEntryPass = this.singleEntryPassRepository.findOne(dto.getId());

				AppUserSingleEntryPass appUserSingleEntryPass = this.appUserSingleEntryPassRepository
						.findByAppUserAndSingleEntryPass(appUser, singleEntryPass);
				if (appUserSingleEntryPass == null) {
					appUserSingleEntryPass = new AppUserSingleEntryPass();
				}

				appUserSingleEntryPass.setAppUser(appUser);
				appUserSingleEntryPass.setSingleEntryPass(singleEntryPass);

				if (!StringUtils.isEmpty(registrationDto.getNationality())
						&& registrationDto.getNationality().equals("malaysian")) {

					appUserSingleEntryPass.setMyKidOrMyKadCount(dto.getSelectedCount());
					if (singleEntryPass.getMyKadOrMyKidRate() != null) {
						appUserSingleEntryPass.setPrice(dto.getSelectedCount() * singleEntryPass.getMyKadOrMyKidRate());
						totalAmountPaid += dto.getSelectedCount() * singleEntryPass.getMyKadOrMyKidRate();
					}
				} else {
					appUserSingleEntryPass.setStandardCount(dto.getSelectedCount());
					if (singleEntryPass.getStandardRate() != null) {
						appUserSingleEntryPass.setPrice(dto.getSelectedCount() * singleEntryPass.getStandardRate());
						totalAmountPaid += dto.getSelectedCount() * singleEntryPass.getStandardRate();
					}
				}

				this.appUserSingleEntryPassRepository.save(appUserSingleEntryPass);
			}
		}
		
		appUser.setTotalPaidForSingleEntryPass(totalAmountPaid);
	}

	private void saveAnnualPass(AppUser appUser, UserRegistrationDto registrationDto) {
		Float totalAmountPaid = 0F;
		for (AnnualPassDto dto : registrationDto.getAnnualPassDtos()) {
			if (dto.getId() != null && dto.getSelectedCount() != null) {
				AnnualPass annualPass = this.annualPassRepository.findOne(dto.getId());

				AppUserAnnualPass appUserAnnualPass = this.appUserAnnualPassRepository
						.findByAppUserAndAnnualPass(appUser, annualPass);
				if (appUserAnnualPass == null) {
					appUserAnnualPass = new AppUserAnnualPass();
				}

				appUserAnnualPass.setAppUser(appUser);
				appUserAnnualPass.setAnnualPass(annualPass);

				if (annualPass.getPrice() != null) {
					appUserAnnualPass.setPrice(dto.getSelectedCount() * annualPass.getPrice());
					totalAmountPaid += dto.getSelectedCount() * annualPass.getPrice();
				}

				this.appUserAnnualPassRepository.save(appUserAnnualPass);
			}
		}
		
		appUser.setTotalPaidForAnnualPass(totalAmountPaid);
	}
	
	private void saveBigLondonAdmissionFee(AppUser appUser, UserRegistrationDto registrationDto) {
		Float totalAmountPaid = 0F;
		for (BigLondonAdmissionFeeDto dto : registrationDto.getBigLondonAdmissionFeeDtos()) {
			if (dto.getId() != null) {
				BigLondonAdmissionFee bigLondonAdmissionFee = this.blAdmissionFeeRepository.findOne(dto.getId());
				
				AppUserBLAdmissionFee appUserBLAdmissionFee = this.appUserBLAdmissionFeeRepository
						.findByAppUserAndBigLondonAdmissionFee(appUser, bigLondonAdmissionFee);
				
				if (appUserBLAdmissionFee != null) {
					appUserBLAdmissionFee = new AppUserBLAdmissionFee();
				}
				
				appUserBLAdmissionFee.setAppUser(appUser);
				appUserBLAdmissionFee.setBigLondonAdmissionFee(bigLondonAdmissionFee);
				
				if (dto.getAdultSelectedCount() != null) {
					appUserBLAdmissionFee.setAdultSelectedCount(dto.getAdultSelectedCount());
					if (!StringUtils.isEmpty(registrationDto.getNationality())
							&& registrationDto.getNationality().equals("malaysian")) {
						
						if (bigLondonAdmissionFee.getAdultsMyKRate() != null) {
							appUserBLAdmissionFee.setAdultsPrice(dto.getAdultSelectedCount() * bigLondonAdmissionFee.getAdultsMyKRate());
							totalAmountPaid += dto.getAdultSelectedCount() * bigLondonAdmissionFee.getAdultsMyKRate();
						}
					} else {
						if (bigLondonAdmissionFee.getAdultsStandardRate() != null) {
							appUserBLAdmissionFee.setAdultsPrice(dto.getAdultSelectedCount() * bigLondonAdmissionFee.getAdultsStandardRate());
							totalAmountPaid += dto.getAdultSelectedCount() * bigLondonAdmissionFee.getAdultsStandardRate();
						}
					}
					
					this.appUserBLAdmissionFeeRepository.save(appUserBLAdmissionFee);
				} else if (dto.getKidsOrSrCitizenSelectedCount() != null) {
					appUserBLAdmissionFee.setKidsOrSrCitizenSelectedCount(dto.getKidsOrSrCitizenSelectedCount());
					
					if (!StringUtils.isEmpty(registrationDto.getNationality())
							&& registrationDto.getNationality().equals("malaysian")) {
						
						if (bigLondonAdmissionFee.getKidsOrSrCitizenMyKRate() != null) {
							appUserBLAdmissionFee.setKidsOrSrCitizenPrice(dto.getKidsOrSrCitizenSelectedCount() * bigLondonAdmissionFee.getKidsOrSrCitizenMyKRate());
							totalAmountPaid += dto.getKidsOrSrCitizenSelectedCount() * bigLondonAdmissionFee.getKidsOrSrCitizenMyKRate();
						}
					} else {
						if (bigLondonAdmissionFee.getKidsOrSrCitizenStandardRate() != null) {
							appUserBLAdmissionFee.setKidsOrSrCitizenPrice(dto.getKidsOrSrCitizenSelectedCount() * bigLondonAdmissionFee.getKidsOrSrCitizenStandardRate());
							totalAmountPaid += dto.getKidsOrSrCitizenSelectedCount() * bigLondonAdmissionFee.getKidsOrSrCitizenStandardRate();
						}
					}
					
					this.appUserBLAdmissionFeeRepository.save(appUserBLAdmissionFee);
				}
			}
		}
		
		appUser.setTotalPaidForBigLondonFee(totalAmountPaid);
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
