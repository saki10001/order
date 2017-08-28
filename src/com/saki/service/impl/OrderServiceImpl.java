package com.saki.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saki.dao.BaseDaoI;
import com.saki.entity.Grid;
import com.saki.model.TOrder;
import com.saki.model.TOrderDetail;
import com.saki.model.TProduct;
import com.saki.model.TProductDetail;
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
		orderDao.update(object);
	}

	@Override
	public void deleteByKey(String key) {
		orderDao.delete(getByKey(key));
	}

	@Override
	public Grid loadAll(String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		String hql = "from TOrder t";
		if(sort!=null && order!=null){
			hql = "from TOrder t order by " + sort + " " + order;
		}
		List<TOrder> l = orderDao.find(hql);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TOrder> lp = orderDao.find(hql, Integer.valueOf(page),  Integer.valueOf(rows));
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
	@Override
	public List<Map<String, Object>> searchDetail(String id ) {
		String hql = "from TProduct t , TProductDetail d, TOrder o , TOrderDetail od "
				+ " where t.id = d.productId  and o.id = od.orderId and od.productDetailId = d.id   and  o.id = " + id  ;
		List<Object[]> list = orderDao.find(hql);
		List<Map<String , Object>>  mapList = new ArrayList<Map<String , Object>>();
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = list.get(i);
			//主表数据
			TProduct product = (TProduct) objs[0];
			TProductDetail detail = (TProductDetail) objs[1];
			TOrderDetail oDetail = (TOrderDetail) objs[3];
			Map<String , Object >  map = new HashMap<String,Object>();
			map.put("id", oDetail.getId());
			map.put("product", product.getProduct() );
			map.put("type",  product.getType());
			map.put("sub_product", detail.getSubProduct());
			map.put("materail", detail.getMaterial());
//			map.put("acount", );
			map.put("unit", product.getUnit());
//			map.put("price",  detail );
			map.put("detailId", detail.getId());
			map.put("productId", product.getId());
			mapList.add(map);
		}
		
		return mapList ;
	}
	@Override
	public List<TProduct> searchProduct() {
		  String hql = "select distinct  new TProduct(product , unit) from TProduct  " ;
		  List<TProduct> list = orderDao.find(hql);
		  return list;
		
	}
	@Override
	public List<TProduct> searchProductType(String product) {
		String  hql = "from TProduct t where t.product = '" + product + "'";
		List<TProduct> list = orderDao.find(hql);
		return list;
	}
	public List<TProductDetail> searchDetailByProductId(String productId) {
		String  hql = "from TProductDetail t where t.productId = '" + productId + "'";
		List<TProductDetail> list = orderDao.find(hql);
		return list;
	}
	@Override
	public TOrderDetail getByDetailId(String detailId) {
		String  hql = "from TOrderDetail t where t.id = '" + detailId + "'";
		List<TOrderDetail> list = orderDao.find(hql);
		if(list!= null  && list.size()>0) {
			  
			return list.get(0);
		}
		return null ;
	}
	@Override
	public void delete(TOrderDetail detail) {
		orderDao.delete(detail);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TOrderDetail> getOrderDetailsForSupplierOrder() {
		String  hql = "from TOrderDetail t ";
		List<TOrderDetail> list = orderDao.find(hql);
		return list;
	}
	
	
}
