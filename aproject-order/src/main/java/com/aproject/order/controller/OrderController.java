package com.aproject.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aproject.common.pojo.ExceptionUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.order.pojo.OrderInfo;
import com.aproject.order.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/create", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody OrderInfo orderInfo) {
		try {
			TaotaoResult result = orderService.createOrder(orderInfo);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value="/order/query/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public TaotaoResult queryOrder(@PathVariable Long userId) {
		TaotaoResult result = orderService.getOrderByUserID(userId);
		return result;
	}
}
