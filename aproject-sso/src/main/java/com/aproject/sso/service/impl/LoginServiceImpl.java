package com.aproject.sso.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.common.utils.CookieUtils;
import com.aproject.common.utils.JsonUtils;
import com.aproject.mapper.TbUserMapper;
import com.aproject.pojo.TbUser;
import com.aproject.pojo.TbUserExample;
import com.aproject.pojo.TbUserExample.Criteria;
import com.aproject.sso.component.JedisClient;
import com.aproject.sso.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public TaotaoResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		//校验用户名密码是否正确
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = userMapper.selectByExample(example);
		//取用户信息
		if (list == null || list.isEmpty()) {
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		TbUser user = list.get(0);
		//校验密码
		if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		//登录成功
		//生成token
		String token = UUID.randomUUID().toString();
		//把用户信息写入redis
		//key:REDIS_SESSION:{TOKEN} 
		//value:user转json
		user.setPassword(null);
		jedisClient.set(REDIS_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//设置session的过期时间
		jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
		//写cookie
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		
		return TaotaoResult.ok(token);
	}


	
	@Override
	public TaotaoResult getUserByToken(String token) {
		// 根据token取用户信息
		String json = jedisClient.get(REDIS_SESSION_KEY + ":" + token);
		//判断是否查询到结果
		if (StringUtils.isBlank(json)) {
			return TaotaoResult.build(400, "用户session已经过期");
		}
		//把json转换成java对象
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		//更新session的过期时间
		jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
		
		return TaotaoResult.ok(user);
	}

}

