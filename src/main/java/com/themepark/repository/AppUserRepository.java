package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
    
    AppUser findFirstByEmailAndPassword(String email, String password);
}
