package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyVegetables;
import com.babustore.www.repository.BuyVegetablesRepository;

@Service
public class BuyVegetablesService {
    
    @Autowired
    BuyVegetablesRepository buyVegetablesRepository;

    public void saveBuyVegetables(BuyVegetables buyVegetables) {
        buyVegetablesRepository.save(buyVegetables);
    }

    public void deleteBuyVegetables(int id) {
        buyVegetablesRepository.deleteById(id);    
    }

    public List<BuyVegetables> getAllDetails() {
        return buyVegetablesRepository.findAll();
    }

    public List<BuyVegetables> getDateAndType(String date, String type) {
        return buyVegetablesRepository.findByDateAndType(date, type);
    }
    
    public List<BuyVegetables> getMonthAndType(String month, String type) {
        return buyVegetablesRepository.findByMonthAndType(month, type);
    }
}
