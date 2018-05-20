package com.aproject.portal.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.HttpClientUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.common.utils.CookieUtils;
import com.aproject.mapper.TbItemMapper;
import com.aproject.mapper.TbUserInfoMapper;
import com.aproject.mapper.TbUserMapper;
import com.aproject.mapper.TbUserShippingMapper;
import com.aproject.pojo.TbUser;
import com.aproject.pojo.TbUserInfo;
import com.aproject.pojo.TbUserInfoExample;
import com.aproject.pojo.TbUserShipping;
import com.aproject.pojo.TbUserShippingExample;
import com.aproject.pojo.TbUserShippingExample.Criteria;
import com.aproject.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Value("${SSO_BASE_URL}")
	private String SSO_BASE_URL;
	@Value("${SSO_USER_TOKEN_SERVICE}")
	private String SSO_USER_TOKEN_SERVICE;
	
	@Autowired
	TbUserInfoMapper userInfoMapper;
	
	@Autowired
	TbUserShippingMapper userShippingMapper;

	@Override
	public TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			//从cookie中取token
			String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
			//判断token是否有值
			if (StringUtils.isBlank(token)) {
				return null;
			}
			//调用sso的服务查询用户信息
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN_SERVICE + token);
			//把json转换成java对象
			TaotaoResult result = TaotaoResult.format(json);
			if (result.getStatus() != 200) {
				return null;
			}
			//取用户对象
			result = TaotaoResult.formatToPojo(json, TbUser.class);
			TbUser user = (TbUser) result.getData();
			
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TaotaoResult logout(HttpServletRequest request, HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		HttpClientUtil.doGet(SSO_BASE_URL + "/user/logout/" + token);
		return TaotaoResult.ok();
	}
	
	@Override  
	public TaotaoResult updateMessage(TbUserInfo userinfo,TbUserShipping userShipping) {
		
		Long userId = userinfo.getUserId();
		TbUserInfoExample infoExample = new TbUserInfoExample();
		com.aproject.pojo.TbUserInfoExample.Criteria infoCriteria = infoExample.createCriteria();
		infoCriteria.andUserIdEqualTo(userId);
		List<TbUserInfo> userInfo = userInfoMapper.selectByExample(infoExample);
		TbUserInfo tbUserInfo = userInfo.get(0);
		userinfo.setId(tbUserInfo.getId());
		userInfoMapper.updateByExample(userinfo, infoExample);
		
		TbUserShippingExample example = new TbUserShippingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<TbUserShipping> shipping = userShippingMapper.selectByExample(example);
		TbUserShipping ship = shipping.get(0);
		userShipping.setId(ship.getId());
		userShippingMapper.updateByExample(userShipping, example);
		
		return TaotaoResult.ok();
	}
	
	@Override
	public TbUserInfo getUserInfo(Long userId) {
		TbUserInfoExample infoExample = new TbUserInfoExample();
		com.aproject.pojo.TbUserInfoExample.Criteria infoCriteria = infoExample.createCriteria();
		infoCriteria.andUserIdEqualTo(userId);
		List<TbUserInfo> userInfo = userInfoMapper.selectByExample(infoExample);
		TbUserInfo tbUserInfo = userInfo.get(0);
		return tbUserInfo;
	}
	
	@Override
	public  TbUserShipping getUserShipping(Long userId) {
		TbUserShippingExample example = new TbUserShippingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<TbUserShipping> shipping = userShippingMapper.selectByExample(example);
		TbUserShipping ship = shipping.get(0);
		return ship;
	}
}
