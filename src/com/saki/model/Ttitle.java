package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ttitle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Ttitle", schema = "dbo", catalog = "grnDb")

public class Ttitle implements java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private String lv;
	private String major;
	private String company;
	private Date time;

	// Constructors

	/** default constructor */
	public Ttitle() {
	}

	/** full constructor */
	public Ttitle(String id, String pid, String lv, String major, String company, Date time) {
		this.id = id;
		this.pid = pid;
		this.lv = lv;
		this.major = major;
		this.company = company;
		this.time = time;
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

	@Column(name = "lv", nullable = false, length = 100)

	public String getLv() {
		return this.lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	@Column(name = "major", nullable = false, length = 100)

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "company", nullable = false, length = 100)

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "time", nullable = false, length = 23)

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}