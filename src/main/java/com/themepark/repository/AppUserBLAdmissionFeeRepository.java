package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.AppUser;
import com.themepark.model.AppUserBLAdmissionFee;
import com.themepark.model.BigLondonAdmissionFee;

@Repository
public interface AppUserBLAdmissionFeeRepository extends JpaRepository<AppUserBLAdmissionFee, Long> {

	AppUserBLAdmissionFee findByAppUserAndBigLondonAdmissionFee(AppUser appUser,
			BigLondonAdmissionFee bigLondonAdmissionFee);
}
