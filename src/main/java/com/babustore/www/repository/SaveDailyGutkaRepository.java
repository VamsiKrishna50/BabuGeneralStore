package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyGutka;

@Repository
public interface SaveDailyGutkaRepository extends JpaRepository<SaveDailyGutka, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_Gutka WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyGutka> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_Gutka WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyGutka> findByMonthAndType(String month, String type);
}
