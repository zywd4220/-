package com.aproject.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aproject.common.pojo.ExceptionUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.sso.service.LoginService;
import com.aproject.sso.service.SellerLoginService;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private SellerLoginService sellerloginService;
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult login(String username, String password, 
			HttpServletRequest request, HttpServletResponse response) {
		try {
			TaotaoResult result = loginService.login(username, password, request, response);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping(value="/seller/login", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult sellerlogin(String username, String password, 
			HttpServletRequest request, HttpServletResponse response) {
		try {
			TaotaoResult result = sellerloginService.sellerlogin(username, password, request, response);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	@RequestMapping("/user/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		try {
			TaotaoResult result = loginService.getUserByToken(token);
			//支持jsonp调用
			if (StringUtils.isNotBlank(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@RequestMapping("/seller/token/{token}")
	@ResponseBody
	public Object getSellerByToken(@PathVariable String token, String callback) {
		try {
			TaotaoResult result = sellerloginService.getSellerByToken(token);
			//支持jsonp调用
			if (StringUtils.isNotBlank(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
