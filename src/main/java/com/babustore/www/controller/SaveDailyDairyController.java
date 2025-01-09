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

import com.babustore.www.model.SaveDailyDairy;
import com.babustore.www.service.SaveDailyDairyService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyDairy")
public class SaveDailyDairyController {
    
    @Autowired
    public SaveDailyDairyService saveDailyDairyService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveDairy(@RequestBody SaveDailyDairy saveDailyDairy){
        saveDailyDairyService.saveSaveDailyDairy(saveDailyDairy);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyDairyService.deleteSaveDailyDairy(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyDairy>> getAllDetails(){
        List<SaveDailyDairy> details = saveDailyDairyService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyDairy>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyDairy> dateAndType = saveDailyDairyService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyDairy>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyDairy> monthAndType = saveDailyDairyService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
