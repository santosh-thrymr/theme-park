package com.themepark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.AnnualPass;
import com.themepark.model.AppUser;
import com.themepark.model.AppUserAnnualPass;

@Repository
public interface AppUserAnnualPassRepository extends JpaRepository<AppUserAnnualPass, Long> {

	AppUserAnnualPass findByAppUserAndAnnualPass(AppUser appUser, AnnualPass annualPass);
	
	List<AppUserAnnualPass> findByAppUser(AppUser appUser);
}
