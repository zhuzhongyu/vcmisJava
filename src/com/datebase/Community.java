package com.datebase;

import java.util.List;

/**
 * Community entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Community implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String nameOfCommunity;
	private String nameOfFzr;
	private String phoneOfFzr;
	private String xy;
	private String address;
	private String memo;
	private Integer isglzx;
	private String arealev;
	private String dirNum;
	private String xzqy;
	private String parentName;
	private List<Community> list;
	
	// Constructors

	/** default constructor */
	public Community() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOfCommunity() {
		return this.nameOfCommunity;
	}

	public void setNameOfCommunity(String nameOfCommunity) {
		this.nameOfCommunity = nameOfCommunity;
	}

	public String getNameOfFzr() {
		return this.nameOfFzr;
	}

	public void setNameOfFzr(String nameOfFzr) {
		this.nameOfFzr = nameOfFzr;
	}

	public String getPhoneOfFzr() {
		return this.phoneOfFzr;
	}

	public void setPhoneOfFzr(String phoneOfFzr) {
		this.phoneOfFzr = phoneOfFzr;
	}

	public String getXy() {
		return this.xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getIsglzx() {
		return this.isglzx;
	}

	public void setIsglzx(Integer isglzx) {
		this.isglzx = isglzx;
	}

	public String getArealev() {
		return this.arealev;
	}

	public void setArealev(String arealev) {
		this.arealev = arealev;
	}
	
	public String getDirNum() {
		return this.dirNum;
	}

	public void setDirNum(String dirNum) {
		this.dirNum = dirNum;
	}

	public String getXzqy() {
		return this.xzqy;
	}

	public void setXzqy(String xzqy) {
		this.xzqy = xzqy;
	}
	
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<Community> getList() {
		return list;
	}

	public void setList(List<Community> list) {
		this.list = list;
	}
    
	
	
    
	
}