package com.coboo.doctorstation;

import java.util.*;

public class Func_String1
{

	public static String ISOToGBK(String str)
	{
		try
		{
			return new String(str.getBytes("ISO-8859-1"),"utf-8").trim();
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	public static boolean isNotNullAndEmpty(String str)
	{
		return !(str==null||str.equals(""));
	}

	public static String decimal(String decimal)
	{
		String d = null;
		try
		{
			int dotIndex = decimal.indexOf('.');
			if(dotIndex==-1)
			{
				d = decimal + ".00";
			}
			else if(dotIndex==decimal.length()-1)
			{
				d = decimal + "00";
			}
			else
			{
				int len = decimal.substring(dotIndex+1).length();
				if(len==1)
				{
					d = decimal + "0";
				}
				else if(len==2)
				{
					d = decimal;
				}
				else if(len>2)
				{
					d = decimal.substring(0,dotIndex+3);
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return d;
	}

	public static int getMonth(String month)
	{
		int nmonth = 0;
		if(month.equals("һ�·�"))
			nmonth = 1;
		else if(month.equals("���·�"))
			nmonth = 2;
		else if(month.equals("���·�"))
			nmonth = 3;
		else if(month.equals("���·�"))
			nmonth = 4;
		else if(month.equals("���·�"))
			nmonth = 5;
		else if(month.equals("���·�"))
			nmonth = 6;
		else if(month.equals("���·�"))
			nmonth = 7;
		else if(month.equals("���·�"))
			nmonth = 8;
		else if(month.equals("���·�"))
			nmonth = 9;
		else if(month.equals("ʮ�·�"))
			nmonth = 10;
		else if(month.equals("ʮһ�·�"))
			nmonth = 11;
		else if(month.equals("ʮ���·�"))
			nmonth = 12;
		
		return nmonth;
	}

	public static String getQueryYearAndMonth(String month,boolean last)
	{
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		
		int nmonth = getMonth(month);
		if(last)
		{
			nmonth -= 1;
			if(nmonth==0)
			{
				nmonth = 12;
				y -=1;
			}
		}
		month = String.valueOf(nmonth);
		if(month.length()==1)
			month = "0"+month;
		
		return y + "-" + month + "%" ;
	}
	
	public static void main(String[]args)
	{
		System.out.println(getQueryYearAndMonth("һ�·�",true));
	}
}
