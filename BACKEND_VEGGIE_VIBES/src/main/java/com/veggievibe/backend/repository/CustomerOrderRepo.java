package com.veggievibe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.veggievibe.backend.model.CustomerOrder;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Integer> {


    @Modifying
    @Transactional
    @Query(value = "update customer_order set status=?3 where sign_up_username=?1 and order_id=?2", nativeQuery = true)
    public int updateStatus(String userName, int orderId, String status);

}
