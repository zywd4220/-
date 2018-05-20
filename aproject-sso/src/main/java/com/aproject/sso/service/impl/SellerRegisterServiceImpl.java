package com.aproject.sso.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.mapper.TbSellerMapper;
import com.aproject.pojo.TbSeller;
import com.aproject.pojo.TbSellerExample;
import com.aproject.pojo.TbSellerExample.Criteria;
import com.aproject.sso.service.SellerRegisterService;

@Service
public class SellerRegisterServiceImpl implements SellerRegisterService {


	@Autowired
	private TbSellerMapper sellerMapper;

	@Override
	public TaotaoResult checkData(String param, int type) {
		//根据数据类型检查数据
		TbSellerExample example = new TbSellerExample();
		Criteria criteria = example.createCriteria();
		//1、2、3分别代表sellername、phone、email
		if (1 == type) {
			criteria.andSellernameEqualTo(param);
		} else if ( 2 == type) {
			criteria.andPhoneEqualTo(param);
		}
		//执行查询
		List<TbSeller> list = sellerMapper.selectByExample(example);
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
	 * @param seller
	 * @return
	 * @see com.aproject.sso.service.RegisterService#register(com.aproject.pojo.TbSeller)
	 */
	@Override
	public TaotaoResult register(TbSeller seller) {
		// 校验数据
		//校验用户名、密码不能为空
		if (StringUtils.isBlank(seller.getSellername())
				|| StringUtils.isBlank(seller.getPassword())) {
			return TaotaoResult.build(400, "用户名或密码不能为空");
		}
		//校验数据是否重复
		//校验用户名
		TaotaoResult result = checkData(seller.getSellername(), 1);
		if (!(boolean) result.getData()) {
			return TaotaoResult.build(400, "用户名重复");
		}
		//校验手机号
		if (seller.getPhone() != null) {
			result = checkData(seller.getPhone(), 2);
			if (!(boolean) result.getData()) {
				return TaotaoResult.build(400, "手机号重复");
			}
		}
		//密码进行MD5加密
		seller.setPassword(DigestUtils.md5DigestAsHex(seller.getPassword().getBytes()));
		sellerMapper.insert(seller);
		
		return TaotaoResult.ok();
	}


}
