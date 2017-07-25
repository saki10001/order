package com.saki.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tcompany entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tcompany", schema = "dbo", catalog = "grnDb")

public class Tcompany implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String orgCode;
	private String contact;
	private String phone;
	private String industry;
	private double rgistCpt;
	private String prptCode;
	private String phoneCmp;
	private String fax;
	private Integer people;
	private String legal;
	private String city;
	private String cityCode;
	private Integer invcType;
	private String tax;
	private String addrInvc;
	private String phoneInvc;
	private String bank;
	private String bankAcct;
	private String addrAdit;
	private Integer zipAdit;
	private String addrCer;
	private Integer zipCer;
	private String addrCtr;
	private Integer zipCtr;
	private String createtime;
	private String updatetime;

	// Constructors

	/** default constructor */
	public Tcompany() {
	}

	/** minimal constructor */
	public Tcompany(String id, String name, String orgCode, String contact, String phone, String industry,
			double rgistCpt, String prptCode, String phoneCmp, String fax, Integer people, String legal, String city,
			String cityCode, String addrAdit) {
		this.id = id;
		this.name = name;
		this.orgCode = orgCode;
		this.contact = contact;
		this.phone = phone;
		this.industry = industry;
		this.rgistCpt = rgistCpt;
		this.prptCode = prptCode;
		this.phoneCmp = phoneCmp;
		this.fax = fax;
		this.people = people;
		this.legal = legal;
		this.city = city;
		this.cityCode = cityCode;
		this.addrAdit = addrAdit;
	}

	/** full constructor */
	public Tcompany(String id, String name, String orgCode, String contact, String phone, String industry,
			double rgistCpt, String prptCode, String phoneCmp, String fax, Integer people, String legal, String city,
			String cityCode, Integer invcType, String tax, String addrInvc, String phoneInvc, String bank,
			String bankAcct, String addrAdit, Integer zipAdit, String addrCer, Integer zipCer, String addrCtr,
			Integer zipCtr, String createtime, String updatetime) {
		this.id = id;
		this.name = name;
		this.orgCode = orgCode;
		this.contact = contact;
		this.phone = phone;
		this.industry = industry;
		this.rgistCpt = rgistCpt;
		this.prptCode = prptCode;
		this.phoneCmp = phoneCmp;
		this.fax = fax;
		this.people = people;
		this.legal = legal;
		this.city = city;
		this.cityCode = cityCode;
		this.invcType = invcType;
		this.tax = tax;
		this.addrInvc = addrInvc;
		this.phoneInvc = phoneInvc;
		this.bank = bank;
		this.bankAcct = bankAcct;
		this.addrAdit = addrAdit;
		this.zipAdit = zipAdit;
		this.addrCer = addrCer;
		this.zipCer = zipCer;
		this.addrCtr = addrCtr;
		this.zipCtr = zipCtr;
		this.createtime = createtime;
		this.updatetime = updatetime;
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

	@Column(name = "name", nullable = false, length = 100)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "orgCode", nullable = false, length = 100)

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "contact", nullable = false, length = 100)

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "phone", nullable = false, length = 100)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "industry", nullable = false, length = 100)

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "rgistCpt", nullable = false, scale = 4)

	public double getRgistCpt() {
		return this.rgistCpt;
	}

	public void setRgistCpt(double rgistCpt) {
		this.rgistCpt = rgistCpt;
	}

	@Column(name = "prptCode", nullable = false, length = 100)

	public String getPrptCode() {
		return this.prptCode;
	}

	public void setPrptCode(String prptCode) {
		this.prptCode = prptCode;
	}

	@Column(name = "phoneCmp", nullable = false, length = 100)

	public String getPhoneCmp() {
		return this.phoneCmp;
	}

	public void setPhoneCmp(String phoneCmp) {
		this.phoneCmp = phoneCmp;
	}

	@Column(name = "fax", nullable = false, length = 100)

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "people", nullable = false)

	public Integer getPeople() {
		return this.people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	@Column(name = "legal", nullable = false, length = 100)

	public String getLegal() {
		return this.legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	@Column(name = "city", nullable = false, length = 100)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "cityCode", nullable = false, length = 100)

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Column(name = "invcType")

	public Integer getInvcType() {
		return this.invcType;
	}

	public void setInvcType(Integer invcType) {
		this.invcType = invcType;
	}

	@Column(name = "tax", length = 100)

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	@Column(name = "addrInvc", length = 100)

	public String getAddrInvc() {
		return this.addrInvc;
	}

	public void setAddrInvc(String addrInvc) {
		this.addrInvc = addrInvc;
	}

	@Column(name = "phoneInvc", length = 100)

	public String getPhoneInvc() {
		return this.phoneInvc;
	}

	public void setPhoneInvc(String phoneInvc) {
		this.phoneInvc = phoneInvc;
	}

	@Column(name = "bank", length = 100)

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "bankAcct", length = 100)

	public String getBankAcct() {
		return this.bankAcct;
	}

	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct;
	}

	@Column(name = "addrAdit", nullable = false, length = 100)

	public String getAddrAdit() {
		return this.addrAdit;
	}

	public void setAddrAdit(String addrAdit) {
		this.addrAdit = addrAdit;
	}

	@Column(name = "zipAdit")

	public Integer getZipAdit() {
		return this.zipAdit;
	}

	public void setZipAdit(Integer zipAdit) {
		this.zipAdit = zipAdit;
	}

	@Column(name = "addrCer", length = 100)

	public String getAddrCer() {
		return this.addrCer;
	}

	public void setAddrCer(String addrCer) {
		this.addrCer = addrCer;
	}

	@Column(name = "zipCer")

	public Integer getZipCer() {
		return this.zipCer;
	}

	public void setZipCer(Integer zipCer) {
		this.zipCer = zipCer;
	}

	@Column(name = "addrCtr", length = 100)

	public String getAddrCtr() {
		return this.addrCtr;
	}

	public void setAddrCtr(String addrCtr) {
		this.addrCtr = addrCtr;
	}

	@Column(name = "zipCtr")

	public Integer getZipCtr() {
		return this.zipCtr;
	}

	public void setZipCtr(Integer zipCtr) {
		this.zipCtr = zipCtr;
	}

	@Column(name = "createtime", length = 23)

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Column(name = "updatetime", length = 23)

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}