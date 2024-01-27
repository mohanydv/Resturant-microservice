package com.mhn.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mhn.order.entity.Order;
@Repository
public interface OrderRpository extends MongoRepository<Order, Integer> {

}
