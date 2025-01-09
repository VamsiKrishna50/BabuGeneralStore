package com.babustore.www.controller;

import java.util.List;
import java.util.Optional;

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

import com.babustore.www.model.BuyDairy;
import com.babustore.www.service.BuyDairyService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dairy")
public class BuyDairyController {
    
    @Autowired
    public BuyDairyService buyDairyService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveDairy(@RequestBody BuyDairy buyDairy){
        buyDairyService.saveBuyDairy(buyDairy);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        buyDairyService.deleteBuyDairyService(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<BuyDairy>> getAllDetails(){
        List<BuyDairy> bd = buyDairyService.getAllDetails();
        return ResponseEntity.ok(bd);
    }
    
    @GetMapping("/getDateAndType/{date}/{type}")
    public ResponseEntity<List<BuyDairy>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<BuyDairy> dateAndType = buyDairyService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<BuyDairy>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<BuyDairy> monthAndType = buyDairyService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
    
}
