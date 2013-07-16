package com.coboo.doctorstation;

public class NumsBean {
	private String type;
	private int nums = 0;
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setNums(int nums){
		this.nums = nums;
	}
	
	public int getNums(){
		return this.nums;
	}
}
