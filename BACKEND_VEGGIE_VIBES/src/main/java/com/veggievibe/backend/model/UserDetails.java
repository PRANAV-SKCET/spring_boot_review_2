package com.veggievibe.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserDetails {
    @Id
    private int id;
    private String name;
    private String doorno;
    private String street;
    private String city;
    private String landmark;
    private String address1;
    private String address2;
    private String mobilenumber;
    private String pincode;

    @JsonBackReference
    @OneToOne
    private SignUp signUp;
    
}
