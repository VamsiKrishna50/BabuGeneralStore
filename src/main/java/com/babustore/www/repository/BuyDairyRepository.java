package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.BuyDairy;

@Repository
public interface BuyDairyRepository extends JpaRepository<BuyDairy, Integer> {
    
    @Query(value = "SELECT * FROM Buy_Dairy WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<BuyDairy> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Buy_Dairy WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<BuyDairy> findByMonthAndType(String month, String type);
}
