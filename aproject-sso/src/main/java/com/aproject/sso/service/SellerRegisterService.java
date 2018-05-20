package com.aproject.sso.service;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.pojo.TbSeller;


public interface SellerRegisterService {

	TaotaoResult checkData(String param, int type);
	TaotaoResult register(TbSeller seller);
}
