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

import com.babustore.www.model.SaveDailyGutka;
import com.babustore.www.service.SaveDailyGutkaService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyGutka")
public class SaveDailyGutkaController {
    
    @Autowired
    public SaveDailyGutkaService saveDailyGutkaService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveGutka(@RequestBody SaveDailyGutka saveDailyGutka){
        saveDailyGutkaService.saveSaveDailyGutka(saveDailyGutka);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyGutkaService.deleteSaveDailyGutka(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyGutka>> getAllDetails(){
        List<SaveDailyGutka> details = saveDailyGutkaService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyGutka>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyGutka> dateAndType = saveDailyGutkaService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyGutka>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyGutka> monthAndType = saveDailyGutkaService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
