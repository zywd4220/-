package com.aproject.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aproject.common.pojo.ExceptionUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.search.service.ItemService;

@Controller
public class ItemController {
//导入商品数据
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importAll() {
		try {
			TaotaoResult result = itemService.importItems();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
