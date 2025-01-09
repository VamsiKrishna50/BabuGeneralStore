package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyCoolDrinks;
import com.babustore.www.repository.SaveDailyCoolDrinksRepository;

@Service
public class SaveDailyCoolDrinksService {
    
    @Autowired
    SaveDailyCoolDrinksRepository saveDailyCoolDrinksRepository;

    public void saveSaveDailyCoolDrinks(SaveDailyCoolDrinks saveDailyCoolDrinks) {
        saveDailyCoolDrinksRepository.save(saveDailyCoolDrinks);
    }

    public void deleteSaveDailyCoolDrinks(int id) {
        saveDailyCoolDrinksRepository.deleteById(id);    
    }

    public List<SaveDailyCoolDrinks> getAllDetails() {
        return saveDailyCoolDrinksRepository.findAll();
    }

    public List<SaveDailyCoolDrinks> getDateAndType(String date, String type) {
        return saveDailyCoolDrinksRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyCoolDrinks> getMonthAndType(String month, String type) {
        return saveDailyCoolDrinksRepository.findByMonthAndType(month, type);
    }
}
