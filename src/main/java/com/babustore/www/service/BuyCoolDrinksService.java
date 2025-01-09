package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyCoolDrinks;
import com.babustore.www.repository.BuyCoolDrinksRepository;
@Service
public class BuyCoolDrinksService {
	
	@Autowired
	BuyCoolDrinksRepository buyCoolDrinksRepository ;

	public void saveBuyCoolDrinks(BuyCoolDrinks buyCoolDrinks) {
		
		buyCoolDrinksRepository.save(buyCoolDrinks);
	}

	public void deleteBuyCoolDrinksService(Long id) {
		
		buyCoolDrinksRepository.deleteById(id);	
	}

	public List<BuyCoolDrinks> getAllDetails() {
		
		return buyCoolDrinksRepository.findAll();
	}

	public List<BuyCoolDrinks> getDateAndType(String date, String type) {
		
		return buyCoolDrinksRepository.findByDateAndType(date, type);
	}
	
	public List<BuyCoolDrinks> getMonthAndType(String month,String type){
		return buyCoolDrinksRepository.findByMonthAndType(month, type);
	}

	
}
