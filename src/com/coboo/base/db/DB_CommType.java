package com.coboo.base.db;
import java.util.ArrayList;
import java.util.Iterator;

import com.datebase.Ndkhzb;
import com.datebase.CommType;

public class DB_CommType {
	@SuppressWarnings("unchecked")
	public static String getzbidInStrByTypeID(Integer id){
		
		String inStr="";
		String hql = "from CommType as Ct where Ct.typeId = "+id;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<CommType> comm = (ArrayList<CommType>)db.query(hql);
		CommType com = comm.get(0);
		String[] arr=com.getTypeRight().split(";");
		for(int i =0 ; i<arr.length;i++) {
			if(i<arr.length-1){
				inStr += arr[i]+",";
			}else{
				inStr += arr[i];
			}
		}
		db.commit();
		db.close();

		return inStr;
	}
	
	public static void main(String[] args) {
		DB_CommType ct = new DB_CommType();
		ct.getzbidInStrByTypeID(Integer.valueOf(1));
	}
	
}
