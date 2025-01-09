package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyPetrol;

@Repository
public interface SaveDailyPetrolRepository extends JpaRepository<SaveDailyPetrol, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_Petrol WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyPetrol> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_Petrol WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyPetrol> findByMonthAndType(String month, String type);
}
