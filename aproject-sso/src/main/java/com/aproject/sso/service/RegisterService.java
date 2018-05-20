package com.aproject.sso.service;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.pojo.TbUser;

public interface RegisterService {

	TaotaoResult checkData(String param, int type);
	TaotaoResult register(TbUser user);
}
