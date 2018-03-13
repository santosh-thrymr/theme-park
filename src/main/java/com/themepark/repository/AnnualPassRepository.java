package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.AnnualPass;

@Repository
public interface AnnualPassRepository extends JpaRepository<AnnualPass, Long> {
}
