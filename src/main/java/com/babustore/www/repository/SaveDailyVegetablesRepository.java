package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyVegetables;

@Repository
public interface SaveDailyVegetablesRepository extends JpaRepository<SaveDailyVegetables, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_Vegetables WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyVegetables> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_Vegetables WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyVegetables> findByMonthAndType(String month, String type);
}
