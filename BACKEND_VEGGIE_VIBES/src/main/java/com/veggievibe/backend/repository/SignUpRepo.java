package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veggievibe.backend.model.SignUp;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp,String>{
    
}
