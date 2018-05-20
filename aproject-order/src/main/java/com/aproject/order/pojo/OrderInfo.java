package com.aproject.order.pojo;

import java.util.List;

import com.aproject.pojo.TbOrder;
import com.aproject.pojo.TbOrderItem;
import com.aproject.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder{

	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
}
