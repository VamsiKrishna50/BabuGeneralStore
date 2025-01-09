package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveDailyCoolDrinks;

@Repository
public interface SaveDailyCoolDrinksRepository extends JpaRepository<SaveDailyCoolDrinks, Integer> {
    
    @Query(value = "SELECT * FROM Save_Daily_Cool_Drinks WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyCoolDrinks> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Save_Daily_Cool_Drinks WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<SaveDailyCoolDrinks> findByMonthAndType(String month, String type);
}
