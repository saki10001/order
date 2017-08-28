package com.saki.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
import com.saki.entity.Message;
import com.saki.model.TSupllierOrder;
import com.saki.model.TSupllierOrderDetail;
import com.saki.service.SupllierOrderServiceI;

@Namespace("/")
@Action(value="supplier")
public class SupplierOrderAction extends BaseAction implements ModelDriven<TSupllierOrder>{

	private static final Logger logger = Logger.getLogger(SupplierOrderAction.class);
	private TSupllierOrder supllierOrder;
	@Override
	public TSupllierOrder getModel() {
		// TODO Auto-generated method stub
		return supllierOrder;
	}
	private SupllierOrderServiceI supllierOrderService;
	public SupllierOrderServiceI getSupllierOrderService() {
		return supllierOrderService;
	}
	@Autowired
	public void setSupllierOrderService(SupllierOrderServiceI supllierOrderService) {
		this.supllierOrderService = supllierOrderService;
	}
	public void loadAll(){
		String page = getParameter("page");
		String rows = getParameter("rows");
		String sort = getParameter("sort");
		String supllierOrder = getParameter("order");
		super.writeJson(supllierOrderService.loadAll(sort, supllierOrder, page, rows));
	}
	public void add(){
		supllierOrderService.add(supllierOrder);
	}
	public void update(){
		supllierOrderService.update(supllierOrder);
	}
	public void delete(){
		supllierOrderService.deleteByKey(String.valueOf(supllierOrder.getId()));
	}
	public void search(){
		String name = getParameter("name");
		String value = getParameter("value");
		String page = getParameter("page");
		String rows = getParameter("rows");
		String sort = getParameter("sort");
		String supllierOrder = getParameter("order");
		super.writeJson(supllierOrderService.search(name, value,sort, supllierOrder, page, rows));
	}
	
	public void searchDetail() {
		String id = getParameter("id");
		if(!StringUtils.isEmpty(id)) {
			List<Map<String,Object>>  list = supllierOrderService.searchDetail(id);
			String jsonString = JSON.toJSONString(list);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			super.writeJson(jsonArray);
		}
		
	}
	
	
	private void deleteDetail(String delete) {
		JSONArray jsonArr =  JSON.parseArray(delete);
	     //jsonArr.getJSONObject(0);
	     for(int i = 0 ; i < jsonArr.size() ; i ++) {
	    	    	   JSONObject obj = jsonArr.getJSONObject(i);
	    	    	   TSupllierOrderDetail detail = new TSupllierOrderDetail();
	    	    	   detail = (TSupllierOrderDetail)supllierOrderService.getByDetailId(obj.getString("id"));
	    	    	   supllierOrderService.deleteByKey("");
	     }
		
	}
	public void insertDetail(String insert) {
		JSONArray jsonArr =  JSON.parseArray(insert);
	     System.out.println(jsonArr);
	    // jsonArr.getJSONObject(0);
	     for(int i = 0 ; i < jsonArr.size() ; i ++) {
	    	    	   JSONObject obj = jsonArr.getJSONObject(i);
	    	    	   TSupllierOrderDetail detail = new TSupllierOrderDetail();
	    	    	   detail.setNum(StringUtils.isEmpty(obj.getString("acount")) ? 0 : obj.getIntValue("acount"));
	    	    	   detail.setSupllierOrderId(supllierOrder.getId());
	    	    	   detail.setProductDetailId(obj.getInteger("detailId")==0?0:obj.getIntValue("detailId"));
	    	    	   supllierOrderService.add(detail);
	     }
	}
	
	public void updateDetail(String update) {
		JSONArray jsonArr =  JSON.parseArray(update);
	     //jsonArr.getJSONObject(0);
	     for(int i = 0 ; i < jsonArr.size() ; i ++) {
	    	    	   JSONObject obj = jsonArr.getJSONObject(i);
	    	    	   TSupllierOrderDetail detail = new TSupllierOrderDetail();
	    	    	   detail = (TSupllierOrderDetail)supllierOrderService.getByDetailId(obj.getString("id"));
	    	    	   if(detail != null) {
	    	    		   detail.setNum(StringUtils.isEmpty(obj.getString("acount")) ? 0 : obj.getIntValue("acount"));
	    	    		   detail.setProductDetailId(obj.getInteger("detailId")==0?0:obj.getIntValue("detailId"));
	    	    		   supllierOrderService.update(detail);
	    	    	   }
	     }
	}
	public void deleteSupllierOrder(){
		Message j = new Message();
		try {
			String id = getParameter("id");
			supllierOrderService.deleteByKey(id);
			j.setSuccess(true);
			j.setMsg("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		super.writeJson(j);
	}
}
