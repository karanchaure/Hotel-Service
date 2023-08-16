package com.lcwd.user.service.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.userservice.enities.User;



public interface UserRepository extends JpaRepository<User,String>{
    
}
