package com.aproject.portal.service;

import java.util.List;

import com.aproject.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParamById(Long itemId);
	public List<TbItem> getItemList();
}
