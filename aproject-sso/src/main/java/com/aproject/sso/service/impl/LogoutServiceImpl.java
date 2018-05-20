package com.aproject.sso.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.common.utils.CookieUtils;
import com.aproject.common.utils.JsonUtils;
import com.aproject.sso.component.JedisClient;
import com.aproject.sso.service.LogoutService;
@Service
public class LogoutServiceImpl implements LogoutService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	
	@Override
	public TaotaoResult logout(HttpServletRequest request,
			HttpServletResponse response,String token) {
		jedisClient.del(REDIS_SESSION_KEY + ":" + token);
		CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		return TaotaoResult.ok();
	}
}
