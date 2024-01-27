package com.mhn.order.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mhn.order.dto.FoodItemDTO;
import com.mhn.order.dto.Restaurant;
import com.mhn.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

	private int orderId;
	private List<FoodItemDTO> foodItemList;
	private Restaurant restaurant;
	private UserDTO userdto;
}
