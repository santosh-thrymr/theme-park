package com.themepark.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.themepark.enums.Role;
import com.themepark.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);
    
    AppUser findFirstByEmailAndPassword(String email, String password);
    
    AppUser findFirstByEmailAndPasswordAndRoleIn(String email, String password, List<Role> roles);
    
    AppUser findFirstByEmailAndPasswordAndRoleNot(String email, String password, Role role);
    
    @Transactional
    List<AppUser> findByRole(Role role);
}
