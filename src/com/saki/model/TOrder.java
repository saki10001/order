package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_order", catalog = "order")

public class TOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer companyId;
	private String order;
	private Date startDate;
	private Date confirmDate;
	private Date pillDate;
	private Date endDate;
	private String status;
	private double amount;
	private String remark;

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TOrder(Integer id, Integer companyId, String order, Date startDate, Date confirmDate, Date pillDate,
			Date endDate, String status, double amount, String remark) {
		this.id = id;
		this.companyId = companyId;
		this.order = order;
		this.startDate = startDate;
		this.confirmDate = confirmDate;
		this.pillDate = pillDate;
		this.endDate = endDate;
		this.status = status;
		this.amount = amount;
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

	@Column(name = "company_id")

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "order", length = 50)

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Column(name = "start_date", length = 19)

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "confirm_date", length = 19)

	public Date getConfirmDate() {
		return this.confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	@Column(name = "pill_date", length = 19)

	public Date getPillDate() {
		return this.pillDate;
	}

	public void setPillDate(Date pillDate) {
		this.pillDate = pillDate;
	}

	@Column(name = "end_date", length = 19)

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "status", length = 5)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "amount", precision = 10, scale = 5)

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}