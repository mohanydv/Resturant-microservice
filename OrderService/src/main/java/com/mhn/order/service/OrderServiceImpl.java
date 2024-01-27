package com.mhn.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mhn.order.dto.OrderRequestDTO;
import com.mhn.order.dto.OrderResponseDTO;
import com.mhn.order.dto.UserDTO;
import com.mhn.order.entity.Order;
import com.mhn.order.mapper.OrderMapper;
import com.mhn.order.repository.OrderRpository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRpository orderRpository;
	@Autowired
	private SequenceGenerator sequenceGenerator;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OrderResponseDTO saveOrderinDB(OrderRequestDTO orderDetails) {
		
		Integer nextOrderId = sequenceGenerator.generateNextOrderId();

		UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
		Order orderTOBeSaved = new Order(nextOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(),
				userDTO);
		orderRpository.save(orderTOBeSaved);
		return OrderMapper.INSTANCE.mapOrderToOrderResponseDTO(orderTOBeSaved);
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
	}

}
