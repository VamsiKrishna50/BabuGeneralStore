package com.babustore.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.babustore.www.model.BuyCoolDrinks;
import com.babustore.www.service.BuyCoolDrinksService;

@SuppressWarnings("unused")
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("api/coolDrinks")
public class BuyCoolDrinksController {
	
	@Autowired
	public BuyCoolDrinksService buyCoolDrinksService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveDrinks(@RequestBody BuyCoolDrinks buyCoolDrinks){
		buyCoolDrinksService.saveBuyCoolDrinks(buyCoolDrinks);
		return ResponseEntity.ok("Saved");	
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyCoolDrinks(@PathVariable Long id) {
        buyCoolDrinksService. deleteBuyCoolDrinksService(id);
        return ResponseEntity.noContent().build(); 
    }
	@GetMapping("/getAllDetails")
	public ResponseEntity<List<BuyCoolDrinks>> getAllDetails(){
		List<BuyCoolDrinks> bcd=buyCoolDrinksService.getAllDetails();
		 return ResponseEntity.ok(bcd);
	}
	
	@GetMapping("/getDateAndType")
	public ResponseEntity<List<BuyCoolDrinks>> getDateAndType(@RequestParam String date,@RequestParam String type){
		List<BuyCoolDrinks> dateAndType=buyCoolDrinksService.getDateAndType(date,type);
		return ResponseEntity.ok(dateAndType);
	}
	@GetMapping("/getMonthAndType")
	public ResponseEntity<List<BuyCoolDrinks>> getMonthAndType(@RequestParam String month,@RequestParam String type){
		List<BuyCoolDrinks> monthAndType=buyCoolDrinksService.getMonthAndType(month,type);
		return ResponseEntity.ok(monthAndType);
	}
	
	
}
