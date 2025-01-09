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

import com.babustore.www.model.SaveKatha;
import com.babustore.www.service.SaveKathaService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/katha")
public class SaveKathaController {
	@Autowired
	public SaveKathaService saveKathaService;
	
	@PostMapping("/save")
    public ResponseEntity<SaveKatha> saveKatha(@RequestBody SaveKatha saveKatha) {
        SaveKatha savedKatha = saveKathaService.saveKatha(saveKatha);
        return ResponseEntity.ok(savedKatha);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteKathaById(@PathVariable Long id) {
        saveKathaService.deleteKathaById(id);
        return ResponseEntity.ok("Katha with ID " + id + " has been deleted.");
    }
    @GetMapping("/viewAllData")
    public  ResponseEntity<List<SaveKatha>> findAllData(){
    	List<SaveKatha> sk=saveKathaService.findAllSaveKatha();
    	return ResponseEntity.ok(sk);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SaveKatha>> findByNameOrTypeOrDate(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String month) {
        List<SaveKatha> kathaList = saveKathaService.findByNameOrTypeOrDate(name, type, date, month);
        return ResponseEntity.ok(kathaList);
    }
    @GetMapping("/ViewSevenDaysData")
    public ResponseEntity<List<SaveKatha>> findWeekData(
    		@RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate){
				 List<SaveKatha> sv=saveKathaService.findWeekData(startDate,endDate);
				 return ResponseEntity.ok(sv);
    	
    }
    
}
