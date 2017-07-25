package com.saki.service;

import java.util.List;

import com.saki.entity.Grid;


public interface BaseServiceI {
	
	public void saveOrUpdate(Object object);
	
	public void deleteByKey(String key);
	
	public Grid loadAll(String sort, String order, String page, String rows);
	
	public Object getByKey(String key);
	
	public Grid search(String row, String text, String sort, String order, String page, String rows);
	//public ListM<>
	//public void deleteByKey()
}
