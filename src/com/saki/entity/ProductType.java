package com.saki.entity;

import java.util.ArrayList;

import com.saki.model.TProductDetail;

public class ProductType {
	
	private String type;
	private String unit;
	private String base;
	private String remark;
	private ArrayList<TProductDetail> children;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ArrayList<TProductDetail> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TProductDetail> children) {
		this.children = children;
	}

}
