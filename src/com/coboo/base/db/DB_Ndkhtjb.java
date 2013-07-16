package com.coboo.base.db;

import java.util.ArrayList;
import java.util.Iterator;
import com.datebase.Ndkhtjb;

public class DB_Ndkhtjb {
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhtjb> getAllNdkhtjbListByKHTIME(String KHTIME){
		String hql = "from Ndkhtjb as n where n.khtime = "+KHTIME;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhtjb> Klist = (ArrayList<Ndkhtjb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhtjb> getNdkhtjbListByTypeID(Integer id){
		String hql = "from Ndkhtjb as n where n.id = "+id;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhtjb> Klist = (ArrayList<Ndkhtjb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhtjb> getNdkhtjbListByAll(Integer khxmid,Integer commid , String time){
		String hql = "from Ndkhtjb as n where n.khxmid = "+khxmid+"and n.commid="+commid +" and n.khtime="+time;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhtjb> Klist = (ArrayList<Ndkhtjb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhtjb> getNdkhtjbListByCommidAndKhtime(Integer commid,String khtime){
		String hql = "from Sqndkhtjb as n where n.commid = "+commid+" and n.khtime like '"+khtime+"'";
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhtjb> Klist = (ArrayList<Ndkhtjb>)db.query(hql);
		db.commit();
		db.close();
		return Klist;
	}
	public static Ndkhtjb getNdkhtjbById(Integer id)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		Ndkhtjb ndkhtjb = (Ndkhtjb)db.getObjectById(Ndkhtjb.class, id);
		db.commit();
		db.close();
		return ndkhtjb;
	}
	public static void SqndkhdfInsert(Ndkhtjb pro)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.insert(pro);
		db.commit();
		db.close();
	}
	public static void NdkhdfUpdate(Integer id,Integer KHZF,Integer SDZF, double KHBL,double YFJF,double SFJF ,Integer STATE,String KHTIME,String BZ)
	{
		Ndkhtjb ndkhtjb=getNdkhtjbById(id);
		ndkhtjb.setKhzf(KHZF);
		ndkhtjb.setSdzf(SDZF);
		ndkhtjb.setKhbl(KHBL);
		ndkhtjb.setYfjf(YFJF);
		ndkhtjb.setSfjf(SFJF);
		ndkhtjb.setState(STATE);
		ndkhtjb.setKhtime(KHTIME);
		ndkhtjb.setBz(BZ);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.update(ndkhtjb);
		db.commit();
		db.close();
	}
	
	public static void NdkhdfDelete(Integer id)
	{
		Ndkhtjb ndkh=getNdkhtjbById(id);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.delete(ndkh);
		db.commit();
		db.close();
	}
}
