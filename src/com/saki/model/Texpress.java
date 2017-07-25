package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Texpress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Texpress", schema = "dbo", catalog = "grnDb")
public class Texpress implements java.io.Serializable {

	// Fields

	private String id;
	private String operator;
	private String company;
	private String number;
	private String receiver;
	private String sender;
	private String time;

	// Constructors

	/** default constructor */
	public Texpress() {
	}

	/** full constructor */
	public Texpress(String id, String operator, String company, String number,
			String receiver, String sender, String time) {
		this.id = id;
		this.operator = operator;
		this.company = company;
		this.number = number;
		this.receiver = receiver;
		this.sender = sender;
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

	@Column(name = "operator", nullable = false, length = 50)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "company", nullable = false, length = 50)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "number", nullable = false, length = 50)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "receiver", nullable = false, length = 50)
	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "sender", nullable = false, length = 50)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "time", nullable = false, length = 10)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}