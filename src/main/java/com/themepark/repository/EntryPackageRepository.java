package com.themepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.model.EntryPackage;

@Repository
public interface EntryPackageRepository extends JpaRepository<EntryPackage, Long> {
}
