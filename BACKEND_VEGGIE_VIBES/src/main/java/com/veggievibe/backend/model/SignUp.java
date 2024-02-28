package com.veggievibe.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class SignUp {
    @Id
    private String username;
    private String email;
    private String password;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "signUp")
    private UserDetails userDetails;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "signUp")
    private List<CustomerOrder> customerOrder;
    
}