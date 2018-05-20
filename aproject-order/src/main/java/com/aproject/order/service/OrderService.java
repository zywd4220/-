package com.aproject.order.service;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.order.pojo.OrderInfo;

public interface OrderService {

	TaotaoResult createOrder(OrderInfo orderInfo);
	TaotaoResult getOrderByUserID(Long userId);
}
