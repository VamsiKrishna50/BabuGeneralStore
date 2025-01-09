package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyDairy;
import com.babustore.www.repository.BuyDairyRepository;

@Service
public class BuyDairyService {
    
    @Autowired
    BuyDairyRepository buyDairyRepository;

    public void saveBuyDairy(BuyDairy buyDairy) {
        buyDairyRepository.save(buyDairy);
    }

    public void deleteBuyDairyService(int id) {
        buyDairyRepository.deleteById(id);    
    }

    public List<BuyDairy> getAllDetails() {
        return buyDairyRepository.findAll();
    }

    public List<BuyDairy> getDateAndType(String date, String type) {
        return buyDairyRepository.findByDateAndType(date, type);
    }
    
    public List<BuyDairy> getMonthAndType(String month, String type) {
        return buyDairyRepository.findByMonthAndType(month, type);
    }
}
