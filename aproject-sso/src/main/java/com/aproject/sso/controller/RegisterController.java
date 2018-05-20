package com.aproject.sso.controller;

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
import com.aproject.pojo.TbSeller;
import com.aproject.pojo.TbUser;
import com.aproject.sso.service.RegisterService;
import com.aproject.sso.service.SellerRegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private SellerRegisterService sellerRegisterService;
	
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String param, @PathVariable Integer type, String callback) {
		try {
			TaotaoResult result = registerService.checkData(param, type);
			if (StringUtils.isNotBlank(callback)) {
				//请求为jsonp调用，需要支持
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
	@RequestMapping("/seller/check/{param}/{type}")
	@ResponseBody
	public Object checkSellerData(@PathVariable String param, @PathVariable Integer type, String callback) {
		try {
			TaotaoResult result = sellerRegisterService.checkData(param, type);
			if (StringUtils.isNotBlank(callback)) {
				//请求为jsonp调用，需要支持
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
	
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult register(TbUser user) {
		try {
			TaotaoResult result = registerService.register(user);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@RequestMapping(value="/seller/register", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult sellerRegister(TbSeller seller) {
		try {
			TaotaoResult result = sellerRegisterService.register(seller);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}

