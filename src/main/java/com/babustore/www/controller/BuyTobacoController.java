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

import com.babustore.www.model.BuyTobaco;
import com.babustore.www.service.BuyTobacoService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/tobaco")
public class BuyTobacoController {
    
    @Autowired
    public BuyTobacoService buyTobacoService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveTobaco(@RequestBody BuyTobaco buyTobaco){
        buyTobacoService.saveBuyTobaco(buyTobaco);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        buyTobacoService.deleteBuyTobacoService(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<BuyTobaco>> getAllDetails(){
        List<BuyTobaco> bt = buyTobacoService.getAllDetails();
        return ResponseEntity.ok(bt);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<BuyTobaco>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<BuyTobaco> dateAndType = buyTobacoService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<BuyTobaco>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<BuyTobaco> monthAndType = buyTobacoService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
