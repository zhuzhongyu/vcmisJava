package com.datebase;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	private static final long serialVersionUID = 8180500794568227845L;
	private Integer roleid;
	private String name;
	private String description;
	private String roleRight;
	
	// Constructors

	/** default constructor */
	public Roles() {
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setRoleRight(String roleRight){
		this.roleRight = roleRight;
	}
	
	public String getRoleRight(){
		return this.roleRight;
	}
}