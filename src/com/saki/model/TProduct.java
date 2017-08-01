package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TProduct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_product", catalog = "order")

public class TProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private String product;
	private String type;
	private String unit;
	private String base;
	private String remark;

	// Constructors

	/** default constructor */
	public TProduct() {
	}

	/** minimal constructor */
	public TProduct(Integer id, String product) {
		this.id = id;
		this.product = product;
	}

	/** full constructor */
	public TProduct(Integer id, String product, String type, String unit, String base, String remark) {
		this.id = id;
		this.product = product;
		this.type = type;
		this.unit = unit;
		this.base = base;
		this.remark = remark;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "product", nullable = false, length = 50)

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Column(name = "type", length = 50)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "unit", length = 10)

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "base", length = 10)

	public String getBase() {
		return this.base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}