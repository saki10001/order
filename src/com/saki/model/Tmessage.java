package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tmessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tmessage", schema = "dbo", catalog = "grnDb")

public class Tmessage implements java.io.Serializable {

	// Fields

	private String id;
	private String time;
	private String message;
	private String receiver;
	private String sender;
	private String title;
	private Integer readed;

	// Constructors

	/** default constructor */
	public Tmessage() {
	}

	/** minimal constructor */
	public Tmessage(String id, String time, String receiver, String sender, String title) {
		this.id = id;
		this.time = time;
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
	}

	/** full constructor */
	public Tmessage(String id, String time, String message, String receiver, String sender, String title, Integer readed) {
		this.id = id;
		this.time = time;
		this.message = message;
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
		this.readed = readed;
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

	@Column(name = "time", nullable = false, length = 23)

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "message")

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "receiver", nullable = false, length = 36)

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "sender", nullable = false, length = 36)

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "readed")

	public Integer getReaded() {
		return this.readed;
	}

	public void setReaded(Integer readed) {
		this.readed = readed;
	}
	
}