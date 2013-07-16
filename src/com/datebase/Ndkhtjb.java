package com.datebase;

/**
 * Ndkhtjb entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ndkhtjb implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer khzf;
	private Integer sdzf;
	private Double khbl;
	private Double yfjf;
	private Double sfjf;
	private Integer commid;
	private Integer state;
	private String khtime;
	private String bz;

	// Constructors

	/** default constructor */
	public Ndkhtjb() {
	}

	/** full constructor */
	public Ndkhtjb(Integer khzf, Integer sdzf, Double khbl, Double yfjf,
			Double sfjf, Integer commid, Integer state, String khtime, String bz) {
		this.khzf = khzf;
		this.sdzf = sdzf;
		this.khbl = khbl;
		this.yfjf = yfjf;
		this.sfjf = sfjf;
		this.commid = commid;
		this.state = state;
		this.khtime = khtime;
		this.bz = bz;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKhzf() {
		return this.khzf;
	}

	public void setKhzf(Integer khzf) {
		this.khzf = khzf;
	}

	public Integer getSdzf() {
		return this.sdzf;
	}

	public void setSdzf(Integer sdzf) {
		this.sdzf = sdzf;
	}

	public Double getKhbl() {
		return this.khbl;
	}

	public void setKhbl(Double khbl) {
		this.khbl = khbl;
	}

	public Double getYfjf() {
		return this.yfjf;
	}

	public void setYfjf(Double yfjf) {
		this.yfjf = yfjf;
	}

	public Double getSfjf() {
		return this.sfjf;
	}

	public void setSfjf(Double sfjf) {
		this.sfjf = sfjf;
	}

	public Integer getCommid() {
		return this.commid;
	}

	public void setCommid(Integer commid) {
		this.commid = commid;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getKhtime() {
		return this.khtime;
	}

	public void setKhtime(String khtime) {
		this.khtime = khtime;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}