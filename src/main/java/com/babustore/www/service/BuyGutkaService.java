package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyGutka;
import com.babustore.www.repository.BuyGutkaRepository;

@Service
public class BuyGutkaService {
    
    @Autowired
    BuyGutkaRepository buyGutkaRepository;

    public void saveBuyGutka(BuyGutka buyGutka) {
        buyGutkaRepository.save(buyGutka);
    }

    public void deleteBuyGutkaService(int id) {
        buyGutkaRepository.deleteById(id);    
    }

    public List<BuyGutka> getAllDetails() {
        return buyGutkaRepository.findAll();
    }

    public List<BuyGutka> getDateAndType(String date, String type) {
        return buyGutkaRepository.findByDateAndType(date, type);
    }
    
    public List<BuyGutka> getMonthAndType(String month, String type) {
        return buyGutkaRepository.findByMonthAndType(month, type);
    }
}
