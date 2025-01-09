package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyTobaco;
import com.babustore.www.repository.SaveDailyTobacoRepository;

@Service
public class SaveDailyTobacoService {
    
    @Autowired
    SaveDailyTobacoRepository saveDailyTobacoRepository;

    public void saveSaveDailyTobaco(SaveDailyTobaco saveDailyTobaco) {
        saveDailyTobacoRepository.save(saveDailyTobaco);
    }

    public void deleteSaveDailyTobaco(int id) {
        saveDailyTobacoRepository.deleteById(id);    
    }

    public List<SaveDailyTobaco> getAllDetails() {
        return saveDailyTobacoRepository.findAll();
    }

    public List<SaveDailyTobaco> getDateAndType(String date, String type) {
        return saveDailyTobacoRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyTobaco> getMonthAndType(String month, String type) {
        return saveDailyTobacoRepository.findByMonthAndType(month, type);
    }
}
