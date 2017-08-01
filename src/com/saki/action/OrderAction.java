package com.saki.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.saki.model.TOrder;
import com.saki.service.OrderServiceI;

@Namespace("/")
@Action(value="orderAction")
public class OrderAction extends BaseAction implements ModelDriven<TOrder>{

	private static final Logger logger = Logger.getLogger(OrderAction.class);
	private TOrder order;
	@Override
	public TOrder getModel() {
		// TODO Auto-generated method stub
		return order;
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
		String order = getParameter("order");
		super.writeJson(orderService.loadAll(sort, order, page, rows));
	}
	public void add(){
		orderService.add(order);
	}
	public void update(){
		orderService.update(order);
	}
	public void delete(){
		orderService.deleteByKey(String.valueOf(order.getId()));
	}
	public void search(){
		String name = getParameter("name");
		String value = getParameter("value");
		String page = getParameter("page");
		String rows = getParameter("rows");
		String sort = getParameter("sort");
		String order = getParameter("order");
		super.writeJson(orderService.search(name, value,sort, order, page, rows));
	}
}
