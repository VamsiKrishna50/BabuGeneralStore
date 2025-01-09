package com.babustore.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.babustore.www.model.SaveDailyVegetables;
import com.babustore.www.service.SaveDailyVegetablesService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyVegetables")
public class SaveDailyVegetablesController {
    
    @Autowired
    public SaveDailyVegetablesService saveDailyVegetablesService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveVegetables(@RequestBody SaveDailyVegetables saveDailyVegetables){
        saveDailyVegetablesService.saveSaveDailyVegetables(saveDailyVegetables);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyVegetablesService.deleteSaveDailyVegetables(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyVegetables>> getAllDetails(){
        List<SaveDailyVegetables> details = saveDailyVegetablesService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyVegetables>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyVegetables> dateAndType = saveDailyVegetablesService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyVegetables>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyVegetables> monthAndType = saveDailyVegetablesService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
