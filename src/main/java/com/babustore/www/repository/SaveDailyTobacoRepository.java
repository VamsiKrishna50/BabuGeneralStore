package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyTobaco;

@Repository
public interface SaveDailyTobacoRepository extends JpaRepository<SaveDailyTobaco, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_Tobaco WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyTobaco> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_Tobaco WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyTobaco> findByMonthAndType(String month, String type);
}
