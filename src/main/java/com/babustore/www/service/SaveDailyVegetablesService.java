package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyVegetables;
import com.babustore.www.repository.SaveDailyVegetablesRepository;

@Service
public class SaveDailyVegetablesService {
    
    @Autowired
    SaveDailyVegetablesRepository saveDailyVegetablesRepository;

    public void saveSaveDailyVegetables(SaveDailyVegetables saveDailyVegetables) {
        saveDailyVegetablesRepository.save(saveDailyVegetables);
    }

    public void deleteSaveDailyVegetables(int id) {
        saveDailyVegetablesRepository.deleteById(id);    
    }

    public List<SaveDailyVegetables> getAllDetails() {
        return saveDailyVegetablesRepository.findAll();
    }

    public List<SaveDailyVegetables> getDateAndType(String date, String type) {
        return saveDailyVegetablesRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyVegetables> getMonthAndType(String month, String type) {
        return saveDailyVegetablesRepository.findByMonthAndType(month, type);
    }
}
