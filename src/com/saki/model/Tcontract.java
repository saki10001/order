package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tcontract entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tcontract", schema = "dbo", catalog = "grnDb")

public class Tcontract implements java.io.Serializable {

	// Fields

	private String id;
	private String company;
	private double money;
	private String time;
	private String remark;
	private String system;

	// Constructors

	/** default constructor */
	public Tcontract() {
	}

	/** minimal constructor */
	public Tcontract(String id, String company, double money, String time) {
		this.id = id;
		this.company = company;
		this.money = money;
		this.time = time;
	}

	/** full constructor */
	public Tcontract(String id, String company, double money, String time, String remark, String system) {
		this.id = id;
		this.company = company;
		this.money = money;
		this.time = time;
		this.remark = remark;
		this.system = system;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false, length = 36)

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "company", nullable = false, length = 50)

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "money", nullable = false, scale = 4)

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Column(name = "time", nullable = false, length = 10)

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "system")

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

}