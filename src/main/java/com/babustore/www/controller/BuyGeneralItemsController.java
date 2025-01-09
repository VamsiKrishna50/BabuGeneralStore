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

import com.babustore.www.model.BuyGeneralItems;
import com.babustore.www.service.BuyGeneralItemsService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/generalItems")
public class BuyGeneralItemsController {
    
    @Autowired
    public BuyGeneralItemsService buyGeneralItemsService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveGeneralItems(@RequestBody BuyGeneralItems buyGeneralItems){
        buyGeneralItemsService.saveBuyGeneralItems(buyGeneralItems);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        buyGeneralItemsService.deleteBuyGeneralItemsService(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<BuyGeneralItems>> getAllDetails(){
        List<BuyGeneralItems> bgi = buyGeneralItemsService.getAllDetails();
        return ResponseEntity.ok(bgi);
    }
    
    @GetMapping("/getDateAndType/{date}/{type}")
    public ResponseEntity<List<BuyGeneralItems>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<BuyGeneralItems> dateAndType = buyGeneralItemsService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<BuyGeneralItems>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<BuyGeneralItems> monthAndType = buyGeneralItemsService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
