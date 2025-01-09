package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.BuyVegetables;

@Repository
public interface BuyVegetablesRepository extends JpaRepository<BuyVegetables, Integer> {
    
    @Query(value = "SELECT * FROM Buy_Vegetables WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<BuyVegetables> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Buy_Vegetables WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<BuyVegetables> findByMonthAndType(String month, String type);
}
