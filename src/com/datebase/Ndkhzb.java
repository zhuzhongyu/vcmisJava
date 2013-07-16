package com.datebase;

/**
 * Ndkhzb entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ndkhzb implements java.io.Serializable {

	// Fields

	private Integer zbid;
	private Integer zblx;
	private String zbmc;
	private String zbsm;
	private String zbyq;
	private String khff;
	private Integer khfz;

	// Constructors

	/** default constructor */
	public Ndkhzb() {
	}

	/** full constructor */
	public Ndkhzb(Integer zblx, String zbmc, String zbsm, String zbyq,
			String khff, Integer khfz) {
		this.zblx = zblx;
		this.zbmc = zbmc;
		this.zbsm = zbsm;
		this.zbyq = zbyq;
		this.khff = khff;
		this.khfz = khfz;
	}

	// Property accessors

	public Integer getZbid() {
		return this.zbid;
	}

	public void setZbid(Integer zbid) {
		this.zbid = zbid;
	}

	public Integer getZblx() {
		return this.zblx;
	}

	public void setZblx(Integer zblx) {
		this.zblx = zblx;
	}

	public String getZbmc() {
		return this.zbmc;
	}

	public void setZbmc(String zbmc) {
		this.zbmc = zbmc;
	}

	public String getZbsm() {
		return this.zbsm;
	}

	public void setZbsm(String zbsm) {
		this.zbsm = zbsm;
	}

	public String getZbyq() {
		return this.zbyq;
	}

	public void setZbyq(String zbyq) {
		this.zbyq = zbyq;
	}

	public String getKhff() {
		return this.khff;
	}

	public void setKhff(String khff) {
		this.khff = khff;
	}

	public Integer getKhfz() {
		return this.khfz;
	}

	public void setKhfz(Integer khfz) {
		this.khfz = khfz;
	}

}