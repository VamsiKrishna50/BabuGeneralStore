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

import com.babustore.www.model.SaveDailyTobaco;
import com.babustore.www.service.SaveDailyTobacoService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyTobaco")
public class SaveDailyTobacoController {
    
    @Autowired
    public SaveDailyTobacoService saveDailyTobacoService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveTobaco(@RequestBody SaveDailyTobaco saveDailyTobaco){
        saveDailyTobacoService.saveSaveDailyTobaco(saveDailyTobaco);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyTobacoService.deleteSaveDailyTobaco(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyTobaco>> getAllDetails(){
        List<SaveDailyTobaco> details = saveDailyTobacoService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyTobaco>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyTobaco> dateAndType = saveDailyTobacoService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyTobaco>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyTobaco> monthAndType = saveDailyTobacoService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
