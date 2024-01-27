package com.mhn.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhn.food.entity.FoodItem;
@Repository
public interface FoodRepostitory extends JpaRepository<FoodItem, Integer> {

	List<FoodItem> findByResturantId(Integer resturantid);

}
