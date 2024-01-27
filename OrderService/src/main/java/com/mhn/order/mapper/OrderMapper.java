package com.mhn.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mhn.order.dto.OrderResponseDTO;
import com.mhn.order.entity.Order;

@Mapper
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	OrderResponseDTO mapOrderToOrderResponseDTO(Order order);

	Order mapOrderResponseDTOtoOrder(OrderResponseDTO dto);

}
