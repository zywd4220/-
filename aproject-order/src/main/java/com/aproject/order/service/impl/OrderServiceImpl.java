package com.aproject.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.mapper.TbItemMapper;
import com.aproject.mapper.TbOrderItemMapper;
import com.aproject.mapper.TbOrderMapper;
import com.aproject.mapper.TbOrderShippingMapper;
import com.aproject.order.component.JedisClient;
import com.aproject.order.pojo.OrderInfo;
import com.aproject.order.service.OrderService;
import com.aproject.pojo.TbItem;
import com.aproject.pojo.TbItemExample;
import com.aproject.pojo.TbOrder;
import com.aproject.pojo.TbOrderExample;
import com.aproject.pojo.TbOrderExample.Criteria;
import com.aproject.pojo.TbOrderItem;
import com.aproject.pojo.TbOrderItemExample;
import com.aproject.pojo.TbOrderShipping;
import com.aproject.pojo.TbOrderShippingExample;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_ORDER_GEN_KEY}")
	private String REDIS_ORDER_GEN_KEY;
	@Value("${ORDER_ID_BEGIN}")
	private String ORDER_ID_BEGIN;
	@Value("${REDIS_ORDER_DETAIL_GEN_KEY}")
	private String REDIS_ORDER_DETAIL_GEN_KEY;
	
	@Override
	public TaotaoResult createOrder(OrderInfo orderInfo) {
		// 一、插入订单表
		// 1、接收数据OrderInfo
		// 2、生成订单号
		//取订单号
		String id = jedisClient.get(REDIS_ORDER_GEN_KEY);
		if (StringUtils.isBlank(id)) {
			//如果订单号生成key不存在设置初始值
			jedisClient.set(REDIS_ORDER_GEN_KEY, ORDER_ID_BEGIN);
		}
		Long orderId = jedisClient.incr(REDIS_ORDER_GEN_KEY);
		// 3、补全字段
		orderInfo.setOrderId(orderId.toString());
		//状态：1、等待送货，2、已送达
		orderInfo.setStatus(1);
		Date date = new Date();
		orderInfo.setCreateTime(date);
		orderInfo.setUpdateTime(date);
		// 4、插入订单表
		orderMapper.insert(orderInfo);
		// 二、插入订单明细
		// 2、补全字段
		List<TbOrderItem> orderItems = orderInfo.getOrderItems();
		for (TbOrderItem orderItem : orderItems) {
			Long itemId = orderItem.getItemId();
			TbItemExample itemExample = new TbItemExample();
			com.aproject.pojo.TbItemExample.Criteria criteria = itemExample.createCriteria();
			criteria.andIdEqualTo(itemId);
			List<TbItem> items = itemMapper.selectByExample(itemExample);
			TbItem tbItem = items.get(0);
			String sellerName = tbItem.getSellerName();
			// 1、生成订单明细id，使用redis的incr命令生成。
			Long detailId = jedisClient.incr(REDIS_ORDER_DETAIL_GEN_KEY);
			orderItem.setSellerName(sellerName);
			orderItem.setId(detailId.toString());
			//订单号
			orderItem.setOrderId(orderId.toString());
			// 3、插入数据
			orderItemMapper.insert(orderItem);
		}
		// 三、插入物流表
		TbOrderShipping orderShipping = orderInfo.getOrderShipping();
		// 1、补全字段
		orderShipping.setOrderId(orderId.toString());
		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		// 2、插入数据
		orderShippingMapper.insert(orderShipping);
		// 返回TaotaoResult包装订单号。
		return TaotaoResult.ok(orderId);
	}

	public TaotaoResult getOrderByUserID(Long userId) {
		
		List<OrderInfo> orderInfoList = new ArrayList<>();		
		TbOrderExample orderExample =new TbOrderExample();
		Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andUserIdEqualTo(userId);
		List<TbOrder> orders = orderMapper.selectByExample(orderExample);
		//List<TbOrderItem> orderItemList = new ArrayList<>();
		for(TbOrder order :orders) {
			String orderId = order.getOrderId();
			String buyerNick = order.getBuyerNick();
			Date createTime = order.getCreateTime();
			Date updateTime = order.getUpdateTime();
			Integer status = order.getStatus();
			String payment = order.getPayment();
			Integer paymentType = order.getPaymentType();
			OrderInfo orderInfoNode =new OrderInfo();
			orderInfoNode.setOrderId(orderId);
			orderInfoNode.setUserId(userId);
			orderInfoNode.setBuyerNick(buyerNick);
			orderInfoNode.setStatus(status);
			orderInfoNode.setCreateTime(createTime);
			orderInfoNode.setUpdateTime(updateTime);
			orderInfoNode.setPayment(payment);
			orderInfoNode.setPaymentType(paymentType);

			
			TbOrderItemExample orderItemExample = new TbOrderItemExample();
			com.aproject.pojo.TbOrderItemExample.Criteria orderItemCriteria = orderItemExample.createCriteria();
			orderItemCriteria.andOrderIdEqualTo(orderId);
			List<TbOrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
			orderInfoNode.setOrderItems(orderItems);
			
			TbOrderShippingExample orderShippingExample = new TbOrderShippingExample();
			com.aproject.pojo.TbOrderShippingExample.Criteria orderShippingCriteria = orderShippingExample.createCriteria();
			orderShippingCriteria.andOrderIdEqualTo(orderId);
			List<TbOrderShipping> orderShippings = orderShippingMapper.selectByExample(orderShippingExample);
			TbOrderShipping orderShipping = orderShippings.get(0);
			System.out.println(orderShipping);
			orderInfoNode.setOrderShipping(orderShipping);
			
			orderInfoList.add(orderInfoNode);
		}
		return  TaotaoResult.ok(orderInfoList);
	}
}
