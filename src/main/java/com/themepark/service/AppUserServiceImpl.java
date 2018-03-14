package com.themepark.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.themepark.Constants;
import com.themepark.ReportBeanClass;
import com.themepark.dto.AnnualPassDto;
import com.themepark.dto.BigLondonAdmissionFeeDto;
import com.themepark.dto.EntryPackageDto;
import com.themepark.dto.LoginDto;
import com.themepark.dto.SingleEntryPassDto;
import com.themepark.dto.UserRegistrationDto;
import com.themepark.enums.Gender;
import com.themepark.enums.PaymentMode;
import com.themepark.enums.Role;
import com.themepark.model.AnnualPass;
import com.themepark.model.AppUser;
import com.themepark.model.AppUserAnnualPass;
import com.themepark.model.AppUserBLAdmissionFee;
import com.themepark.model.AppUserEntryPackage;
import com.themepark.model.AppUserSingleEntryPass;
import com.themepark.model.BigLondonAdmissionFee;
import com.themepark.model.EntryPackage;
import com.themepark.model.RegistrationDetails;
import com.themepark.model.SingleEntryPass;
import com.themepark.repository.AnnualPassRepository;
import com.themepark.repository.AppUserAnnualPassRepository;
import com.themepark.repository.AppUserBLAdmissionFeeRepository;
import com.themepark.repository.AppUserEntryPackageRepository;
import com.themepark.repository.AppUserRepository;
import com.themepark.repository.AppUserSingleEntryPassRepository;
import com.themepark.repository.BLAdmissionFeeRepository;
import com.themepark.repository.EntryPackageRepository;
import com.themepark.repository.RegistrationDetailsRepository;
import com.themepark.repository.SingleEntryPassRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;
    
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
    
    @Autowired
    private RegistrationDetailsRepository registrationDetailsRepository;

    /*@Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

    public AppUser findByEmail(String email){
        return appUserRepository.findByEmail(email);
    }

    @Transactional
    public AppUser save(UserRegistrationDto registrationDto, MultipartFile multipartFile, AppUser createdBy){
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
        if (registrationDto.getPhoneNumber() != null) {
        		user.setPhoneIntCallingCode(registrationDto.getPhoneIntCallingCode());
        }
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setMobileIntCallingCode(registrationDto.getMobileIntCallingCode());
        user.setMobileNumber(registrationDto.getMobileNumber());
        user.setRole(Role.CUSTOMER);
        
		if (!StringUtils.isEmpty(registrationDto.getDob())) {
			try {
				user.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(registrationDto.getDob()));
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

        if (createdBy != null) {
        		user.setCreatedBy(createdBy);
        }
        
        RegistrationDetails registrationDetails = new RegistrationDetails();
        registrationDetails.setIdentityNumber(registrationDto.getIdentityNumber());
        registrationDetails.setTopup(registrationDto.getTopup());
        
        if (!StringUtils.isEmpty(registrationDto.getPaymentMode())) {
			registrationDetails.setPaymentMode(PaymentMode.valueOf(registrationDto.getPaymentMode()));
			if (registrationDetails.getPaymentMode().equals(PaymentMode.OTHERS)) {
				registrationDetails.setOtherPayment(registrationDto.getOtherPayment());
			}
			
			registrationDetails.setPaymentDate(new Date());
        }
        this.registrationDetailsRepository.save(registrationDetails);
        user.setRegistrationDetails(registrationDetails);

        AppUser appUser = appUserRepository.save(user);
        
        //Saving packages data
        saveEntryPackages(appUser, registrationDto);
        
        //Saving Single entry pass data
        saveSingleEntryPass(appUser, registrationDto);
        
        //Saving Annual pass data
        saveAnnualPass(appUser, registrationDto);
        
        //Saving Big london admission fee data
        saveBigLondonAdmissionFee(appUser, registrationDto);
        
        appUserRepository.save(user);
        
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
		
		RegistrationDetails details = appUser.getRegistrationDetails();
		if (details != null) {
			details.setTotalPaidForPackages(totalAmountPaid);

			if (details.getTotalPaid() != null) {
				details.setTotalPaid(details.getTotalPaid() + totalAmountPaid);
			} else {
				details.setTotalPaid(totalAmountPaid);
			}
		}
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
						&& registrationDto.getNationality().equals(Constants.MALAYSIAN)) {

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
		
		RegistrationDetails details = appUser.getRegistrationDetails();
		if (details != null) {
			details.setTotalPaidForSingleEntryPass(totalAmountPaid);

			if (details.getTotalPaid() != null) {
				details.setTotalPaid(details.getTotalPaid() + totalAmountPaid);
			} else {
				details.setTotalPaid(totalAmountPaid);
			}
		}
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
				appUserAnnualPass.setSelectedCount(dto.getSelectedCount());
				if (annualPass.getPrice() != null) {
					appUserAnnualPass.setPrice(dto.getSelectedCount() * annualPass.getPrice());
					totalAmountPaid += dto.getSelectedCount() * annualPass.getPrice();
				}

				this.appUserAnnualPassRepository.save(appUserAnnualPass);
			}
		}
		
		RegistrationDetails details = appUser.getRegistrationDetails();
		if (details != null) {
			details.setTotalPaidForAnnualPass(totalAmountPaid);

			if (details.getTotalPaid() != null) {
				details.setTotalPaid(details.getTotalPaid() + totalAmountPaid);
			} else {
				details.setTotalPaid(totalAmountPaid);
			}
		}
	}
	
	private void saveBigLondonAdmissionFee(AppUser appUser, UserRegistrationDto registrationDto) {
		Float totalAmountPaid = 0F;
		for (BigLondonAdmissionFeeDto dto : registrationDto.getBigLondonAdmissionFeeDtos()) {
			if (dto.getId() != null) {
				BigLondonAdmissionFee bigLondonAdmissionFee = this.blAdmissionFeeRepository.findOne(dto.getId());
				
				AppUserBLAdmissionFee appUserBLAdmissionFee = this.appUserBLAdmissionFeeRepository
						.findByAppUserAndBigLondonAdmissionFee(appUser, bigLondonAdmissionFee);
				
				if (appUserBLAdmissionFee == null) {
					appUserBLAdmissionFee = new AppUserBLAdmissionFee();
				}
				
				appUserBLAdmissionFee.setAppUser(appUser);
				appUserBLAdmissionFee.setBigLondonAdmissionFee(bigLondonAdmissionFee);
				
				if (dto.getAdultSelectedCount() != null) {
					appUserBLAdmissionFee.setAdultSelectedCount(dto.getAdultSelectedCount());
					if (!StringUtils.isEmpty(registrationDto.getNationality())
							&& registrationDto.getNationality().equals(Constants.MALAYSIAN)) {
						
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
				}
				if (dto.getKidsOrSrCitizenSelectedCount() != null) {
					appUserBLAdmissionFee.setKidsOrSrCitizenSelectedCount(dto.getKidsOrSrCitizenSelectedCount());
					
					if (!StringUtils.isEmpty(registrationDto.getNationality())
							&& registrationDto.getNationality().equals(Constants.MALAYSIAN)) {
						
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
		
		RegistrationDetails details = appUser.getRegistrationDetails();
		if (details != null) {
			details.setTotalPaidForBigLondonFee(totalAmountPaid);

			if (details.getTotalPaid() != null) {
				details.setTotalPaid(details.getTotalPaid() + totalAmountPaid);
			} else {
				details.setTotalPaid(totalAmountPaid);
			}
		}
	}

	@Override
	public AppUser validateUser(LoginDto loginDto) {
		if (loginDto == null || StringUtils.isEmpty(loginDto.getEmail()) || StringUtils.isEmpty(loginDto.getPassword())) {
			return null;
		}
		
		AppUser appUser = this.appUserRepository.findFirstByEmailAndPasswordAndRoleNot(loginDto.getEmail().trim(),
				loginDto.getPassword().trim(), Role.CUSTOMER);
		if (appUser == null) {
			return null;
		}
		
		return appUser;
	}
	
	@Override
	public AppUser getLoggedInUser(Object appUserId) {
		if (appUserId == null) {
			return null;
		}
		Long appUserIdStr = (Long) appUserId;

		return this.appUserRepository.findOne(appUserIdStr);
	}
	
	@Override
	public List<UserRegistrationDto> getRegisteredUsers() {
		return mapRegisteredUsers(this.appUserRepository.findByRole(Role.CUSTOMER));
	}
	
	@Override
	public List<UserRegistrationDto> mapRegisteredUsers(List<AppUser> appUsers) {
		List<UserRegistrationDto> registrationDtos = new ArrayList<>();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		for (AppUser appUser : appUsers) {
			UserRegistrationDto registrationDto = new UserRegistrationDto();
			
			registrationDto.setId(appUser.getId());
			registrationDto.setFirstName(appUser.getFirstName());
			registrationDto.setLastName(appUser.getLastName());
			registrationDto.setEmail(appUser.getEmail());
			registrationDto.setDisplayName(appUser.getDisplayName());
			registrationDto.setEnableEmailUpdate(appUser.getEnableEmailUpdate());
			registrationDto.setEnableSmsUpdate(appUser.getEnableSmsUpdate());
			registrationDto.setPhoneIntCallingCode(appUser.getPhoneIntCallingCode());
			registrationDto.setPhoneNumber(appUser.getPhoneNumber());
			registrationDto.setMobileIntCallingCode(appUser.getMobileIntCallingCode());
			registrationDto.setMobileNumber(appUser.getMobileNumber());
			if (appUser.getDob() != null) {
				registrationDto.setDob(formatter.format(appUser.getDob()));
			}
			registrationDto.setGender(appUser.getGender() != null ? appUser.getGender().name() : "");
			registrationDto.setAddress(appUser.getAddress());
			registrationDto.setCountryOfResidence(appUser.getCountryOfResidence());
			registrationDto.setNationality(appUser.getNationality());
			
			AppUser createdBy = appUser.getCreatedBy();
			if (createdBy != null) {
				registrationDto.setCreatedById(createdBy.getId());
				registrationDto.setCreatedByName(createdBy.getFirstName());
				registrationDto.setCreatedByEmail(createdBy.getEmail());
			}
			
			RegistrationDetails details = appUser.getRegistrationDetails();
			if (details != null) {
				registrationDto.setIdentityNumber(details.getIdentityNumber());
				registrationDto.setTotalPaidForPackages(details.getTotalPaidForPackages());
				registrationDto.setTotalPaidForSingleEntryPass(details.getTotalPaidForSingleEntryPass());
				registrationDto.setTotalPaidForAnnualPass(details.getTotalPaidForAnnualPass());
				registrationDto.setTotalPaidForBigLondonFee(details.getTotalPaidForBigLondonFee());
				registrationDto.setTotalPaid(details.getTotalPaid());
			}
			
			registrationDto.setEntryPackageDtos(mapEntryPackageDtos(this.appUserEntryPackageRepository.findByAppUser(appUser)));
			registrationDto.setSingleEntryPassDtos(mapSingleEntryPassDtos(this.appUserSingleEntryPassRepository.findByAppUser(appUser)));
			registrationDto.setAnnualPassDtos(mapAnnualPassDtos(this.appUserAnnualPassRepository.findByAppUser(appUser)));
			registrationDto.setBigLondonAdmissionFeeDtos(mapBigLondonAdmissionFeeDtos(this.appUserBLAdmissionFeeRepository.findByAppUser(appUser)));
			
			registrationDtos.add(registrationDto);
		}
		
		return registrationDtos;
	}
	
	private List<EntryPackageDto> mapEntryPackageDtos(List<AppUserEntryPackage>  appUserEntryPackages) {
		List<EntryPackageDto> entryPackageDtos = new ArrayList<>();
		
		for(AppUserEntryPackage appUserEntryPackage : appUserEntryPackages) {
			EntryPackageDto dto = new EntryPackageDto();
			EntryPackage entryPackage = appUserEntryPackage.getEntryPackage();
			
			if (entryPackage != null) {
				dto.setName(entryPackage.getName());
				dto.setDescription(entryPackage.getDescription());
				dto.setSelectedCount(appUserEntryPackage.getSelectedCount());
				dto.setPrice(appUserEntryPackage.getPrice());
				entryPackageDtos.add(dto);
			}
		}
		
		return entryPackageDtos;
	}
	
	private List<SingleEntryPassDto> mapSingleEntryPassDtos(List<AppUserSingleEntryPass> appUserSingleEntryPasses) {
		List<SingleEntryPassDto> singleEntryPassDtos = new ArrayList<>();
		
		for (AppUserSingleEntryPass appUserSingleEntryPass : appUserSingleEntryPasses) {
			SingleEntryPassDto dto = new SingleEntryPassDto();
			SingleEntryPass entryPass = appUserSingleEntryPass.getSingleEntryPass();
			
			if (entryPass != null) {
				dto.setType(entryPass.getType());
				dto.setDescription(entryPass.getDescription());
				if (appUserSingleEntryPass.getAppUser().getNationality().equals(Constants.MALAYSIAN)) {
					dto.setSelectedCount(appUserSingleEntryPass.getMyKidOrMyKadCount());
				} else {
					dto.setSelectedCount(appUserSingleEntryPass.getStandardCount());
				}
				dto.setPrice(appUserSingleEntryPass.getPrice());
				
				singleEntryPassDtos.add(dto);
			}
		}
		
		return singleEntryPassDtos;
	}
	
	private List<AnnualPassDto> mapAnnualPassDtos(List<AppUserAnnualPass> appUserAnnualPasses) {
		List<AnnualPassDto> annualPassDtos = new ArrayList<>();
		
		for (AppUserAnnualPass appUserAnnualPass : appUserAnnualPasses) {
			AnnualPassDto dto = new AnnualPassDto();
			AnnualPass annualPass = appUserAnnualPass.getAnnualPass();
			
			if (annualPass != null) {
				dto.setType(annualPass.getType());
				dto.setDescription(annualPass.getDescription());
				dto.setSelectedCount(appUserAnnualPass.getSelectedCount());
				dto.setPrice(appUserAnnualPass.getPrice());
				
				annualPassDtos.add(dto);
			}
		}
		
		return annualPassDtos;
	}
	
	private List<BigLondonAdmissionFeeDto> mapBigLondonAdmissionFeeDtos(List<AppUserBLAdmissionFee> appUserBigLondonAdmissionFees) {
		List<BigLondonAdmissionFeeDto> bigLondonAdmissionFeeDtos = new ArrayList<>();
		
		for (AppUserBLAdmissionFee appUserBLAdmissionFee : appUserBigLondonAdmissionFees) {
			BigLondonAdmissionFeeDto dto = new BigLondonAdmissionFeeDto();
			BigLondonAdmissionFee bigLondonAdmissionFee = appUserBLAdmissionFee.getBigLondonAdmissionFee();
			
			if (bigLondonAdmissionFee != null) {
				dto.setType(bigLondonAdmissionFee.getType());
				dto.setDescription(bigLondonAdmissionFee.getDescription());
				dto.setAdultSelectedCount(appUserBLAdmissionFee.getAdultSelectedCount());
				dto.setAdultPrice(appUserBLAdmissionFee.getAdultsPrice());
				dto.setKidsOrSrCitizenSelectedCount(appUserBLAdmissionFee.getKidsOrSrCitizenSelectedCount());
				dto.setKidsOrSrCitizenPrice(appUserBLAdmissionFee.getKidsOrSrCitizenPrice());
				
				bigLondonAdmissionFeeDtos.add(dto);
				/*if (appUserBLAdmissionFee.getAppUser().getNationality().equals(Constants.MALAYSIAN)) {
				}*/
			}
		}
		
		return bigLondonAdmissionFeeDtos;
	}
	
	@Override
	public ReportBeanClass generateReportBean(Long appUserId) {
		if (appUserId != null) {
			DateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
			AppUser appUser = this.appUserRepository.findOne(appUserId);
			
			ReportBeanClass reportBeanClass = new ReportBeanClass();
			
			reportBeanClass.setGuestId(appUser.getRegistrationDetails().getIdentityNumber());
			reportBeanClass.setGuestName(appUser.getFirstName());
			reportBeanClass.setEmail(appUser.getEmail());
			reportBeanClass.setMobile("+" + appUser.getMobileIntCallingCode() + " " + appUser.getMobileNumber());
			reportBeanClass.setBookingDate(formatter.format(appUser.createdDate));
			
			RegistrationDetails details = appUser.getRegistrationDetails();
			if (details != null) {
				reportBeanClass.setPaymentDate(formatter.format(details.getPaymentDate()));
				reportBeanClass.setPaymentMethod(details.getPaymentMode().name());
				reportBeanClass.setTotalAmount(BigDecimal.valueOf(details.getTotalPaid()));
			} else {
				reportBeanClass.setPaymentDate("");
				reportBeanClass.setPaymentMethod("");
				reportBeanClass.setTotalAmount(BigDecimal.ZERO);
			}
			
			StringBuilder builder = new StringBuilder();
			List<EntryPackageDto> entryPackageDtos = mapEntryPackageDtos(
					this.appUserEntryPackageRepository.findByAppUser(appUser));
			if (!entryPackageDtos.isEmpty()) {
				builder.append("Packages : \n");
				for (EntryPackageDto dto : entryPackageDtos) {
					builder.append(dto.getName()).append(dto.getDescription() != null ? dto.getDescription() : "")
							.append(", Qty : ").append(dto.getSelectedCount()).append("\n\n");
				}
			}
			
			List<SingleEntryPassDto> singleEntryPassDtos = mapSingleEntryPassDtos(
					this.appUserSingleEntryPassRepository.findByAppUser(appUser));
			if (!singleEntryPassDtos.isEmpty()) {
				builder.append("Single Entry Pass : \n");
				for (SingleEntryPassDto dto : singleEntryPassDtos) {
					builder.append(dto.getType()).append(dto.getDescription() != null ? dto.getDescription() : "")
							.append(", Qty : ").append(dto.getSelectedCount()).append("\n\n");
				}
			}

			List<AnnualPassDto> annualPassDtos = mapAnnualPassDtos(
					this.appUserAnnualPassRepository.findByAppUser(appUser));
			if (!annualPassDtos.isEmpty()) {
				builder.append("Annual Pass : \n");
				for (AnnualPassDto dto : annualPassDtos) {
					builder.append(dto.getType()).append(dto.getDescription() != null ? dto.getDescription() : "")
							.append(", Qty : ").append(dto.getSelectedCount()).append("\n\n");
				}
			}
			
			List<BigLondonAdmissionFeeDto> bigLondonAdmissionFeeDtos = mapBigLondonAdmissionFeeDtos(
					this.appUserBLAdmissionFeeRepository.findByAppUser(appUser));
			if (!bigLondonAdmissionFeeDtos.isEmpty()) {
				builder.append("Big London Admission Fee : \n");
				for (BigLondonAdmissionFeeDto dto : bigLondonAdmissionFeeDtos) {
					builder.append(dto.getType()).append(dto.getDescription() != null ? dto.getDescription() : "");
					if (dto.getAdultSelectedCount() != null) {
						builder.append(", Adults Qty : ").append(dto.getAdultSelectedCount());
					}
					if (dto.getKidsOrSrCitizenSelectedCount() != null) {
						builder.append(", Kids or Sr Citizen Qty : ").append(dto.getKidsOrSrCitizenSelectedCount());
					}
					builder.append("\n\n");
				}
			}
			
			reportBeanClass.setPackageDetails(builder.toString());
			
			return reportBeanClass;
		}
		
		return null;
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
