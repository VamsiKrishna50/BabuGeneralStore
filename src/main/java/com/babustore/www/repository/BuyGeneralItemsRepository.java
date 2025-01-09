package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.BuyGeneralItems;

@Repository
public interface BuyGeneralItemsRepository extends JpaRepository<BuyGeneralItems, Integer> {
    
    @Query(value = "SELECT * FROM Buy_General_Items WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<BuyGeneralItems> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Buy_General_Items WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<BuyGeneralItems> findByMonthAndType(String month, String type);
}
