package com.coboo.base;

public class Func_ISOtoUTF8 {
	public Func_ISOtoUTF8(){}
	
	public static String ISOtoUTF8(String str){
		String newStr=null;
		try{
			newStr = new String(str.getBytes("iso8859-1"),"UTF-8");

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return newStr;
	}
}
