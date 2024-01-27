package com.mhn.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

	private List<FoodItemDTO> foodItemList;
	private Restaurant restaurant;
	private Integer userId;
}
