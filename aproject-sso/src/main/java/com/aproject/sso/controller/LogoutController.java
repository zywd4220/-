package com.aproject.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.sso.service.LogoutService;

@Controller
public class LogoutController {

	@Autowired
	LogoutService logoutService;
	
	@RequestMapping(value="/user/logout/{token}")
	public TaotaoResult logout(@PathVariable String token, 
			HttpServletRequest request, HttpServletResponse response) {
		logoutService.logout(request, response, token);
		return TaotaoResult.ok();
	}
	
}
