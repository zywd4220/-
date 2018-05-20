package com.aproject.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.pojo.TbUser;
import com.aproject.pojo.TbUserInfo;
import com.aproject.pojo.TbUserShipping;
import com.aproject.portal.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/user/my-info")
	public String myInfo(Model model,HttpServletRequest request) {	
		TbUser user = (TbUser) request.getAttribute("user");
		Long userId = user.getId();
		TbUserInfo userInfo = userService.getUserInfo(userId);
		request.setAttribute("userInfo", userInfo);
		TbUserShipping userShipping = userService.getUserShipping(userId);
		request.setAttribute("userShipping", userShipping);
		return "my-info";
	}
	
	@RequestMapping(value="/user/update")
	public String update(TbUserInfo userinfo,  TbUserShipping userShipping,Model model ,HttpServletRequest request) {
		TbUser users = (TbUser) request.getAttribute("user");
		
		userinfo.setUserId(users.getId());
		userShipping.setUserid(users.getId());
		userService.updateMessage(userinfo, userShipping);
		return  "redirect:/user/my-info.html";
	}
	
	@RequestMapping(value="/users/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		userService.logout(request, response);
		return "index";
	}
}
