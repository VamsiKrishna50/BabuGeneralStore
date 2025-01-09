package com.babustore.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babustore.www.model.SaveKatha;
import com.babustore.www.repository.SaveKathaRepository;

@Service
public class SaveKathaService {
	@Autowired
	public SaveKathaRepository savekathaRepository;
	
	
    public SaveKatha saveKatha(SaveKatha saveKatha) {
        return savekathaRepository.save(saveKatha);
    }

    
    public void deleteKathaById(Long id) {
    	savekathaRepository.deleteById(id);
    }

    
    public List<SaveKatha> findByNameOrTypeOrDate(String name, String type, String date ,String month) {
        return savekathaRepository.findByNameOrTypeOrDate(name, type, date,month);
    }
    
    public List<SaveKatha> findAllSaveKatha(){
    	return savekathaRepository.findAll();
    }
    
    public List<SaveKatha> findWeekData(String startDate,String endDate){
		return savekathaRepository.findLastSevenDaysData(startDate,endDate);
    	
    }
}
