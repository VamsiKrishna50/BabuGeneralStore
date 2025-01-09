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

import com.babustore.www.model.BuyVegetables;
import com.babustore.www.service.BuyVegetablesService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/vegetables")
public class BuyVegetablesController {
    
    @Autowired
    public BuyVegetablesService buyVegetablesService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveVegetables(@RequestBody BuyVegetables buyVegetables){
        buyVegetablesService.saveBuyVegetables(buyVegetables);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        buyVegetablesService.deleteBuyVegetables(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<BuyVegetables>> getAllDetails(){
        List<BuyVegetables> bv = buyVegetablesService.getAllDetails();
        return ResponseEntity.ok(bv);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<BuyVegetables>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<BuyVegetables> dateAndType = buyVegetablesService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<BuyVegetables>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<BuyVegetables> monthAndType = buyVegetablesService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
