package com.mhn.resturant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhn.resturant.entity.Restaurant;

@Repository
public interface ResturantRepository extends JpaRepository<Restaurant, Integer> {

}
