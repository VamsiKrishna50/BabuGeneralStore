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

import com.babustore.www.model.SaveDailyGeneralItems;
import com.babustore.www.service.SaveDailyGeneralItemsService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/dailyGeneralItems")
public class SaveDailyGeneralItemsController {
    
    @Autowired
    public SaveDailyGeneralItemsService saveDailyGeneralItemsService;
    
    @PostMapping("/save")
    public ResponseEntity<String> saveGeneralItems(@RequestBody SaveDailyGeneralItems saveDailyGeneralItems){
        saveDailyGeneralItemsService.saveSaveDailyGeneralItems(saveDailyGeneralItems);
        return ResponseEntity.ok("Saved");    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        saveDailyGeneralItemsService.deleteSaveDailyGeneralItems(id);
        return ResponseEntity.noContent().build(); 
    }
    
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<SaveDailyGeneralItems>> getAllDetails(){
        List<SaveDailyGeneralItems> details = saveDailyGeneralItemsService.getAllDetails();
        return ResponseEntity.ok(details);
    }
    
    @GetMapping("/getDateAndType")
    public ResponseEntity<List<SaveDailyGeneralItems>> getDateAndType(@RequestParam String date, @RequestParam String type){
        List<SaveDailyGeneralItems> dateAndType = saveDailyGeneralItemsService.getDateAndType(date, type);
        return ResponseEntity.ok(dateAndType);
    }
    
    @GetMapping("/getMonthAndType")
    public ResponseEntity<List<SaveDailyGeneralItems>> getMonthAndType(@RequestParam String month, @RequestParam String type){
        List<SaveDailyGeneralItems> monthAndType = saveDailyGeneralItemsService.getMonthAndType(month, type);
        return ResponseEntity.ok(monthAndType);
    }
}
