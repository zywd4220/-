package com.aproject.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.HttpClientUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.common.utils.JsonUtils;
import com.aproject.portal.pojo.OrderInfo;
import com.aproject.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;

	@Override
	public String createOrder(OrderInfo orderInfo) {
		//把OrderInfo转换成json
		String json = JsonUtils.objectToJson(orderInfo);
		//提交订单数据
		String jsonResult = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, json);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.format(jsonResult);
		//取订单号
		String orderId = taotaoResult.getData().toString();
		return orderId;
	}

	public  List<OrderInfo> queryOrder(Long userId){
		
		String json = HttpClientUtil.doGet(ORDER_BASE_URL+"/order/query/"+userId);
		TaotaoResult orderInfo = TaotaoResult.formatToList(json, OrderInfo.class);
		List<OrderInfo> data =(List<OrderInfo>) orderInfo.getData();
		//System.out.println(data);
		//List<OrderInfo> orderInfoList = JsonUtils.jsonToList(json, OrderInfo.class);
		return data;
	}
	
}
	