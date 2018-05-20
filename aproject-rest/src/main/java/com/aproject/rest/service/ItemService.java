package com.aproject.rest.service;

import com.aproject.pojo.TbItem;
import com.aproject.pojo.TbItemDesc;
import com.aproject.pojo.TbItemParamItem;

public interface ItemService {

	public TbItem getItemById(Long itemId);
	TbItemDesc getItemDescById(Long itemId);
	public TbItemParamItem getItemParamById(Long itemId);
}
