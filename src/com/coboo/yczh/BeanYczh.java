package com.coboo.yczh;

public class BeanYczh {
	
	private int xh = 0;
	private String dataType = "";
	private String personid = "";
	private String riqi = "";
	private String mtime = "";
	private String xt = "";
	private String xy_ss = "";
	private String xy_sz = "";
	private String xy_xt = "";
	private boolean issave = false;
	
	
	public void setXh(int xh){
		this.xh = xh;
	}
	
	public int getXh(){
		return xh;
	}
	
	public void setDataType(String dataType){
		this.dataType = dataType;
	}
	
	public String getDataType(){
		return this.dataType;
	}
	
	public void setPersonid(String personid){
		this.personid = personid;
	}
	
	public String getPersonid(){
		return this.personid;
	}
	
	public void setRiqi(String riqi){
		this.riqi = riqi;
	}
	
	public String getRiqi(){
		return this.riqi;
	}
	
	
	public void setMtime(String mtime){
		this.mtime = mtime;
	}
	
	public String getMtime(){
		return this.mtime;
	}
	
	
	public void setXt(String xt){
		this.xt = xt;
	}
	
	public String getXt(){
		return this.xt;
	}
	
	
	public void setXyss(String xy_ss){
		this.xy_ss = xy_ss;
	}
	
	public String getXyss(){
		return this.xy_ss;
	}
	
	public void setXysz(String xy_sz){
		this.xy_sz = xy_sz;
	}
	
	public String getXysz(){
		return this.xy_sz;
	}
	
	public void setXyxt(String xy_xt){
		this.xy_xt = xy_xt;
	}
	
	public String getXyxt(){
		return this.xy_xt;
	}
	
	public void setIssave(boolean issave){
		this.issave = issave;
	}
	
	public boolean getIssave(){
		return this.issave;
	}
	
	
}
