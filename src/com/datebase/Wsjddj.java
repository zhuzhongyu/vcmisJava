package com.datebase;

import java.io.Serializable;
import java.util.ArrayList;

import com.common.Common;




/**
 * @author Administrator
 *
 */
public class Wsjddj implements Serializable
{ 
	private Integer id;
	private Integer mark;
	private String t_name;
	private String t_delator;
	private String t_starttime;
	private String statetime;
	private String t_content;
    private String sort;
    
    public Wsjddj(){};
    
    public Wsjddj(String t_name){
    	this.t_name = t_name;
    }
    
	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_delator() {
		return t_delator;
	}
	public void setT_delator(String t_delator) {
		this.t_delator = t_delator;
	}
	public String getT_starttime() {
		return t_starttime;
	}
	public void setT_starttime(String t_starttime) {
		this.t_starttime = t_starttime;
	}
	public String getStatetime() {
		return statetime;
	}
	public void setStatetime(String statetime) {
		this.statetime = statetime;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	
	
  public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

public static void main(String [] args){
	  
	  String hql = "from Wsjddj w where w.t_name like '卫生局' ";
	 
	  ArrayList<Wsjddj> list_comm = (ArrayList<Wsjddj>) Common.select(hql);
	  System.out.println(list_comm.get(0).getT_name());
	  System.out.println(list_comm.get(0).getSort());
	  System.out.println(list_comm.get(0).getT_starttime());
	  System.out.println(list_comm.get(0).getT_delator());
	  System.out.println(list_comm.get(0).getMark());
	  System.out.println(list_comm.get(0).getStatetime());
	  System.out.println(list_comm.get(0).getT_content());
	 
  }
	
	
}
