package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.datebase.HibernateSessionFactory;
/**
 * 保存 静态函数
 * 最后修改:
 * @author rp19840604 RP 任鹏
 */
public class Common {
	static Session session = null;
	static Query query = null;
	static Transaction tr = null;

	@SuppressWarnings("unchecked")
	public static List select(String hql) {
		session = HibernateSessionFactory.getSession();
		tr = session.beginTransaction();
		query = session.createQuery(hql);
		List list = query.list();
		tr.commit();
		return list;
	}
	
	public static void close(){
		session.clear();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public static boolean delete(String hql) {
		List list = Common.select(hql);
		session = HibernateSessionFactory.getSession();
		Object from = (Object) list.get(0);
		try {
			tr = session.beginTransaction();
			session.delete(from);
			tr.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return true;
	}
	
	public static String easyDateFormat (String format) {   
        Date today = new Date();   
        SimpleDateFormat formatter = new SimpleDateFormat(format);   
        String datenewformat = formatter.format(today);   
        return datenewformat;   
    }
	
	public static String getBirthdate (String personId) {  
		
		String birthdate;
		
		if (personId.trim().length() == 18) {
			birthdate = personId.substring(6, 10)+"-"+personId.substring(10, 12)+"-"+personId.substring(12, 14);
		} else {
			birthdate = "19"+personId.substring(6, 8)+"-"+personId.substring(8, 10)+"-"+personId.substring(10, 12);
		}
        return birthdate;
    }
	
	public static String getGender (String personId) {
		
		int temp = 0;
		
		if (personId.trim().length() == 18) {
			temp = new Integer(personId.substring(14, 17));
		} else {
			temp = new Integer(personId.substring(12, 15));
		} 
		
		String gender = temp%2 == 0 ? "2":"1";

        return gender;   
    }
	/**
	 * 根据身份证号得到年龄
	 * @param personId 身份证号
	 * @return int Age
	 * @author rp19840604 RP 任鹏
	 */
	public static int getAge (String personId) {
		int age = 0;
		Date date = new Date();
		if (personId.trim().length() == 18)
			age = Integer.parseInt(personId.substring(6, 10));
		else 
			age = 1900 + Integer.parseInt(personId.substring(6, 8));
		
		int currentYear = 1900 + date.getYear();//获取当前年
		
		age = currentYear - age;
		
		return age;
	}
}
