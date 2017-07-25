package com.saki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tperson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Tperson", schema = "dbo", catalog = "grnDb")

public class Tperson implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Integer sex;
	private String birth;
	private String number;
	private String nation;
	private String city;
	private String cityCode;
	private String address;
	private String phone;
	private String email;
	private String company;
	private String remark;
	private String certificate;
	private String ctfNumber;

	// Constructors

	/** default constructor */
	public Tperson() {
	}

	/** minimal constructor */
	public Tperson(String id, String name, Integer sex, String birth, String nation, String city, String cityCode,
			String address, String phone, String email, String company, String certificate, String ctfNumber) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.nation = nation;
		this.city = city;
		this.cityCode = cityCode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.certificate = certificate;
		this.ctfNumber = ctfNumber;
	}

	/** full constructor */
	public Tperson(String id, String name, Integer sex, String birth, String number, String nation, String city,
			String cityCode, String address, String phone, String email, String company, String remark,
			String certificate, String ctfNumber) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.number = number;
		this.nation = nation;
		this.city = city;
		this.cityCode = cityCode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.company = company;
		this.remark = remark;
		this.certificate = certificate;
		this.ctfNumber = ctfNumber;
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

	@Column(name = "sex", nullable = false)

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "birth", nullable = false, length = 23)

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Column(name = "number", length = 100)

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "nation", nullable = false, length = 100)

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
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

	@Column(name = "address", nullable = false, length = 100)

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", nullable = false, length = 100)

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", nullable = false, length = 100)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "company", nullable = false, length = 100)

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "remark", length = 100)

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "certificate", nullable = false, length = 100)

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Column(name = "ctfNumber", nullable = false, length = 100)

	public String getCtfNumber() {
		return this.ctfNumber;
	}

	public void setCtfNumber(String ctfNumber) {
		this.ctfNumber = ctfNumber;
	}

}