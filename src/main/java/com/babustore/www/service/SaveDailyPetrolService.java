package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyPetrol;
import com.babustore.www.repository.SaveDailyPetrolRepository;

@Service
public class SaveDailyPetrolService {
    
    @Autowired
    SaveDailyPetrolRepository saveDailyPetrolRepository;

    public void saveSaveDailyPetrol(SaveDailyPetrol saveDailyPetrol) {
        saveDailyPetrolRepository.save(saveDailyPetrol);
    }

    public void deleteSaveDailyPetrol(int id) {
        saveDailyPetrolRepository.deleteById(id);    
    }

    public List<SaveDailyPetrol> getAllDetails() {
        return saveDailyPetrolRepository.findAll();
    }

    public List<SaveDailyPetrol> getDateAndType(String date, String type) {
        return saveDailyPetrolRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyPetrol> getMonthAndType(String month, String type) {
        return saveDailyPetrolRepository.findByMonthAndType(month, type);
    }
}
