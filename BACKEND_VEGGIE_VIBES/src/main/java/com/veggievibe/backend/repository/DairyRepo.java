package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veggievibe.backend.model.DairyDetails;
import java.util.List;


public interface DairyRepo extends JpaRepository<DairyDetails, Integer>{
    
    @Query("SELECT d FROM DairyDetails d WHERE d.name LIKE %?1%")
    public List<DairyDetails> findByName(String name);

    @Query("SELECT d FROM DairyDetails d ORDER BY d.price ASC")
    public List<DairyDetails> sortByPriceAsc();

    @Query("SELECT d FROM DairyDetails d ORDER BY d.price DESC")
    public List<DairyDetails> sortByPriceDesc();

    @Query("SELECT d FROM DairyDetails d ORDER BY d.name ASC")
    public List<DairyDetails> sortByNameAsc();

    @Query("SELECT d FROM DairyDetails d ORDER BY d.name DESC")
    public List<DairyDetails> sortByNameDesc();

    
}
