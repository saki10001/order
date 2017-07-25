package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tplan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tplan", schema = "dbo", catalog = "grnDb")

public class Tplan implements java.io.Serializable {

	// Fields

	private String id;
	private String applyId;
	private String type;
	private Integer state;
	private String systemId;
	private String stime;
	private String etime;
	private String address;
	private String rangen;
	private String companyId;
	private String leader;
	private String eleader;
	private Integer eresult;
	private String ereason;
	private String ttasked;
	private String tarranged;
	private String trecoveried;
	private String tchecked;
	private String teperson;
	private String tevaluated;
	private String tcertificate;

	// Constructors

	/** default constructor */
	public Tplan() {
	}

	/** minimal constructor */
	public Tplan(String id, String applyId, Integer state, String systemId) {
		this.id = id;
		this.applyId = applyId;
		this.state = state;
		this.systemId = systemId;
	}

	/** full constructor */
	public Tplan(String id, String applyId, String type, Integer state, String systemId, String stime, String etime,
			String address, String rangen, String companyId, String leader, String eleader, Integer eresult,
			String ereason, String ttasked, String tarranged, String trecoveried, String tchecked, String teperson,
			String tevaluated, String tcertificate) {
		this.id = id;
		this.applyId = applyId;
		this.type = type;
		this.state = state;
		this.systemId = systemId;
		this.stime = stime;
		this.etime = etime;
		this.address = address;
		this.rangen = rangen;
		this.companyId = companyId;
		this.leader = leader;
		this.eleader = eleader;
		this.eresult = eresult;
		this.ereason = ereason;
		this.ttasked = ttasked;
		this.tarranged = tarranged;
		this.trecoveried = trecoveried;
		this.tchecked = tchecked;
		this.teperson = teperson;
		this.tevaluated = tevaluated;
		this.tcertificate = tcertificate;
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

	@Column(name = "applyId", nullable = false, length = 36)

	public String getApplyId() {
		return this.applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	@Column(name = "type", length = 100)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "state", nullable = false)

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "systemId", nullable = false, length = 20)

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
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

	@Column(name = "address", length = 100)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "rangen")

	public String getRangen() {
		return this.rangen;
	}

	public void setRangen(String rangen) {
		this.rangen = rangen;
	}

	@Column(name = "companyId", length = 36)

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "leader", length = 36)

	public String getLeader() {
		return this.leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Column(name = "eleader", length = 36)

	public String getEleader() {
		return this.eleader;
	}

	public void setEleader(String eleader) {
		this.eleader = eleader;
	}

	@Column(name = "eresult")

	public Integer getEresult() {
		return this.eresult;
	}

	public void setEresult(Integer eresult) {
		this.eresult = eresult;
	}

	@Column(name = "ereason", length = 500)

	public String getEreason() {
		return this.ereason;
	}

	public void setEreason(String ereason) {
		this.ereason = ereason;
	}

	@Column(name = "ttasked", length = 23)

	public String getTtasked() {
		return this.ttasked;
	}

	public void setTtasked(String ttasked) {
		this.ttasked = ttasked;
	}

	@Column(name = "tarranged", length = 23)

	public String getTarranged() {
		return this.tarranged;
	}

	public void setTarranged(String tarranged) {
		this.tarranged = tarranged;
	}

	@Column(name = "trecoveried", length = 23)

	public String getTrecoveried() {
		return this.trecoveried;
	}

	public void setTrecoveried(String trecoveried) {
		this.trecoveried = trecoveried;
	}

	@Column(name = "tchecked", length = 23)

	public String getTchecked() {
		return this.tchecked;
	}

	public void setTchecked(String tchecked) {
		this.tchecked = tchecked;
	}

	@Column(name = "teperson", length = 23)

	public String getTeperson() {
		return this.teperson;
	}

	public void setTeperson(String teperson) {
		this.teperson = teperson;
	}

	@Column(name = "tevaluated", length = 23)

	public String getTevaluated() {
		return this.tevaluated;
	}

	public void setTevaluated(String tevaluated) {
		this.tevaluated = tevaluated;
	}

	@Column(name = "tcertificate", length = 23)

	public String getTcertificate() {
		return this.tcertificate;
	}

	public void setTcertificate(String tcertificate) {
		this.tcertificate = tcertificate;
	}

}