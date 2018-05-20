package com.aproject.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aproject.common.pojo.TaotaoResult;

public interface LogoutService {

	TaotaoResult logout(HttpServletRequest request,
			HttpServletResponse response,String token);
}
