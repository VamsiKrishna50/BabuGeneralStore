package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyDairy;

@Repository
public interface SaveDailyDairyRepository extends JpaRepository<SaveDailyDairy, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_Dairy WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyDairy> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_Dairy WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyDairy> findByMonthAndType(String month, String type);
}
