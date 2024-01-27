package com.mhn.order.service;

import com.mhn.order.dto.OrderRequestDTO;
import com.mhn.order.dto.OrderResponseDTO;

public interface OrderService {

	OrderResponseDTO saveOrderinDB(OrderRequestDTO orderDetails);

}
