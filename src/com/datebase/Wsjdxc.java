package com.datebase;
import java.io.Serializable;
import java.util.ArrayList;

import com.common.Common;

public class Wsjdxc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String year;
	private Integer mark;
	private String cattime;
	private String content;
	private String beizhu;
	private String problems;
	private String cater;

	public Wsjdxc() {

	}

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCattime() {
		return cattime;
	}

	public void setCattime(String cattime) {
		this.cattime = cattime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getProblems() {
		return problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

	public String getCater() {
		return cater;
	}

	public void setCater(String cater) {
		this.cater = cater;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	public static void main(String[] args){
		
		String hql = "from Wsjdxc wc where wc.name like '卫生局'and wc.year like '2011'  ";
		
		
		
		ArrayList<Wsjdxc> list_comm = (ArrayList<Wsjdxc>) Common.select(hql);
	}
	  
	
}
