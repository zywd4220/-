package com.aproject.search.service;

import com.aproject.search.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString,int page,int rows)throws Exception;
}
