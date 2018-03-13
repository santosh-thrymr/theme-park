package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.AppUser;
import com.themepark.model.AppUserEntryPackage;
import com.themepark.model.EntryPackage;

@Repository
public interface AppUserEntryPackageRepository extends JpaRepository<AppUserEntryPackage, Long> {

	AppUserEntryPackage findByAppUserAndEntryPackage(AppUser appUser, EntryPackage entryPackage);
}
