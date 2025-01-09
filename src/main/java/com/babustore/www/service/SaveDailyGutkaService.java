package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyGutka;
import com.babustore.www.repository.SaveDailyGutkaRepository;

@Service
public class SaveDailyGutkaService {
    
    @Autowired
    SaveDailyGutkaRepository saveDailyGutkaRepository;

    public void saveSaveDailyGutka(SaveDailyGutka saveDailyGutka) {
        saveDailyGutkaRepository.save(saveDailyGutka);
    }

    public void deleteSaveDailyGutka(int id) {
        saveDailyGutkaRepository.deleteById(id);    
    }

    public List<SaveDailyGutka> getAllDetails() {
        return saveDailyGutkaRepository.findAll();
    }

    public List<SaveDailyGutka> getDateAndType(String date, String type) {
        return saveDailyGutkaRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyGutka> getMonthAndType(String month, String type) {
        return saveDailyGutkaRepository.findByMonthAndType(month, type);
    }
}
