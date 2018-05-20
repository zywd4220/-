package com.aproject.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.HttpClientUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.portal.pojo.SearchResult;
import com.aproject.portal.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;

	@Override
	public SearchResult search(String keyword, int page, int rows) {
		//调用服务查询商品列表
		Map<String, String> param = new HashMap<>();
		param.put("keyword", keyword);
		param.put("page", page + "");
		param.put("rows", rows + "");
		//调用服务
		String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, SearchResult.class);
		//取返回的结果
		SearchResult searchResult = (SearchResult) taotaoResult.getData();
		
		return searchResult;
	}

}
