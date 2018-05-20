package com.aproject.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.pojo.TbUser;
import com.aproject.pojo.TbUserInfo;
import com.aproject.pojo.TbUserShipping;

public interface UserService {

	TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);

	TaotaoResult updateMessage(TbUserInfo userinfo, TbUserShipping userShipping);

	TbUserInfo getUserInfo(Long userId);

	TbUserShipping getUserShipping(Long userId);
	
	TaotaoResult logout(HttpServletRequest request, HttpServletResponse response);
}
