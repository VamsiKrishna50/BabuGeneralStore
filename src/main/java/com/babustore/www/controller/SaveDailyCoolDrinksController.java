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

import com.babustore.www.model.SaveDailyCoolDrinks;
import com.babustore.www.service.SaveDailyCoolDrinksService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyCooldrinks")
public class SaveDailyCoolDrinksController {
    
    @Autowired
    public SaveDailyCoolDrinksService saveDailyCoolDrinksService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveCoolDrinks(@RequestBody SaveDailyCoolDrinks saveDailyCoolDrinks){
        saveDailyCoolDrinksService.saveSaveDailyCoolDrinks(saveDailyCoolDrinks);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyCoolDrinksService.deleteSaveDailyCoolDrinks(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyCoolDrinks>> getAllDetails(){
        List<SaveDailyCoolDrinks> details = saveDailyCoolDrinksService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyCoolDrinks>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyCoolDrinks> dateAndType = saveDailyCoolDrinksService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyCoolDrinks>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyCoolDrinks> monthAndType = saveDailyCoolDrinksService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
