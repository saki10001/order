package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tapply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tapply", schema = "dbo", catalog = "grnDb")

public class Tapply implements java.io.Serializable {

	// Fields

	private String id;
	private String companyId;
	private String title;
	private String contents;
	private Integer state;
	private String managerName;
	private String managerPost;
	private String managerPhone;
	private String contactName;
	private String contactPhone;
	private String reason;
	private Date applytime;
	private Date answertime;
	private String industry;
	private String tap;
	private String owner;
	private String type;

	public static int STATE_WAIT = 0;
	public static int STATE_YES = 1;
	public static int STATE_NO = 2;
	public static int STATE_PLANED = 3;
	public static int STATE_FINISH = 4;
	
	// Constructors

	/** default constructor */
	public Tapply() {
	}

	/** minimal constructor */
	public Tapply(String id, String companyId, Integer state) {
		this.id = id;
		this.companyId = companyId;
		this.state = state;
	}

	/** full constructor */
	public Tapply(String id, String companyId, String title, String contents, Integer state, String managerName,
			String managerPost, String managerPhone, String contactName, String contactPhone, String reason,
			Date applytime, Date answertime, String industry, String tap, String owner, String type) {
		this.id = id;
		this.companyId = companyId;
		this.title = title;
		this.contents = contents;
		this.state = state;
		this.managerName = managerName;
		this.managerPost = managerPost;
		this.managerPhone = managerPhone;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.reason = reason;
		this.applytime = applytime;
		this.answertime = answertime;
		this.industry = industry;
		this.tap = tap;
		this.owner = owner;
		this.type = type;
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

	@Column(name = "companyId", nullable = false, length = 36)

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "title", length = 100)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "contents")

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Column(name = "state", nullable = false)

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "managerName", length = 100)

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "managerPost", length = 100)

	public String getManagerPost() {
		return this.managerPost;
	}

	public void setManagerPost(String managerPost) {
		this.managerPost = managerPost;
	}

	@Column(name = "managerPhone", length = 100)

	public String getManagerPhone() {
		return this.managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	@Column(name = "contactName", length = 100)

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "contactPhone", length = 100)

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "reason")

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "applytime", length = 23)

	public Date getApplytime() {
		return this.applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	@Column(name = "answertime", length = 23)

	public Date getAnswertime() {
		return this.answertime;
	}

	public void setAnswertime(Date answertime) {
		this.answertime = answertime;
	}

	@Column(name = "industry", length = 50)

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "tap", length = 50)

	public String getTap() {
		return this.tap;
	}

	public void setTap(String tap) {
		this.tap = tap;
	}

	@Column(name = "owner", length = 50)

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "type", length = 50)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}