package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyDairy;
import com.babustore.www.repository.SaveDailyDairyRepository;

@Service
public class SaveDailyDairyService {
    
    @Autowired
    SaveDailyDairyRepository saveDailyDairyRepository;

    public void saveSaveDailyDairy(SaveDailyDairy saveDailyDairy) {
        saveDailyDairyRepository.save(saveDailyDairy);
    }

    public void deleteSaveDailyDairy(int id) {
        saveDailyDairyRepository.deleteById(id);    
    }

    public List<SaveDailyDairy> getAllDetails() {
        return saveDailyDairyRepository.findAll();
    }

    public List<SaveDailyDairy> getDateAndType(String date, String type) {
        return saveDailyDairyRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyDairy> getMonthAndType(String month, String type) {
        return saveDailyDairyRepository.findByMonthAndType(month, type);
    }
}
