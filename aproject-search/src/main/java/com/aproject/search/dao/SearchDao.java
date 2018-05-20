package com.aproject.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.aproject.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query)throws Exception;
}
