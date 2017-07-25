package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ticity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TIcity", schema = "dbo", catalog = "grnDb")

public class Ticity implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String phone;
	private String father;

	// Constructors

	/** default constructor */
	public Ticity() {
	}

	/** minimal constructor */
	public Ticity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Ticity(String id, String name, String phone, String father) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.father = father;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false, length = 6)

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 10)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "father", length = 6)

	public String getFather() {
		return this.father;
	}

	public void setFather(String father) {
		this.father = father;
	}

}