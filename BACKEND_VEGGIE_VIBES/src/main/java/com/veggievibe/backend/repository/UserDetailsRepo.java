package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veggievibe.backend.model.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer>{
    
}
