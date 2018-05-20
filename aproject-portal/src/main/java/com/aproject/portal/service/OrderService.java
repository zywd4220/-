package com.aproject.portal.service;

import java.util.List;

import com.aproject.portal.pojo.OrderInfo;

public interface OrderService {

	String createOrder(OrderInfo orderInfo);
	List<OrderInfo> queryOrder(Long userId);
}
