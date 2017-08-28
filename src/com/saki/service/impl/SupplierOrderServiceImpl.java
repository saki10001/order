package com.saki.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saki.dao.BaseDaoI;
import com.saki.entity.Grid;
import com.saki.model.TOrderDetail;
import com.saki.model.TOrderMapping;
import com.saki.model.TProduct;
import com.saki.model.TProductDetail;
import com.saki.model.TSupllierOrder;
import com.saki.model.TSupllierOrderDetail;
import com.saki.service.SupllierOrderServiceI;
import com.saki.utils.DateUtil;

@Service("supllierOrderService")
public class SupplierOrderServiceImpl implements SupllierOrderServiceI{

	private BaseDaoI supplierOrderDao;
	public BaseDaoI getOrderDao() {
		return supplierOrderDao;
	}
	@Autowired
	public void setOrderDao(BaseDaoI supplierOrderDao) {
		this.supplierOrderDao = supplierOrderDao;
	}
	
	@Override
	public void add(Object object) {
		supplierOrderDao.save(object);
	}

	@Override
	public void update(Object object) {
		supplierOrderDao.update(object);
	}

	@Override
	public void deleteByKey(String key) {
		supplierOrderDao.delete(getByKey(key));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Grid loadAll(String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		String hql = "from TSupllierOrder t";
		if(sort!=null && order!=null){
			hql = "from TSupllierOrder t order by " + sort + " " + order;
		}
		List<TSupllierOrder> l = supplierOrderDao.find(hql);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TSupllierOrder> lp = supplierOrderDao.find(hql, Integer.valueOf(page),  Integer.valueOf(rows));
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
		TSupllierOrder t = (TSupllierOrder) supplierOrderDao.get("from TSupllierOrder t where t.id = :id", params);
		return t;
	}

	@Override
	public Grid search(String row, String text, String sort, String order, String page, String rows) {
		Grid grid = new Grid();
		Map<String, Object> params = new HashMap<String, Object>();		
		String hql = "from TSupllierOrder t";
		if(row!=null && text!=null){
			params.put("text", "%" + text + "%");
			hql = hql + " where t." + row + " like :text";
		}
		if(sort!=null && order!=null){
			hql = hql + " order by " + sort + " " + order;
		}	
		List<TSupllierOrder> l = supplierOrderDao.find(hql, params);
		grid.setTotal(l.size());
		if(page!=null && rows !=null){
			List<TSupllierOrder> lp = supplierOrderDao.find(hql, params, Integer.valueOf(page),  Integer.valueOf(rows));
			grid.setRows(lp);
		}else{
			grid.setRows(l);
		}	
		return grid;
	}
	@Override
	public List<Map<String, Object>> searchDetail(String id ) {
		String hql = "from TProduct t , TProductDetail d, TSupllierOrder o , TSupllierOrderDetail od "
				+ " where t.id = d.productId  and o.id = od.supllierOrderId and od.productDetailId = d.id   and  o.id = " + id  ;
		List<Object[]> list = supplierOrderDao.find(hql);
		List<Map<String , Object>>  mapList = new ArrayList<Map<String , Object>>();
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = list.get(i);
			//主表数据
			TProduct product = (TProduct) objs[0];
			TProductDetail detail = (TProductDetail) objs[1];
			TSupllierOrderDetail oDetail = (TSupllierOrderDetail) objs[3];
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
		  List<TProduct> list = supplierOrderDao.find(hql);
		  return list;
		
	}
	public List<TProductDetail> searchDetailByProductId(String productId) {
		String  hql = "from TProductDetail t where t.productId = '" + productId + "'";
		List<TProductDetail> list = supplierOrderDao.find(hql);
		return list;
	}
	@Override
	public TSupllierOrderDetail getByDetailId(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void getOrderDetail() {
		
		System.out.println(new Date());
	}
	@Override
	public void getSupllierOrder() {
		TSupllierOrder supOrder = new TSupllierOrder();
		int amount = 0 ;//订单总数
		List<TOrderMapping> orderMap =  new ArrayList<TOrderMapping>();
		List<Integer > temp = new ArrayList<Integer >();
		List<TSupllierOrderDetail>  supOrderDetailList = new ArrayList<TSupllierOrderDetail>();
	    List<TOrderDetail> orderDetailList =  getOrderDetailsForSupplierOrder();
	    for(TOrderDetail orderDetail : orderDetailList) {
	    		  	  if(orderDetail.getNum() != null ) {
	    		  		     amount += orderDetail.getNum();
	    		  	  }
	    }
	    
	    /**  插入供应商订单*/
	    supOrder.setAmount(amount);
	    supOrder.setStatus("0");//0代表新状态
	    supOrder.setSupplierOrderNo("S_" + DateUtil.getStringDate());
	    add(supOrder);
	    
	    
	    
	    /**插入供应商详情**/
	    for(TOrderDetail orderDetail : orderDetailList) {
		  	  if(!temp.contains(orderDetail.getOrderId())) {
		  		    temp.add(orderDetail.getOrderId());
		  	  }
		  	TSupllierOrderDetail  supDetail  = new TSupllierOrderDetail();
		  	supDetail.setNum(orderDetail.getNum());
		  	supDetail.setProductDetailId(orderDetail.getProductDetailId());
		  	supDetail.setSupllierOrderId(supOrder.getId());
		  	add(supDetail);	
	    	}
	    
	    /**插入关系表**/
	    
	}
	private List<TOrderDetail> getOrderDetailsForSupplierOrder() {
		String  hql = "from TOrderDetail t ";
		List<TOrderDetail> list = supplierOrderDao.find(hql);
		return list;
	}
	
	
}
