package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tqualification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tqualification", schema = "dbo", catalog = "grnDb")

public class Tqualification implements java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private String school;
	private String stime;
	private String etime;
	private String major;
	private String qualification;

	// Constructors

	/** default constructor */
	public Tqualification() {
	}

	/** full constructor */
	public Tqualification(String id, String pid, String school, String stime, String etime, String major,
			String qualification) {
		this.id = id;
		this.pid = pid;
		this.school = school;
		this.stime = stime;
		this.etime = etime;
		this.major = major;
		this.qualification = qualification;
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

	@Column(name = "school", nullable = false, length = 100)

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
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

	@Column(name = "major", nullable = false, length = 100)

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "qualification", nullable = false, length = 100)

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}