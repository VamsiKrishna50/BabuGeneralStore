package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyPetrol;
import com.babustore.www.repository.BuyPetrolRepository;

@Service
public class BuyPetrolService {
    
    @Autowired
    BuyPetrolRepository buyPetrolRepository;

    public void saveBuyPetrol(BuyPetrol buyPetrol) {
        buyPetrolRepository.save(buyPetrol);
    }

    public void deleteBuyPetrolService(int id) {
        buyPetrolRepository.deleteById(id);    
    }

    public List<BuyPetrol> getAllDetails() {
        return buyPetrolRepository.findAll();
    }

    public List<BuyPetrol> getDateAndType(String date, String type) {
        return buyPetrolRepository.findByDateAndType(date, type);
    }
    
    public List<BuyPetrol> getMonthAndType(String month, String type) {
        return buyPetrolRepository.findByMonthAndType(month, type);
    }
}
