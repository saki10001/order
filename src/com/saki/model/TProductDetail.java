package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TProductDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_product_detail", catalog = "order")

public class TProductDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer productId;
	private String subProduct;
	private String format;
	private String material;
	private String remark;

	// Constructors

	/** default constructor */
	public TProductDetail() {
	}

	/** minimal constructor */
	public TProductDetail(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TProductDetail(Integer id, Integer productId, String subProduct, String format, String material,
			String remark) {
		this.id = id;
		this.productId = productId;
		this.subProduct = subProduct;
		this.format = format;
		this.material = material;
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

	@Column(name = "product_id")

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "sub_product", length = 50)

	public String getSubProduct() {
		return this.subProduct;
	}

	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}

	@Column(name = "format", length = 50)

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "material", length = 20)

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}