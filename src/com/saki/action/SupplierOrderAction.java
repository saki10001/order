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
import com.saki.model.TCompany;
import com.saki.model.TProduct;
import com.saki.model.TSupllierOrder;
import com.saki.model.TSupllierOrderDetail;
import com.saki.service.CompanyServiceI;
import com.saki.service.OrderServiceI;
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
	
	private CompanyServiceI companyService;
	public CompanyServiceI getCompanyService() {
		return companyService;
	}
	@Autowired
	public void setCompanyService(CompanyServiceI companyService) {
		this.companyService = companyService;
	}
	private SupllierOrderServiceI supllierOrderService;
	public SupllierOrderServiceI getSupllierOrderService() {
		return supllierOrderService;
	}
	@Autowired
	public void setSupllierOrderService(SupllierOrderServiceI supllierOrderService) {
		this.supllierOrderService = supllierOrderService;
	}
	
	
	private OrderServiceI orderService;
	public OrderServiceI getOrderService() {
		return orderService;
	}
	@Autowired
	public void setOrderService(OrderServiceI orderService) {
		this.orderService = orderService;
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
	
	
	public void splitOrder(){
		Message j = new Message();
		try {
			String id = getParameter("id");
			supllierOrderService.splitOrder(id);
			j.setSuccess(true);
			j.setMsg("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("操作失败：" + e.getMessage());
		}
		super.writeJson(j);
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
	
	public void deleteSupllierOrderDetail(){
		Message j = new Message();
		try {
			String orderId = getParameter("orderId");
			String detailId = getParameter("detailId");
			int acount =supllierOrderService.deleteDetailById(orderId , detailId);
			if(acount == 0){
				j.setSuccess(false);
				j.setMsg("删除失败,每种产品必须保留一条数据");
			}else{
				j.setSuccess(true);
				j.setMsg("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		super.writeJson(j);
	}
	
	public void checkSupllierOrder(){
		Message j = new Message();
		try {
			String id = getParameter("id");
			TSupllierOrder order = (TSupllierOrder)supllierOrderService.getByKey(id);
			if(order !=  null){
				order.setStatus("2");
			}
			supllierOrderService.update(order);
				j.setSuccess(true);
				j.setMsg("审核成功");
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("审核失败");
		}
		super.writeJson(j);
	}
	

	public void getChanges( ) {
		 String orderId = getParameter("id");
		 System.out.println(orderId);
		 String update = getParameter("updated");
		 String msg = "";
		 if(StringUtils.isNotEmpty(update)) {
			msg =  supllierOrderService.updateDetail(update);
		 }
		 Message j = new Message();
		 if(StringUtils.isEmpty(msg)){
			 j.setSuccess(true);
			 j.setMsg("保存成功");
		 }else{
			 j.setSuccess(false);
			 j.setMsg(msg);
		 }
	     super.writeJson(j);
	} 
	
	
	public void getCompany(){
		List<TCompany>  list = supllierOrderService.searchCompany();
		String jsonString = JSON.toJSONString(list);
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		super.writeJson(jsonArray);
	}
	
	public void getSupllierOrder(){
		Message j = new Message();
		try {
			supllierOrderService.getSupllierOrder();
			j.setSuccess(true);
			j.setMsg("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("操作失败");
		}
		super.writeJson(j);
	}
	
	
}
