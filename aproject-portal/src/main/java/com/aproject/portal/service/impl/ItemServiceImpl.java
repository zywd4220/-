package com.aproject.portal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.EasyUIDataGridResult;
import com.aproject.common.pojo.HttpClientUtil;
import com.aproject.common.pojo.TaotaoResult;
import com.aproject.common.utils.JsonUtils;
import com.aproject.mapper.TbItemMapper;
import com.aproject.pojo.TbItem;
import com.aproject.pojo.TbItemDesc;
import com.aproject.pojo.TbItemExample;
import com.aproject.pojo.TbItemParamItem;
import com.aproject.pojo.TbItemExample.Criteria;
import com.aproject.portal.pojo.PortalItem;
import com.aproject.portal.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	TbItemMapper itemMapper;
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_ITEM_BASE_URL}")
	private String REST_ITEM_BASE_URL;
	@Value("${REST_ITEM_DESC_URL}")
	private String REST_ITEM_DESC_URL;
	@Value("${REST_ITEM_PARAM_URL}")
	private String REST_ITEM_PARAM_URL;
	
	@Override
	public TbItem getItemById(Long itemId) {
		// 根据商品id查询商品基本信息
		String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_BASE_URL + itemId);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, PortalItem.class);
		//取商品对象
		TbItem item = (TbItem) taotaoResult.getData();
		return item;
	}

	@Override
	public String getItemDescById(Long itemId) {
		//根据商品id调用taotao-rest的服务获得数据
		//http://localhost:8081/rest/item/desc/144766336139977
		String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_DESC_URL + itemId);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemDesc.class);
		//取商品描述
		TbItemDesc itemDesc = (TbItemDesc) taotaoResult.getData();
		String desc = itemDesc.getItemDesc();
		return desc;
	}

	@Override
	public String getItemParamById(Long itemId) {
		// 根据商品id获得对应的规格参数
		String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_PARAM_URL + itemId);
		// 转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemParamItem.class);
		// 取规格参数
		TbItemParamItem itemParamItem = (TbItemParamItem) taotaoResult.getData();
		String paramJson = itemParamItem.getParamData();
		// 把规格参数的json数据转换成java对象
		// 转换成java对象
		List<Map> mapList = JsonUtils.jsonToList(paramJson, Map.class);
		// 遍历list生成html
		StringBuffer sb = new StringBuffer();

		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
		sb.append("	<tbody>\n");
		for (Map map : mapList) {
			sb.append("		<tr>\n");
			sb.append("			<th class=\"tdTitle\" colspan=\"2\">" + map.get("group") + "</th>\n");
			sb.append("		</tr>\n");
			// 取规格项
			List<Map> mapList2 = (List<Map>) map.get("params");
			for (Map map2 : mapList2) {
				sb.append("		<tr>\n");
				sb.append("			<td class=\"tdTitle\">" + map2.get("k") + "</td>\n");
				sb.append("			<td>" + map2.get("v") + "</td>\n");
				sb.append("		</tr>\n");
			}
		}
		sb.append("	</tbody>\n");
		sb.append("</table>");

		return sb.toString();

	}

	@Override
	public List<TbItem> getItemList() {
		//分页处理
		
		//执行查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		List<TbItem> list = itemMapper.selectByExample(example);
		List<TbItem> resultList = new ArrayList<>();
		int  index = 0;
		for(TbItem tbItem : list) {
			if(index>=15) {
				break;
			}
			resultList.add(tbItem);
			index++;
		}
		//返回处理结果

		
		return resultList;
	}
}


