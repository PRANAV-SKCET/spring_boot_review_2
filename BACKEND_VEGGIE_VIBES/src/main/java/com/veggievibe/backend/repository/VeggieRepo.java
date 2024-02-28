package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.veggievibe.backend.model.VegetableDetails;


@Repository
public interface VeggieRepo extends JpaRepository<VegetableDetails, Integer>{

    @Query("SELECT v FROM VegetableDetails v WHERE v.name LIKE %?1%")
    public List<VegetableDetails> findByName(String name);

    @Query("SELECT v FROM VegetableDetails v ORDER BY v.price ASC")
    public List<VegetableDetails> sortByPriceAsc();

    @Query("SELECT v FROM VegetableDetails v ORDER BY v.price DESC")
    public List<VegetableDetails> sortByPriceDesc();
    
    @Query("SELECT v FROM VegetableDetails v ORDER BY v.name ASC")
    public List<VegetableDetails> sortByNameAsc();

    @Query("SELECT v FROM VegetableDetails v ORDER BY v.name DESC")
    public List<VegetableDetails> sortByNameDesc();
}
