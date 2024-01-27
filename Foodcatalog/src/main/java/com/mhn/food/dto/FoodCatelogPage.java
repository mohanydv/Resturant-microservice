package com.mhn.food.dto;

import java.util.List;

import com.mhn.food.entity.FoodItem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FoodCatelogPage {

	private List<FoodItem> foodItemList;
	private  Resturant resturant;

}
