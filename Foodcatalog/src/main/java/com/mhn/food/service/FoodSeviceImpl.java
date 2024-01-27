package com.mhn.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mhn.food.dto.FoodCatelogPage;
import com.mhn.food.dto.FoodItemDTO;
import com.mhn.food.dto.Resturant;
import com.mhn.food.entity.FoodItem;
import com.mhn.food.mapper.FoodItemMapper;
import com.mhn.food.repository.FoodRepostitory;

@Service
public class FoodSeviceImpl implements FoodService {
	@Autowired
	FoodRepostitory foodRepostitory;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public FoodItemDTO addFoodItem(FoodItemDTO dto) {
		FoodItem save = foodRepostitory.save(FoodItemMapper.INSTANCE.foodItemDTOtoFooditem(dto));
		return FoodItemMapper.INSTANCE.foodItemTOFoodItemDTO(save);
	}

	@Override
	public FoodCatelogPage fetchFoodCatalogPageDetais(Integer resturantid) {
//food Item List
		List<FoodItem> fetchedFoodItem = fetchFoodItemList(resturantid);
		// resturantDetails
		Resturant resturant = fetchresturantDtails(resturantid);
		return createCatelogPage(fetchedFoodItem, resturant);
	}

	private FoodCatelogPage createCatelogPage(List<FoodItem> fetchedFoodItem, Resturant resturant) {
		FoodCatelogPage catelogPage = new FoodCatelogPage();
		catelogPage.setFoodItemList(fetchedFoodItem);
		catelogPage.setResturant(resturant);
		return catelogPage;
	}

	private Resturant fetchresturantDtails(Integer resturantid) {
		return restTemplate.getForObject("http://RESTURANT-SERVICE/resturant/fetchById/"+resturantid,
				Resturant.class);

	}

	private List<FoodItem> fetchFoodItemList(Integer resturantid) {
		return foodRepostitory.findByResturantId(resturantid);
	}

}
