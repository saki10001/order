package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tnotice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tnotice", schema = "dbo", catalog = "grnDb")
public class Tnotice implements java.io.Serializable {

	// Fields

	private String id;
	private String title;
	private String text;
	private String time;
	private Integer type;
	private String personId;

	// Constructors

	/** default constructor */
	public Tnotice() {
	}

	/** full constructor */
	public Tnotice(String id, String title, String text, String time,
			Integer type, String personId) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.time = time;
		this.type = type;
		this.personId = personId;
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

	@Column(name = "title", nullable = false, length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "text", nullable = false)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "time", nullable = false, length = 23)
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "personId", nullable = false, length = 36)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}