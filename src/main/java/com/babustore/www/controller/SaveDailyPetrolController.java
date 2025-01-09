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

import com.babustore.www.model.SaveDailyPetrol;
import com.babustore.www.service.SaveDailyPetrolService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyPetrol")
public class SaveDailyPetrolController {
    
    @Autowired
    public SaveDailyPetrolService saveDailyPetrolService;
    
    @PostMapping("/save")
    public ResponseEntity<String> savePetrol(@RequestBody SaveDailyPetrol saveDailyPetrol){
        saveDailyPetrolService.saveSaveDailyPetrol(saveDailyPetrol);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyPetrolService.deleteSaveDailyPetrol(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyPetrol>> getAllDetails(){
        List<SaveDailyPetrol> details = saveDailyPetrolService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyPetrol>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyPetrol> dateAndType = saveDailyPetrolService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyPetrol>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyPetrol> monthAndType = saveDailyPetrolService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
