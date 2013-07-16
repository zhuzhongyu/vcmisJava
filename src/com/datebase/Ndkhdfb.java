package com.datebase;

/**
 * Ndkhdfb entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ndkhdfb implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer commid;
	private Integer zbid;
	private Integer sdfz;
	private String khtime;

	// Constructors

	/** default constructor */
	public Ndkhdfb() {
	}

	/** full constructor */
	public Ndkhdfb(Integer commid, Integer zbid, Integer sdfz, String khtime) {
		this.commid = commid;
		this.zbid = zbid;
		this.sdfz = sdfz;
		this.khtime = khtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommid() {
		return this.commid;
	}

	public void setCommid(Integer commid) {
		this.commid = commid;
	}

	public Integer getZbid() {
		return this.zbid;
	}

	public void setZbid(Integer zbid) {
		this.zbid = zbid;
	}

	public Integer getSdfz() {
		return this.sdfz;
	}

	public void setSdfz(Integer sdfz) {
		this.sdfz = sdfz;
	}

	public String getKhtime() {
		return this.khtime;
	}

	public void setKhtime(String khtime) {
		this.khtime = khtime;
	}

}