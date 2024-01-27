package com.mhn.resturant.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mhn.resturant.dto.RestaurantDTO;
import com.mhn.resturant.entity.Restaurant;

@Mapper
public interface ResturantMapper {

	ResturantMapper INSTANCE = Mappers.getMapper(ResturantMapper.class);

	Restaurant mapRestauratDTOToResturant(RestaurantDTO restaurantDTO);

	RestaurantDTO mapRestauratToResturantDTO(Restaurant restaurant);

}
