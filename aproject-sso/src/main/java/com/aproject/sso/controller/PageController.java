package com.aproject.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 展示登录页面
	 */
	@RequestMapping("/page/login")
	public String showLogin(String redirectURL,Model model) {
		//需要把参数传递给jsp
		model.addAttribute("redirect",redirectURL);
		return "login";
	}
	
	@RequestMapping("/page/sellerlogin")
	public String showSellerLogin(String redirectURL,Model model) {
		//需要把参数传递给jsp
		model.addAttribute("redirect",redirectURL);
		return "sellerlogin";
	}
	
	
	/**
	 * 展示注册页面
	 */
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/page/sellerregister")
	public String showSellerRegister() {
		return "sellerregister";
	}
}
