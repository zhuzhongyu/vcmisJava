package com.coboo.yczh_xy;

import java.util.*;
import java.text.ParseException;
import java.text.DateFormat;    
import java.text.ParsePosition;    
import java.text.SimpleDateFormat;    


/**
 * 获取需要时间类
 * @author rp19840604 RP 任鹏
 */
public class Main {
	/**
	 * 获取当前年月日 yy-MM-dd格式
	 * @return String
	 * @author rp19840604 RP 任鹏
	 */
	public String getCurrentDate(){
		String temp = "";
		Calendar now = Calendar.getInstance();
		String currentYear = String.valueOf(now.get(Calendar.YEAR));
		String currentmonth = String.valueOf((now.get(Calendar.MONTH) + 1));
		String currentdate = String.valueOf(now.get(Calendar.DATE));
		if(currentdate.length() < 2)
			currentdate = "0" + currentdate;
		if(currentmonth.length() < 2)
			currentmonth = "0" + currentmonth;
		return temp = currentYear + "-" + currentmonth + "-" + currentdate;
	}
	/**
	 * 获取当前年和月 yy-MM
	 * @return String
	 * @author rp19840604 RP 任鹏
	 */
	public String getCurrentMonth(){
		String temp = "";
		Calendar now = Calendar.getInstance();
		String currentYear = String.valueOf(now.get(Calendar.YEAR));
		String currentmonth = String.valueOf((now.get(Calendar.MONTH) + 1));
		if(currentmonth.length() < 2)
			currentmonth = "0" + currentmonth;
		return temp = currentYear + "-" + currentmonth;
	}
	/**
	 * 获取当前时间七天或是十四天前(到今天)传七就是返回七天传十四就是返回十四天
	 * @param sevenOrfourteen 七或十四
	 * @return String(当前时间七天前或是十四天)
	 * @author rp19840604 RP 任鹏
	 */
	public String sevenOrfourteenDate(int sevenOrfourteen){
		String temp = "";
		Calendar now = Calendar.getInstance();
		now.add(now.DATE, -sevenOrfourteen);
		String year = String.valueOf(now.get(Calendar.YEAR));
		String month = String.valueOf((now.get(Calendar.MONTH) + 1));
		String date = String.valueOf(now.get(Calendar.DATE));
		if(date.length() < 2)
			date = "0" + date;
		if(month.length() < 2)
			month = "0" + month;
		return 	temp = year + "-" + month + "-" + date;
	}
	/**
	 * 获取三个月前年和月 yy-MM
	 * @return String
	 * @author rp19840604 RP 任鹏
	 */
	public String getThreeMonth(){
		String temp = "";
		Calendar now = Calendar.getInstance();
		String currentYear = String.valueOf(now.get(Calendar.YEAR));
		String currentmonth = String.valueOf((now.get(Calendar.MONTH) + 1 - 2));
		if(currentmonth.length() < 2)
			currentmonth = "0" + currentmonth;
		return temp = currentYear + "-" + currentmonth;
	}
	/**
	 * 获取下个月年和月 yy-MM
	 * @return String
	 * @author rp19840604 RP 任鹏
	 */
	public String getNextMonth(){
		String temp = "";
		Calendar now = Calendar.getInstance();
		String currentYear = String.valueOf(now.get(Calendar.YEAR));
		String currentmonth = String.valueOf((now.get(Calendar.MONTH) + 2));
		if(currentmonth.length() < 2)
			currentmonth = "0" + currentmonth;
		return temp = currentYear + "-" + currentmonth;
	}
	/**
	 * 得到当前年
	 */
	public String getCurrentYear(){
	
		Calendar now = Calendar.getInstance();
		String currentYear = String.valueOf(now.get(Calendar.YEAR));
	
		return currentYear ;
	}
	/**
	 * 得到上一年
	 * @return
	 */
	public String getLastYear(){
		String temp = "";
		Calendar now = Calendar.getInstance();
		String lastYear = String.valueOf((now.get(Calendar.YEAR)-1));
		return lastYear;
	}
	
	/**
	 * 得到两个日期相差几周
	 * @param start 起始日期
	 * @param end 截止日期
	 * @author 关宏宇 2010年9月21日 10:17
	 * 最后修改人：关宏宇
	 */
	public  int getWeeksOfTowRiqi(String start,String end) {
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd"); 
		Calendar   c   =   Calendar.getInstance(); 
		Calendar   d   =   Calendar.getInstance();
		int WeekNum=0;
		int DaysNum=0;
		try{
			Date d1 = (Date)format.parseObject(start); 
			Date d2 = (Date)format.parseObject(end); 
			c.setTime(d1); 
			d.setTime(d2);
			DaysNum=d.get(Calendar.DAY_OF_YEAR)-c.get(Calendar.DAY_OF_YEAR);
			if(DaysNum%7==0){
				WeekNum=(DaysNum/7);
			}
			else{
				WeekNum=((DaysNum/7)+1);
			}
		}catch(Exception ex) {ex.printStackTrace();}
		return WeekNum;
	}
	
	/**
	 * 得到两个日期相差几周
	 * @param start 起始日期
	 * @param end 截止日期
	 * @author 关宏宇 2010年9月21日 10:17
	 * 最后修改人：关宏宇
	 */
	public  int getDaysOfTowRiqi(String start,String end) {
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd"); 
		Calendar   c   =   Calendar.getInstance(); 
		Calendar   d   =   Calendar.getInstance();
		int DaysNum=0;
		try{
			Date d1 = (Date)format.parseObject(start); 
			Date d2 = (Date)format.parseObject(end); 
			c.setTime(d1); 
			d.setTime(d2);
	
			DaysNum=d.get(Calendar.DAY_OF_YEAR)-c.get(Calendar.DAY_OF_YEAR);
			DaysNum+=1;
		}catch(Exception ex) {ex.printStackTrace();}
		return DaysNum;
	}

	/**
	 * 得到上个月最后一天的日期
	 * @author 关宏宇 2010年9月25日 
	 *  最后修改人：关宏宇
	 */
	public String getPreviousMonthEnd(){    
		String str = "";    
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");        
			   
		Calendar lastDate = Calendar.getInstance();    
		lastDate.add(Calendar.MONTH,-1);//减一个月    
		lastDate.set(Calendar.DATE, 1);//把日期设置为当月第一天     
		lastDate.roll(Calendar.DATE, -1);//日期回滚一天，也就是本月最后一天     
		str=sdf.format(lastDate.getTime());   
		return str;  
		
	}
	/**
	 * 获取给定日期的几天之前的日期
	 * @param endDate 给定日期
	 * @param sevenOrfourteen 几天前的天数
	 * @author 关宏宇 2010年9月25日 
	 * 最后修改人：关宏宇
	 */
	public String getMyDate(String endDate,int sevenOrfourteen){
		
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd"); 
		Calendar   c   =   Calendar.getInstance(); 
		Calendar   d   =   Calendar.getInstance();
		String temp = "";
		String year = "";
		String month="";
		String date="";
		try{
			Date d1=(Date)format.parseObject(endDate);
			c.setTime(d1);
			
			int num=c.get(Calendar.DAY_OF_MONTH)-sevenOrfourteen;
			if(num>=1) {
				 month = String.valueOf((c.get(Calendar.MONTH) + 1));
				 date = String.valueOf(c.get(Calendar.DATE)-sevenOrfourteen);
				 year = String.valueOf(c.get(Calendar.YEAR));
			}
			else{
				if(c.get(Calendar.MONTH)>0){
					String lastMonthMax=getPreviousMonthEnd();
					Date d2=(Date)format.parseObject(lastMonthMax);
					d.setTime(d2);
					month = String.valueOf((d.get(Calendar.MONTH) + 1));
					date=String.valueOf(d.get(Calendar.DATE)+num);
					year = String.valueOf(d.get(Calendar.YEAR));
				}
				else{
					month=String.valueOf(12);
					date=String.valueOf(31+num);
					year=String.valueOf(d.get(Calendar.YEAR)-1);
				}
			}
			if(date.length() < 2)
				date = "0" + date;
			if(month.length() < 2)
				month = "0" + month;
			temp = year + "-" + month + "-" + date;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return 	temp;
	}


	
}


