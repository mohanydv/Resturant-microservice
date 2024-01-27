package com.mhn.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor	
@AllArgsConstructor

public class FoodItemDTO {
	private int id;
	private String itemName;
	private String itemDescription;
	private Boolean isVeg;
	private Number price;
	private Integer resturantId;
	private Integer quantity;

}
