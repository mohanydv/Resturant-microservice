package com.mhn.food.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mhn.food.dto.FoodItemDTO;
import com.mhn.food.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

	FoodItem foodItemDTOtoFooditem(FoodItemDTO dto);

	FoodItemDTO foodItemTOFoodItemDTO(FoodItem foodItem);

}
