package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tresume entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tresume", schema = "dbo", catalog = "grnDb")

public class Tresume implements java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private String company;
	private String job;
	private String stime;
	private String etime;

	// Constructors

	/** default constructor */
	public Tresume() {
	}

	/** full constructor */
	public Tresume(String id, String pid, String company, String job, String stime, String etime) {
		this.id = id;
		this.pid = pid;
		this.company = company;
		this.job = job;
		this.stime = stime;
		this.etime = etime;
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

	@Column(name = "pid", nullable = false, length = 36)

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "company", nullable = false, length = 100)

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "job", nullable = false, length = 100)

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "stime", nullable = false, length = 23)

	public String getStime() {
		return this.stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	@Column(name = "etime", nullable = false, length = 23)

	public String getEtime() {
		return this.etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

}