package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.BuyGeneralItems;
import com.babustore.www.repository.BuyGeneralItemsRepository;

@Service
public class BuyGeneralItemsService {
    
    @Autowired
    BuyGeneralItemsRepository buyGeneralItemsRepository;

    public void saveBuyGeneralItems(BuyGeneralItems buyGeneralItems) {
        buyGeneralItemsRepository.save(buyGeneralItems);
    }

    public void deleteBuyGeneralItemsService(int id) {
        buyGeneralItemsRepository.deleteById(id);    
    }

    public List<BuyGeneralItems> getAllDetails() {
        return buyGeneralItemsRepository.findAll();
    }

    public List<BuyGeneralItems> getDateAndType(String date, String type) {
        return buyGeneralItemsRepository.findByDateAndType(date, type);
    }
    
    public List<BuyGeneralItems> getMonthAndType(String month, String type) {
        return buyGeneralItemsRepository.findByMonthAndType(month, type);
    }
}
