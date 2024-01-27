package com.mhn.resturant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhn.resturant.dto.RestaurantDTO;
import com.mhn.resturant.service.ResturantService;


@RestController
@RequestMapping("/resturant")
@CrossOrigin("*")
public class ResturantController {
	@Autowired
	ResturantService resturantService;

	@GetMapping("/fetchAllResturant")
	ResponseEntity<List<RestaurantDTO>> fetchAllResturant() {
		List<RestaurantDTO> allRestaurants = resturantService.findAllResturant();

		return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
	}

	
	@PostMapping("/addResturant")
	ResponseEntity<RestaurantDTO> saveRestorant(@RequestBody RestaurantDTO dto){
	  RestaurantDTO dto2  =	resturantService.addResturantInDB(dto);
		return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<RestaurantDTO> findResturantById(@PathVariable Integer id)
	{
		return resturantService.fetchResturantById(id);
		
	}
	
}
