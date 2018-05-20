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
import com.aproject.mapper.TbSellerMapper;
import com.aproject.pojo.TbSeller;
import com.aproject.pojo.TbSellerExample;
import com.aproject.pojo.TbSellerExample.Criteria;
import com.aproject.sso.component.JedisClient;
import com.aproject.sso.service.SellerLoginService;

@Service
public class SellerLoginServiceImpl implements SellerLoginService {

	@Autowired
	private TbSellerMapper sellerMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public TaotaoResult sellerlogin(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		//校验用户名密码是否正确
		TbSellerExample example = new TbSellerExample();
		Criteria criteria = example.createCriteria();
		criteria.andSellernameEqualTo(username);
		List<TbSeller> list = sellerMapper.selectByExample(example);
		//取用户信息
		if (list == null || list.isEmpty()) {
			return TaotaoResult.build(400, "商家不存在");
		}
		TbSeller seller = list.get(0);
		//校验密码
		if(!seller.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			return TaotaoResult.build(400, "密码错误");
		}
		//登录成功
		//生成token
		String token = UUID.randomUUID().toString();
		//把用户信息写入redis
		//key:REDIS_SESSION:{TOKEN}
		//value:user转json
		seller.setPassword(null);
		jedisClient.set(REDIS_SESSION_KEY + ":" + token, JsonUtils.objectToJson(seller));
		//设置session的过期时间
		jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
		//写cookie
		CookieUtils.setCookie(request, response, "TT_SELLER_TOKEN", token);
		
		return TaotaoResult.ok(token);
	}


	@Override
	public TaotaoResult getSellerByToken(String token) {
		// 根据token取用户信息
		String json = jedisClient.get(REDIS_SESSION_KEY + ":" + token);
		//判断是否查询到结果
		if (StringUtils.isBlank(json)) {
			return TaotaoResult.build(400, "用户session已经过期");
		}
		//把json转换成java对象
		TbSeller seller = JsonUtils.jsonToPojo(json, TbSeller.class);
		//更新session的过期时间
		jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
		
		return TaotaoResult.ok(seller);
	}

}
