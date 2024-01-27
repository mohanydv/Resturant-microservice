package com.mhn.food.service;

import com.mhn.food.dto.FoodCatelogPage;
import com.mhn.food.dto.FoodItemDTO;

public interface FoodService {

	FoodItemDTO addFoodItem(FoodItemDTO dto);

	FoodCatelogPage fetchFoodCatalogPageDetais(Integer resturantid);

}
