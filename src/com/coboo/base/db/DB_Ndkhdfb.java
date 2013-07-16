package com.coboo.base.db;

import java.util.ArrayList;
import java.util.Iterator;
import com.datebase.Ndkhdfb;

public class DB_Ndkhdfb {
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhdfb> getNdkhdfListByTypeID(Integer id){
		String hql = "from Ndkhdfb as n where n.id = "+id;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhdfb> Klist = (ArrayList<Ndkhdfb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhdfb> getNdkhdfListByAll(Integer zbid,Integer commid , String time){
		String hql = "from Ndkhdfb as n where n.zbid = "+zbid+"and n.commid="+commid +" and n.khtime="+time;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhdfb> Klist = (ArrayList<Ndkhdfb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhdfb> getNdkhbID(Integer commid,Integer zbid,String khtime){
		String hql = "from Ndkhdfb as n where n.commid = "+commid+"and n.zbid="+zbid +" and n.khtime="+khtime;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhdfb> Klist = (ArrayList<Ndkhdfb>)db.query(hql);
		db.commit();
		db.close();
		return Klist;
	}
	
	public static Long getNdkhfzByCommidAndTime(Integer commid,String KHTime){
		String sqlString = "select sum(sdfz) as SDFZ from Ndkhdfb where COMMID="+commid+" and KHTIME like '"+KHTime+"'";
		HibernateDBManager db = new HibernateDBManager();
		Long temp=null;
		try{
			db.open();
			Iterator<Long> iter=db.complexQuery(sqlString);
			if(iter!=null&&iter.hasNext()){
				temp = (Long)iter.next();

			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
	
	public static Ndkhdfb getNdkhdfById(Integer id)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		Ndkhdfb sqndkh = (Ndkhdfb)db.getObjectById(Ndkhdfb.class, id);
		db.commit();
		db.close();
		return sqndkh;
	}
	public static void NdkhdfInsert(Ndkhdfb pro)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.insert(pro);
		db.commit();
		db.close();
	}
	public static void NdkhdfUpdate(Integer id,Integer sdfz,String bz)
	{
		Ndkhdfb ndkh=getNdkhdfById(id);
		ndkh.setSdfz(sdfz);
		//ndkh.setBz(bz);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.update(ndkh);
		db.commit();
		db.close();
	}
	
	public static void NdkhdfDelete(Integer id)
	{
		Ndkhdfb ndkh=getNdkhdfById(id);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.delete(ndkh);
		db.commit();
		db.close();
	}
	
	
}
