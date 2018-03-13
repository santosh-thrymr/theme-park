package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.SingleEntryPass;

@Repository
public interface SingleEntryPassRepository extends JpaRepository<SingleEntryPass, Long> {
}
