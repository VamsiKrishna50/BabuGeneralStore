package com.babustore.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.SaveKatha;

@Repository
public interface SaveKathaRepository extends JpaRepository<SaveKatha, Long> {
	@Query(value = """
		    SELECT * 
		    FROM save_katha 
		    WHERE (:name IS NULL OR name LIKE CONCAT('%', :name, '%')) 
		      AND (:type IS NULL OR type = :type) 
		      AND (:date IS NULL OR date = :date) 
		      AND (:month IS NULL OR month = :month)
		""", nativeQuery = true)
		List<SaveKatha> findByNameOrTypeOrDate(
		    String name, 
		    String type, 
		    String date, 
		    String month
		);

	@Query(value="select * from save_katha where date >=?1 and date <=?2",nativeQuery=true)
	List<SaveKatha> findLastSevenDaysData (String startDate,String endDate);
	
}
