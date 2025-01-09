package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.BuyGutka;

@Repository
public interface BuyGutkaRepository extends JpaRepository<BuyGutka, Integer> {
    
    @Query(value = "SELECT * FROM Buy_Gutka WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<BuyGutka> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Buy_Gutka WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<BuyGutka> findByMonthAndType(String month, String type);
}
