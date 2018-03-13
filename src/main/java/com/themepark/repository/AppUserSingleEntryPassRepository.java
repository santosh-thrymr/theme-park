package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.AppUser;
import com.themepark.model.AppUserSingleEntryPass;
import com.themepark.model.SingleEntryPass;

@Repository
public interface AppUserSingleEntryPassRepository extends JpaRepository<AppUserSingleEntryPass, Long> {

	AppUserSingleEntryPass findByAppUserAndSingleEntryPass(AppUser appUser, SingleEntryPass singleEntryPass);
}
