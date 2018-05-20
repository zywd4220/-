package com.aproject.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.mapper.TbUserInfoMapper;
import com.aproject.mapper.TbUserMapper;
import com.aproject.mapper.TbUserShippingMapper;
import com.aproject.pojo.TbUser;
import com.aproject.pojo.TbUserExample;
import com.aproject.pojo.TbUserExample.Criteria;
import com.aproject.pojo.TbUserInfo;
import com.aproject.pojo.TbUserShipping;
import com.aproject.sso.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private TbUserMapper userMapper;
	
	@Autowired
	private TbUserInfoMapper userInfoMapper;
	
	@Autowired
	private TbUserShippingMapper userShippingMapper;

	@Override
	public TaotaoResult checkData(String param, int type) {
		//根据数据类型检查数据
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		//1、2、3分别代表username、phone、email
		if (1 == type) {
			criteria.andUsernameEqualTo(param);
		} else if ( 2 == type) {
			criteria.andPhoneEqualTo(param);
		} 
		//执行查询
		List<TbUser> list = userMapper.selectByExample(example);
		//判断查询结果是否为空
		if (list == null || list.isEmpty()) {
			return TaotaoResult.ok(true);
		}
		return TaotaoResult.ok(false);
	}

	/**
	 * 用户注册
	 * <p>Title: register</p>
	 * <p>Description: </p>
	 * @param user
	 * @return
	 * @see com.aproject.sso.service.RegisterService#register(com.aproject.pojo.TbUser)
	 */
	@Override
	public TaotaoResult register(TbUser user) {
		// 校验数据
		//校验用户名、密码不能为空
		if (StringUtils.isBlank(user.getUsername())
				|| StringUtils.isBlank(user.getPassword())) {
			return TaotaoResult.build(400, "用户名或密码不能为空");
		}
		//校验数据是否重复
		//校验用户名
		TaotaoResult result = checkData(user.getUsername(), 1);
		if (!(boolean) result.getData()) {
			return TaotaoResult.build(400, "用户名重复");
		}
		//校验手机号
		if (user.getPhone() != null) {
			result = checkData(user.getPhone(), 2);
			if (!(boolean) result.getData()) {
				return TaotaoResult.build(400, "手机号重复");
			}
		}
		//校验手机号		
		//插入数据
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//密码进行MD5加密
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userMapper.insert(user);
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<TbUser> returnUser = userMapper.selectByExample(example);
		TbUser tbUser = returnUser.get(0);
		System.out.println(tbUser.getId());
		TbUserInfo tbUserInfo =new TbUserInfo();
		tbUserInfo.setUserId(tbUser.getId());
		userInfoMapper.insert(tbUserInfo);
		TbUserShipping tbUserShipping = new TbUserShipping();
		tbUserShipping.setUserid(tbUser.getId());
		userShippingMapper.insert(tbUserShipping);
		return TaotaoResult.ok();
	}

}

