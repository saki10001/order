package com.saki.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saki.utils.MD5Util;
import com.saki.dao.BaseDaoI;
import com.saki.entity.Grid;
import com.saki.model.TCompany;
import com.saki.model.TUser;
import com.saki.service.CompanyServiceI;
import com.saki.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI{

	private BaseDaoI userDao;
	private CompanyServiceI companyService;
	@Override
	public void add(Object object) {
		((TUser)object).setUserPwd(MD5Util.md5("000000"));
		userDao.save(object);
	}

	@Override
	public void update(Object object) {
		userDao.update(object);
	}

	@Override
	public void deleteByKey(String key) {
		userDao.delete(getByKey(key));
	}

	@Override
	public Grid loadAll(String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		String hql = "from TUser t";
		if(sort!=null && order!=null){
			hql = "from TUser t order by " + sort + " " + order;
		}
		System.out.println(hql);
		List<TUser> l = userDao.find(hql);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TUser> lp = userDao.find(hql, Integer.valueOf(page),  Integer.valueOf(rows));
			grid.setRows(copyToEntity(lp));
		}else{
			grid.setRows(copyToEntity(l));
      }	
		return grid;
	}

	@Override
	public Object getByKey(String key) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", Integer.valueOf(key));
		TUser t = (TUser) userDao.get("from TUser t where t.id = :id", params);
		return t;
	}

	@Override
	public Grid search(String row, String text, String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		Map<String, Object> params = new HashMap<String, Object>();		
		String hql = "from TUser t";
		if(row!=null && text!=null){
			params.put("text", "%" + text + "%");
			hql = hql + " where t." + row + " like :text";
		}
		if(sort!=null && order!=null){
			hql = hql + " order by " + sort + " " + order;
		}	
		List<TUser> l = userDao.find(hql, params);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TUser> lp = userDao.find(hql, params, Integer.valueOf(page),  Integer.valueOf(rows));
			grid.setRows(copyToEntity(lp));
		}else{
			grid.setRows(copyToEntity(l));
		}	
		return grid;
	}

	public BaseDaoI getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(BaseDaoI userDao) {
		this.userDao = userDao;
	}

	public CompanyServiceI getCompanyService() {
		return companyService;
	}
	@Autowired
	public void setCompanyService(CompanyServiceI companyService) {
		this.companyService = companyService;
	}
	private List<TUser> copyToEntity(List<TUser> lu){
		for(int i=0; i<lu.size(); i++){
			if(lu.get(i).getCompanyId()!=null){
				TCompany c = (TCompany) companyService.getByKey(lu.get(i).getCompanyId().toString());
				if(c!=null){
					lu.get(i).setCompanyName(c.getName());
				}		
			}				
		}
		return lu;
		
	}

	@Override
	public TUser login(TUser user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName",user.getUserName());
		params.put("userPwd", MD5Util.md5(user.getUserPwd()));
		
		TUser t = (TUser) userDao.get("from TUser t where t.userName = :userName and t.userPwd = :userPwd", params);
		if(t!=null){
			user.setCompanyId(t.getCompanyId());
			user.setId(t.getId());
			user.setRoleId(t.getRoleId());
			return user;
		}
		return null;
	}

	@Override
	public TUser getByCompanyId(int companyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		TUser t = (TUser) userDao.get("from TUser t where t.companyId = :companyId", params);
		return t;
	}
}
