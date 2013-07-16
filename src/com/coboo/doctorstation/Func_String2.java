package com.coboo.doctorstation;

public class Func_String2 
{
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
	
	public static final String XML_HEADER_ = "<?xml version=\"1.0\" encoding=\"gbk\"?>";
	
	public static String reportPath = ""; 
	
	public static String ISOToUTF8(String str)
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
	
	public static String ISOToUTF8_(String str)
	{
		try
		{
			return str.trim();
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	public static boolean isNotNullAndEmpty(String str)
	{
		return (str==null||str.equals(""))?false:true;
	}
	
	public static String loc(String str)
	{
		if(str.charAt(str.length()-1)=='/')
		{
			return str;
		}
		
		return str+"/"; 
	}
	public static String UTF8TOGBK(String str)
	{
		try
		{
			return new String(str.getBytes("utf-8"),"ISO-8859-1").trim();
		}
		catch(Exception ex)
		{
			return null;
		}
	}
}


