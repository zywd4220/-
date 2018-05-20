package com.aproject.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aproject.common.pojo.EasyUIDataGridResult;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.pojo.TbItem;
import com.aproject.pojo.TbSeller;
import com.aproject.portal.service.ItemService;

//展示商品详情
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId,Model model) {
		TbItem item = itemService.getItemById(itemId);
		model.addAttribute("item",item);
		return "item";
		
	}
	
	@RequestMapping(value="/item/desc/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemDesc(@PathVariable Long itemId) {
		String desc = itemService.getItemDescById(itemId);
		return desc;
	}	

	@RequestMapping(value="/item/param/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemParam(@PathVariable Long itemId) {
		String paramHtml = itemService.getItemParamById(itemId);
		return paramHtml;
	}
	

}
