package com.datebase;

/**
 * CommType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CommType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private String typeRight;

	// Constructors

	/** default constructor */
	public CommType() {
	}

	/** full constructor */
	public CommType(String typeName, String typeRight) {
		this.typeName = typeName;
		this.typeRight = typeRight;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeRight() {
		return this.typeRight;
	}

	public void setTypeRight(String typeRight) {
		this.typeRight = typeRight;
	}

}