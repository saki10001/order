package com.saki.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saki.dao.BaseDaoI;
import com.saki.entity.Grid;
import com.saki.model.TOrder;
import com.saki.service.OrderServiceI;

@Service("orderService")
public class OrderServiceImpl implements OrderServiceI{

	private BaseDaoI orderDao;
	public BaseDaoI getOrderDao() {
		return orderDao;
	}
	@Autowired
	public void setOrderDao(BaseDaoI orderDao) {
		this.orderDao = orderDao;
	}
	
	@Override
	public void add(Object object) {
		orderDao.save(object);
	}

	@Override
	public void update(Object object) {
		orderDao.saveOrUpdate(object);
	}

	@Override
	public void deleteByKey(String key) {
		orderDao.delete(getByKey(key));
	}

	@Override
	public Grid loadAll(String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		String hql = "from TOrder t";
//		if(sort!=null && order!=null){
//			hql = "from TOrder t order by " + sort + " " + order;
//		}
		List<TOrder> l = orderDao.find(hql);
		grid.setTotal(l.size());
//		if(page!=null && rows !=null){
//			List<TOrder> lp = orderDao.find(hql, Integer.valueOf(page),  Integer.valueOf(rows));
//			grid.setRows(lp);
//		}else{
			grid.setRows(l);
//      }	
		return grid;
	}

	@Override
	public Object getByKey(String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", key);
		TOrder t = (TOrder) orderDao.get("from TOrder t where t.id = :id", params);
		return t;
	}

	@Override
	public Grid search(String row, String text, String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		Map<String, Object> params = new HashMap<String, Object>();		
		String hql = "from TOrder t";
		if(row!=null && text!=null){
			params.put("text", "%" + text + "%");
			hql = hql + " where t." + row + " like :text";
		}
		if(sort!=null && order!=null){
			hql = hql + " order by " + sort + " " + order;
		}	
		List<TOrder> l = orderDao.find(hql, params);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TOrder> lp = orderDao.find(hql, params, Integer.valueOf(page),  Integer.valueOf(rows));
			grid.setRows(lp);
		}else{
			grid.setRows(l);
		}	
		return grid;
	}

}
