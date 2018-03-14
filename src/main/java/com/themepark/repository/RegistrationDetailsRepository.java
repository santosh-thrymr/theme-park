package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.RegistrationDetails;

@Repository
public interface RegistrationDetailsRepository extends JpaRepository<RegistrationDetails, Long> {
}
