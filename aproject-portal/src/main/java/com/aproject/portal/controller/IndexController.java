package com.aproject.portal.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aproject.pojo.TbItem;
import com.aproject.pojo.TbUser;
import com.aproject.portal.service.ContenteService;
import com.aproject.portal.service.ItemService;

@Controller
public class IndexController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ContenteService contenteService;
	@RequestMapping("/index")
	public String showIndex(Model model) {
		//取大广告位内容
		String json = contenteService.getAd1List();
		List<TbItem> itemList = itemService.getItemList();
		model.addAttribute("itemList",itemList);
		//传递给页面
		model.addAttribute("ad1",json);
		return "index";
	}
	
	@RequestMapping(value="/posttest",method=RequestMethod.POST)
	@ResponseBody
	public String postTest(@RequestBody Map map) {
		System.out.println(map.get("name"));
		System.out.println(map.get("pass"));
		return "OK";
	}
	
	
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
}
