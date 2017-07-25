package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tlogin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tlogin", schema = "dbo", catalog = "grnDb")
public class Tlogin implements java.io.Serializable {

	// Fields

	private String id;
	private String account;
	private String pwd;
	private String createdatetime;
	private Integer limit;

	public static int LIMIT_ADMIN = 0;
	public static int LIMIT_AUDITOR = 2;
	public static int LIMIT_COMPANY = 3;
	
	// Constructors

	/** default constructor */
	public Tlogin() {
	}

	/** full constructor */
	public Tlogin(String id, String account, String pwd, String createdatetime,
			Integer limit, String name, Boolean sex, Date birth) {
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.createdatetime = createdatetime;
		this.limit = limit;
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

	@Column(name = "account", nullable = false, length = 100)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "pwd", nullable = false, length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "createdatetime", nullable = false, length = 10)
	public String getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(String createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "limit", nullable = false)
	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}