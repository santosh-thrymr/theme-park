package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.BigLondonAdmissionFee;

@Repository
public interface BLAdmissionFeeRepository extends JpaRepository<BigLondonAdmissionFee, Long> {
}
