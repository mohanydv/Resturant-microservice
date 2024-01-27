package com.mhn.resturant.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mhn.resturant.dto.RestaurantDTO;

public interface ResturantService {

List<RestaurantDTO> findAllResturant();

RestaurantDTO addResturantInDB(RestaurantDTO dto);

ResponseEntity<RestaurantDTO> fetchResturantById(Integer id);

}
