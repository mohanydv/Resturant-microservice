package com.mhn.resturant.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mhn.resturant.dto.RestaurantDTO;
import com.mhn.resturant.entity.Restaurant;
import com.mhn.resturant.mapper.ResturantMapper;
import com.mhn.resturant.repository.ResturantRepository;

@Service
public class ResturanServiceImpl implements ResturantService {
	@Autowired
	ResturantRepository repository;

	@Override
	public List<RestaurantDTO> findAllResturant() {

		List<Restaurant> restaurantsList = repository.findAll();

		List<RestaurantDTO> restaurantsDTOList = restaurantsList.stream()
				.map(Resturant -> ResturantMapper.INSTANCE.mapRestauratToResturantDTO(Resturant))
				.collect(Collectors.toList());
		return restaurantsDTOList;
	}

	@Override
	public RestaurantDTO addResturantInDB(RestaurantDTO dto) {

		Restaurant restaurant = repository.save(ResturantMapper.INSTANCE.mapRestauratDTOToResturant(dto));
		
		return ResturantMapper.INSTANCE.mapRestauratToResturantDTO(restaurant);
	}

	@Override
	public ResponseEntity<RestaurantDTO> fetchResturantById(Integer id) {

		Optional<Restaurant> returant = repository.findById(id);
		if(returant.isPresent()) 
		return   new ResponseEntity<RestaurantDTO> (ResturantMapper.INSTANCE.mapRestauratToResturantDTO(returant.get()),HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
