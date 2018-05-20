package com.aproject.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aproject.pojo.TbOrderItem;
import com.aproject.pojo.TbUser;
import com.aproject.pojo.TbUserInfo;
import com.aproject.pojo.TbUserShipping;
import com.aproject.portal.pojo.CartItem;
import com.aproject.portal.pojo.OrderInfo;
import com.aproject.portal.service.CartService;
import com.aproject.portal.service.OrderService;
import com.aproject.portal.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/order-cart")
	public String showOrderCart(Model model, HttpServletRequest request) {
		//取购物车商品列表
		List<CartItem> list = cartService.getCartItems(request);
		model.addAttribute("cartList", list);
		TbUser user = (TbUser) request.getAttribute("user");
		Long userId = user.getId();
		TbUserShipping userShipping = userService.getUserShipping(userId);
		model.addAttribute("userShipping",userShipping);
		TbUserInfo userInfo = userService.getUserInfo(userId);
		request.setAttribute("userInfo", userInfo);
		return "order-cart";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createOrder(OrderInfo orderInfo, Model model, HttpServletRequest request) {
		//取用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		//补全orderIn的属性
		orderInfo.setUserId(user.getId());
		//调用服务
		String orderId = orderService.createOrder(orderInfo);
		//把订单号传递个页面
		model.addAttribute("orderId", orderId);
		model.addAttribute("payment", orderInfo.getPayment());
		DateTime dateTime = new DateTime();
		dateTime = dateTime.plusDays(3);
		model.addAttribute("date", dateTime.toString("yyyy-MM-dd"));
		//返回逻辑视图
		return "success";
	}

	@RequestMapping("/list")
	public String queryOrders(Model model, HttpServletRequest request) {
		//取用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		Long userId = user.getId();
		//System.out.println(userId);
		List<OrderInfo> orderInfo = orderService.queryOrder(userId);
//		for(OrderInfo node :orderInfo) {
//			List<TbOrderItem> orderItems = node.getOrderItems();
//			for(TbOrderItem orderItem :orderItems) {
//				System.out.println(orderItem.getTitle());
//			}
//		}
		model.addAttribute("orderInfos",orderInfo);
		return "my-orders";
	}
	
}
