package com.coboo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateManager {
	/**
	 * 比较日期大小。
	 * @param s1 比较日期
	 * @param s2 参考日期
	 * @param FormatStr 日期格式如：yyyy-MM-dd hh:mm:ss
	 * @return 返回天数
	 */
	public static int compDate(String s1,String s2,String FormatStr){
		int day=0;
		SimpleDateFormat sf = new SimpleDateFormat(FormatStr);
		Date xxx1=new Date();
		Date xxx2=new Date();
		try {
			xxx1=sf.parse(s1);
			xxx2=sf.parse(s2);
			day = (int) ((xxx2.getTime() - xxx1.getTime()) / 3600 / 24 / 1000);
			System.out.println(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day;
	}
	
	public static String GetNowDate(String format){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String datenewformat = formatter.format(today);
        return datenewformat;
    }

	public static void main(String[] args) {
		Get_BeforType_Ago_Date(Calendar.MONTH, 1, "yyyy-MM-dd");
	}
	// 交谈中请勿轻信汇款、中奖信息，勿轻易拨打陌生电话。

	// 柴哥  16:28:47
	/**
	 * 根据FormatStr格式返回BeforType对应的BeforValue前的日期。
	 * @param BeforType Calendar.YEAR年、Calendar.MONTH月、Calendar.DATE日等。
	 * @param BeforValue 数值。
	 * @param FormatStr 格式样式，如："yyyy-MM-dd hh:mm:ss"。
	 * @return String的FormatStr样式的时间。
	 */
	public static String Get_BeforType_Ago_Date(int BeforType,int BeforValue,String FormatStr){
        Calendar ca = Calendar.getInstance();
        ca.add(BeforType, -BeforValue);
        SimpleDateFormat formatter = new SimpleDateFormat(FormatStr);
        String datenewformat = formatter.format(ca.getTime());
        System.out.println(datenewformat);
        return datenewformat;
    }

}
