package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveDailyGeneralItems;
import com.babustore.www.repository.SaveDailyGeneralItemsRepository;

@Service
public class SaveDailyGeneralItemsService {
    
    @Autowired
    SaveDailyGeneralItemsRepository saveDailyGeneralItemsRepository;

    public void saveSaveDailyGeneralItems(SaveDailyGeneralItems saveDailyGeneralItems) {
        saveDailyGeneralItemsRepository.save(saveDailyGeneralItems);
    }

    public void deleteSaveDailyGeneralItems(int id) {
        saveDailyGeneralItemsRepository.deleteById(id);    
    }

    public List<SaveDailyGeneralItems> getAllDetails() {
        return saveDailyGeneralItemsRepository.findAll();
    }

    public List<SaveDailyGeneralItems> getDateAndType(String date, String type) {
        return saveDailyGeneralItemsRepository.findByDateAndType(date, type);
    }
    
    public List<SaveDailyGeneralItems> getMonthAndType(String month, String type) {
        return saveDailyGeneralItemsRepository.findByMonthAndType(month, type);
    }
}
