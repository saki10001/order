package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tcertificate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tcertificate", schema = "dbo", catalog = "grnDb")

public class Tcertificate implements java.io.Serializable {

	// Fields

	private String id;
	private String companyId;
	private String name;
	private String system;
	private String stime;
	private String etime;
	private String companyName;
	private String companyAddress;
	private String code;
	private String remark;

	// Constructors

	/** default constructor */
	public Tcertificate() {
	}

	/** minimal constructor */
	public Tcertificate(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tcertificate(String id, String companyId, String name, String system, String stime, String etime,
			String companyName, String companyAddress, String code, String remark) {
		this.id = id;
		this.companyId = companyId;
		this.name = name;
		this.system = system;
		this.stime = stime;
		this.etime = etime;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.code = code;
		this.remark = remark;
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

	@Column(name = "companyId", length = 36)

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "name", length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "system", length = 50)

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(name = "stime", length = 23)

	public String getStime() {
		return this.stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	@Column(name = "etime", length = 23)

	public String getEtime() {
		return this.etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	@Column(name = "companyName", length = 50)

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "companyAddress", length = 100)

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Column(name = "code", length = 50)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}