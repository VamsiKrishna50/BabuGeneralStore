package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.BuyTobaco;

@Repository
public interface BuyTobacoRepository extends JpaRepository<BuyTobaco, Integer> {
    
    @Query(value = "SELECT * FROM Buy_Tobaco WHERE date = ?1 AND type = ?2", nativeQuery = true)
    List<BuyTobaco> findByDateAndType(String date, String type);
    
    @Query(value = "SELECT * FROM Buy_Tobaco WHERE month = ?1 AND type = ?2", nativeQuery = true)
    List<BuyTobaco> findByMonthAndType(String month, String type);
}
