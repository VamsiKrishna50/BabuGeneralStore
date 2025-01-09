package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.BuyPetrol;

@Repository
public interface BuyPetrolRepository extends JpaRepository<BuyPetrol, Integer> {
    
    @Query(value = "SELECT * FROM Buy_Petrol WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<BuyPetrol> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Buy_Petrol WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<BuyPetrol> findByMonthAndType(String month, String type);
}
