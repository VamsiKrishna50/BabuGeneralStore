package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyTobaco;
import com.babustore.www.repository.BuyTobacoRepository;

@Service
public class BuyTobacoService {
    
    @Autowired
    BuyTobacoRepository buyTobacoRepository;

    public void saveBuyTobaco(BuyTobaco buyTobaco) {
        buyTobacoRepository.save(buyTobaco);
    }

    public void deleteBuyTobacoService(int id) {
        buyTobacoRepository.deleteById(id);    
    }

    public List<BuyTobaco> getAllDetails() {
        return buyTobacoRepository.findAll();
    }

    public List<BuyTobaco> getDateAndType(String date, String type) {
        return buyTobacoRepository.findByDateAndType(date, type);
    }
    
    public List<BuyTobaco> getMonthAndType(String month, String type) {
        return buyTobacoRepository.findByMonthAndType(month, type);
    }
}
