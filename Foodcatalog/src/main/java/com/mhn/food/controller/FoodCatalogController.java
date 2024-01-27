package com.mhn.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhn.food.dto.FoodCatelogPage;
import com.mhn.food.dto.FoodItemDTO;
import com.mhn.food.service.FoodService;

@RestController
@RequestMapping("/foodcatalog")
public class FoodCatalogController {
	@Autowired
	FoodService foodService;

	@PostMapping("/addFoodItem")
	ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO dto) {
		FoodItemDTO food = foodService.addFoodItem(dto);
		return new ResponseEntity<FoodItemDTO>(food, HttpStatus.CREATED);
	}

	@GetMapping("/fetchfoodById/{id}")
	ResponseEntity<FoodCatelogPage> fetchResturantwithfoodMenu(@PathVariable int id) {
		FoodCatelogPage catelogPage = foodService.fetchFoodCatalogPageDetais(id);

		return new ResponseEntity<>(catelogPage, HttpStatus.OK);

	}

}
