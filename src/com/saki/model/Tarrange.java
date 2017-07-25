package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tarrange entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tarrange", schema = "dbo", catalog = "grnDb")

public class Tarrange implements java.io.Serializable {

	// Fields

	private String id;
	private String personId;
	private double money;
	private Integer role;
	private Integer score;
	private String planId;
	private String stime;
	private String etime;

	// Constructors

	/** default constructor */
	public Tarrange() {
	}

	/** minimal constructor */
	public Tarrange(String id, String personId, Integer role, String planId) {
		this.id = id;
		this.personId = personId;
		this.role = role;
		this.planId = planId;
	}

	/** full constructor */
	public Tarrange(String id, String personId, double money, Integer role, Integer score, String planId, String stime,
			String etime) {
		this.id = id;
		this.personId = personId;
		this.money = money;
		this.role = role;
		this.score = score;
		this.planId = planId;
		this.stime = stime;
		this.etime = etime;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false, length = 72)

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "personId", nullable = false, length = 36)

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "money", scale = 4)

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Column(name = "role", nullable = false)

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Column(name = "score")

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "planId", nullable = false, length = 36)

	public String getPlanId() {
		return this.planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
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

}