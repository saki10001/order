package com.saki.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saki.dao.BaseDaoI;
import com.saki.entity.Grid;
import com.saki.model.TCompany;
import com.saki.model.TOrder;
import com.saki.service.CompanyServiceI;

@Service("companyService")
public class CompanyServiceImpl implements CompanyServiceI{

	private BaseDaoI companyDao;
	
	public BaseDaoI getCompanyDao() {
		return companyDao;
	}
	@Autowired
	public void setCompanyDao(BaseDaoI companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void add(Object object) {
		companyDao.save(object);
	}

	@Override
	public void update(Object object) {
		companyDao.saveOrUpdate(object);
	}

	@Override
	public void deleteByKey(String key) {
		companyDao.delete(getByKey(key));
	}

	@Override
	public Grid loadAll(String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		String hql = "from TCompany t";
		if(sort!=null && order!=null){
			hql = "from TCompany t order by " + sort + " " + order;
		}
		System.out.println(hql);
		List<TCompany> l = companyDao.find(hql);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TCompany> lp = companyDao.find(hql, Integer.valueOf(page),  Integer.valueOf(rows));
			grid.setRows(lp);
		}else{
			grid.setRows(l);
      }	
		return grid;
	}

	@Override
	public Object getByKey(String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", Integer.valueOf(key));
		TCompany t = (TCompany) companyDao.get("from TCompany t where t.id = :id", params);
		return t;
	}

	@Override
	public Grid search(String row, String text, String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		Map<String, Object> params = new HashMap<String, Object>();		
		String hql = "from TCompany t";
		if(row!=null && text!=null){
			params.put("text", "%" + text + "%");
			hql = hql + " where t." + row + " like :text";
		}
		if(sort!=null && order!=null){
			hql = hql + " order by " + sort + " " + order;
		}	
		List<TCompany> l = companyDao.find(hql, params);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TCompany> lp = companyDao.find(hql, params, Integer.valueOf(page),  Integer.valueOf(rows));
			grid.setRows(lp);
		}else{
			grid.setRows(l);
		}	
		return grid;
	}
	
}
