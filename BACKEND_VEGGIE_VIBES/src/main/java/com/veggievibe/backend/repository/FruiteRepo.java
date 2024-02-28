package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.veggievibe.backend.model.FruitDetails;
import java.util.List;


@Repository
public interface FruiteRepo extends JpaRepository<FruitDetails, Integer>{
    
    @Query("SELECT f FROM FruitDetails f WHERE f.name LIKE %?1%")
    public List<FruitDetails> findByName(String name);

    @Query("SELECT f FROM FruitDetails f ORDER BY f.price ASC")
    public List<FruitDetails> sortByPriceAsc();

    @Query("SELECT f FROM FruitDetails f ORDER BY f.price DESC")
    public List<FruitDetails> sortByPriceDesc();

    @Query("SELECT f FROM FruitDetails f ORDER BY f.name ASC")
    public List<FruitDetails> sortByNameAsc();

    @Query("SELECT f FROM FruitDetails f ORDER BY f.name DESC")
    public List<FruitDetails> sortByNameDesc();
}
