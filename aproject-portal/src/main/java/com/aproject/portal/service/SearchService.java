package com.aproject.portal.service;

import com.aproject.portal.pojo.SearchResult;

public interface SearchService {

	public SearchResult search(String keyword, int page, int rows);
}
