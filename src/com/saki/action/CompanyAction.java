package com.saki.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.saki.entity.Message;
import com.saki.model.TCompany;
import com.saki.service.CompanyServiceI;

@Namespace("/")
@Action(value="companyAction")
public class CompanyAction extends BaseAction implements ModelDriven<TCompany>{

	private TCompany company = new TCompany();
	private CompanyServiceI companyService;
	@Override
	public TCompany getModel() {
		return company;
	}
	public CompanyServiceI getCompanyService() {
		return companyService;
	}
	@Autowired
	public void setCompanyService(CompanyServiceI companyService) {
		this.companyService = companyService;
	}
	public void loadAll(){
		String page = getParameter("page");
		String rows = getParameter("rows");
		String sort = getParameter("sort");
		String order = getParameter("order");
		super.writeJson(companyService.loadAll(sort, order, page, rows));
	}
	public void add(){
		Message j = new Message();
		try{
			companyService.add(company);
			j.setSuccess(true);
			j.setMsg("添加成功");
		}catch(Exception e){
			j.setSuccess(false);
			j.setMsg("添加失败");
		}
		super.writeJson(j);
	}
	public void update(){
		Message j = new Message();
		try{
			companyService.update(company);
			j.setSuccess(true);
			j.setMsg("更新成功");
		}catch(Exception e){
			j.setSuccess(false);
			j.setMsg("更新失败");
		}
		super.writeJson(j);
		
	}
	public void delete(){
		Message j = new Message();
		try{
			companyService.deleteByKey(company.getId().toString());
			j.setSuccess(true);
			j.setMsg("删除成功");
		}catch(Exception e){
			e.printStackTrace();
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		super.writeJson(j);
		
	}
	public void search(){
		String name = getParameter("name");
		String value = getParameter("value");
		String page = getParameter("page");
		String rows = getParameter("rows");
		String sort = getParameter("sort");
		String order = getParameter("order");
		super.writeJson(companyService.search(name, value,sort, order, page, rows));
	}
}
