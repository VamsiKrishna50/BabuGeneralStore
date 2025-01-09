package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyGeneralItems;

@Repository
public interface SaveDailyGeneralItemsRepository extends JpaRepository<SaveDailyGeneralItems, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_General_Items WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyGeneralItems> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_General_Items WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyGeneralItems> findByMonthAndType(String month, String type);
}
