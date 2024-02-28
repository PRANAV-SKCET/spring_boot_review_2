package com.veggievibe.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerOrder {
    @Id
    private int orderId;
    private String orderDate;
    private String orders;
    private int amount;
    private String status;

    @JsonBackReference
    @ManyToOne
    private SignUp signUp;
    
}
