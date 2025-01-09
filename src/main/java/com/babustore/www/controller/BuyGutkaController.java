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

import com.babustore.www.model.BuyGutka;
import com.babustore.www.service.BuyGutkaService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/gutka")
public class BuyGutkaController {
    
    @Autowired
    public BuyGutkaService buyGutkaService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveGutka(@RequestBody BuyGutka buyGutka){
        buyGutkaService.saveBuyGutka(buyGutka);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        buyGutkaService.deleteBuyGutkaService(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<BuyGutka>> getAllDetails(){
        List<BuyGutka> bg = buyGutkaService.getAllDetails();
        return ResponseEntity.ok(bg);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<BuyGutka>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<BuyGutka> dateAndType = buyGutkaService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<BuyGutka>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<BuyGutka> monthAndType = buyGutkaService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
