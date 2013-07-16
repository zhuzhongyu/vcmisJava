package com.datebase;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 466062881274033006L;
	private Integer userid;
	private Roles roles;
	private Community community;
	private String name;
	private String pwd;
	private String usercode;
	private String chName;
	private String sex;
	private String phone;
	private String email;
	private String address;
	private String cardNums;
	private String ipNums;
	private String ipPwd;
	private String memo;
	private String laselogtime;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	@SuppressWarnings("unchecked")
	public Users(Community community, Roles roles, String name, String pwd,
			String usercode, String chName, String sex, String phone,
			String email, String address, String cardNums, String ipNums,
			String ipPwd, String memo, String laselogtime, Set userpowers) {
		this.roles = roles;
		this.name = name;
		this.pwd = pwd;
		this.usercode = usercode;
		this.chName = chName;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.cardNums = cardNums;
		this.ipNums = ipNums;
		this.ipPwd = ipPwd;
		this.memo = memo;
		this.laselogtime = laselogtime;
		this.community = community;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Community getCommunity() {
		return this.community;
	}

	public void setCommunity(Community comm) {
		this.community = comm;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsercode() {
		return this.usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getChName() {
		return this.chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardNums() {
		return this.cardNums;
	}

	public void setCardNums(String cardNums) {
		this.cardNums = cardNums;
	}

	public String getIpNums() {
		return this.ipNums;
	}

	public void setIpNums(String ipNums) {
		this.ipNums = ipNums;
	}

	public String getIpPwd() {
		return this.ipPwd;
	}

	public void setIpPwd(String ipPwd) {
		this.ipPwd = ipPwd;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getLaselogtime() {
		return this.laselogtime;
	}

	public void setLaselogtime(String laselogtime) {
		this.laselogtime = laselogtime;
	}
}