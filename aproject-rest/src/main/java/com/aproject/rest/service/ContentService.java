package com.aproject.rest.service;

import java.util.List;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.pojo.TbContent;

public interface ContentService {

	List<TbContent>	getContentList(Long cid);
	TaotaoResult syncContent(Long cid);
}
