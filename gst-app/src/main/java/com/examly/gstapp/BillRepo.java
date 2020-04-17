package com.examly.gstapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepo extends JpaRepository<Bill,Integer> {
    @Query("SELECT SUM(netprice) FROM Bill")
    public double getTotalAmount();
    
    @Query("SELECT COUNT(id) FROM Bill")
    public int getRows();
}
