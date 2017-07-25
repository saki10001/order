package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tqualify entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tqualify", schema = "dbo", catalog = "grnDb")

public class Tqualify implements java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private String system;
	private Integer qtype;
	private String qid;
	private Date stime;
	private Date etime;
	private Integer statue;
	private String qremark;
	private String systemText;

	// Constructors

	/** default constructor */
	public Tqualify() {
	}

	/** minimal constructor */
	public Tqualify(String id, String pid, String system, Integer qtype) {
		this.id = id;
		this.pid = pid;
		this.system = system;
		this.qtype = qtype;
	}

	/** full constructor */
	public Tqualify(String id, String pid, String system, Integer qtype, String qid, Date stime, Date etime,
			Integer statue, String qremark, String systemText) {
		this.id = id;
		this.pid = pid;
		this.system = system;
		this.qtype = qtype;
		this.qid = qid;
		this.stime = stime;
		this.etime = etime;
		this.statue = statue;
		this.qremark = qremark;
		this.systemText = systemText;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false, length = 100)

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

	@Column(name = "system", nullable = false, length = 50)

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(name = "qtype", nullable = false)

	public Integer getQtype() {
		return this.qtype;
	}

	public void setQtype(Integer qtype) {
		this.qtype = qtype;
	}

	@Column(name = "qid", length = 100)

	public String getQid() {
		return this.qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	@Column(name = "stime", length = 23)

	public Date getStime() {
		return this.stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	@Column(name = "etime", length = 23)

	public Date getEtime() {
		return this.etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	@Column(name = "statue")

	public Integer getStatue() {
		return this.statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	@Column(name = "qremark", length = 100)

	public String getQremark() {
		return this.qremark;
	}

	public void setQremark(String qremark) {
		this.qremark = qremark;
	}

	@Column(name = "system_text", length = 200)

	public String getSystemText() {
		return this.systemText;
	}

	public void setSystemText(String systemText) {
		this.systemText = systemText;
	}

}