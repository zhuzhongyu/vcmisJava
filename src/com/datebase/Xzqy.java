package com.datebase;

public class Xzqy implements java.io.Serializable 
{
	private Integer id;
	private String name;
	private String number;
	private String parent;
	private Integer level;
	private String peoples;
	private String cityName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Integer getLevel() {
		
		return this.level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getPeoples() {
		return peoples;
	}
	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}
  public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
 