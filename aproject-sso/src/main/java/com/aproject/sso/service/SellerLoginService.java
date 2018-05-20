package com.aproject.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aproject.common.pojo.TaotaoResult;

public interface SellerLoginService {

	public TaotaoResult sellerlogin(String username, String password, HttpServletRequest request,
			HttpServletResponse response);
	public TaotaoResult getSellerByToken(String token);
}
