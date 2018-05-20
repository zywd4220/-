package com.aproject.rest.service.Impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aproject.common.pojo.TaotaoResult;
import com.aproject.common.utils.JsonUtils;
import com.aproject.mapper.TbContentMapper;
import com.aproject.pojo.TbContent;
import com.aproject.pojo.TbContentExample;
import com.aproject.pojo.TbContentExample.Criteria;
import com.aproject.rest.component.JedisClient;
import com.aproject.rest.service.ContentService;

//内容查询服务
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_CONTENT_KEY}")
	private String REDIS_CONTENT_KEY;
	@Override
	public List<TbContent> getContentList(Long cid) {
		//添加缓存
		//查询数据库之前先查询缓存，如果有直接返回
		try {
			//从redis中取缓存数据
			String json = jedisClient.hget(REDIS_CONTENT_KEY, cid+"");
			if(!StringUtils.isBlank(json)) {
				//把json转换成List
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//根据cid查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		
		//返回结果前先，向缓存中添加数据
		try {
			//为了规范key可以使用hash
			//定义一个保存内容的KEY，hash中每个项就是cid
			//values是list，需要把list转换成Json数据
			jedisClient.hset(REDIS_CONTENT_KEY, cid+"", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//缓存同步
	@Override
	public TaotaoResult syncContent(Long cid) {
		jedisClient.hdel(REDIS_CONTENT_KEY, cid+"");
		return TaotaoResult.ok();
	}

}
