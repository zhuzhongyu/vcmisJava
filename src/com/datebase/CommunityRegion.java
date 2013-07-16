package com.datebase;

public class CommunityRegion implements java.io.Serializable 
{
	private Integer id;
	private Integer orgaId;
	private String regionId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrgaId() {
		return orgaId;
	}
	public void setOrgaId(Integer orgaId) {
		this.orgaId = orgaId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}
