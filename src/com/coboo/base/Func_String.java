package com.coboo.base;
/**
 * ������ַ处理和字符串的有关操作
 * @author ������
 *
 */
public class Func_String 
{
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	public static String ISOToUTF8(String str)
	{
		try
		{
			return new String(str.getBytes("ISO-8859-1"),"gbk").trim();
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
		return !(str==null||str.equals(""));
	}
}


