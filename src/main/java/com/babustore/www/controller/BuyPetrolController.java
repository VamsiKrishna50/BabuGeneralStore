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

import com.babustore.www.model.BuyPetrol;
import com.babustore.www.service.BuyPetrolService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/petrol")
public class BuyPetrolController {
    
    @Autowired
    public BuyPetrolService buyPetrolService;
    
    @PostMapping("/save")
    public ResponseEntity<String> savePetrol(@RequestBody BuyPetrol buyPetrol){
        buyPetrolService.saveBuyPetrol(buyPetrol);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        buyPetrolService.deleteBuyPetrolService(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<BuyPetrol>> getAllDetails(){
        List<BuyPetrol> bp = buyPetrolService.getAllDetails();
        return ResponseEntity.ok(bp);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<BuyPetrol>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<BuyPetrol> dateAndType = buyPetrolService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<BuyPetrol>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<BuyPetrol> monthAndType = buyPetrolService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
