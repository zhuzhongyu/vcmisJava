package com.coboo.doctorstation;

import java.util.ArrayList;

public class BeanForStat {
	private int id;
	private String name;
	private ArrayList<NumsBean> list_res = new ArrayList<NumsBean>();
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setNums(ArrayList<NumsBean> list_res){
		this.list_res = list_res;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ArrayList<NumsBean> getNums(){
		return this.list_res;
	}
}
