package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TCompany entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_company", catalog = "order")

public class TCompany implements java.io.Serializable {

	// Fields

	private Integer id;
	private String company;
	private String contacts;
	private String address;
	private String mainBusiness;
	private String level;
	private String remark;

	// Constructors

	/** default constructor */
	public TCompany() {
	}

	/** minimal constructor */
	public TCompany(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TCompany(Integer id, String company, String contacts, String address, String mainBusiness, String level,
			String remark) {
		this.id = id;
		this.company = company;
		this.contacts = contacts;
		this.address = address;
		this.mainBusiness = mainBusiness;
		this.level = level;
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

	@Column(name = "company", length = 80)

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "contacts", length = 20)

	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Column(name = "address", length = 100)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "main_business", length = 100)

	public String getMainBusiness() {
		return this.mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	@Column(name = "level", length = 10)

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}