package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Temail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Temail", schema = "dbo", catalog = "grnDb")
public class Temail implements java.io.Serializable {

	// Fields

	private String id;
	private String account;
	private String password;
	private String stmp;
	private String name;

	// Constructors

	/** default constructor */
	public Temail() {
	}

	/** full constructor */
	public Temail(String id, String account, String password, String stmp,
			String name) {
		this.id = id;
		this.account = account;
		this.password = password;
		this.stmp = stmp;
		this.name = name;
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

	@Column(name = "account", nullable = false, length = 50)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "stmp", nullable = false, length = 50)
	public String getStmp() {
		return this.stmp;
	}

	public void setStmp(String stmp) {
		this.stmp = stmp;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}