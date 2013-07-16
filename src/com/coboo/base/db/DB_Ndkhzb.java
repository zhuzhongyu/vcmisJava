package com.coboo.base.db;
import java.util.ArrayList;
import java.util.Iterator;


import com.datebase.Ndkhzb;;
public class DB_Ndkhzb {
	@SuppressWarnings("unchecked")
	public static ArrayList<Ndkhzb> getNdkhzbListByTypeID(Integer id){
		String hql = "from Ndkhzb as n where n.zblx = "+id;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhzb> Klist = (ArrayList<Ndkhzb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	public static ArrayList<Ndkhzb> getNdkhzbListByTypeIDAndCommidInString(Integer id,String str){
		String hql = "from Ndkhzb as n where n.zblx = "+id+" and zbid in ("+str+")";
		System.out.println(hql);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Ndkhzb> Klist = (ArrayList<Ndkhzb>)db.query(hql);
		db.commit();
		db.close();
		
		return Klist;
	}
	
	public static Long getNdKHZF(){
		String sqlString = "select sum(khfz) as KHZF from Ndkhzb";
		
		HibernateDBManager db = new HibernateDBManager();
		Long temp=null;
		try{
			db.open();
			Iterator<Long> iter=db.complexQuery(sqlString);
			while(iter.hasNext()){
				temp = (Long)iter.next();
				System.out.println(temp.toString());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return temp;
	}
	
	public static Ndkhzb getNdkhzbById(Integer id)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		Ndkhzb ndkhzb = (Ndkhzb)db.getObjectById(Ndkhzb.class, id);
		db.commit();
		db.close();
		return ndkhzb;
	}
	public static void NdkhzbInsert(Ndkhzb pro)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.insert(pro);
		db.commit();
		db.close();
	}
	public static void NdkhzbUpdate(Integer id,Integer zblx,String zbmc,String zbsm,String zbyq,String khff,Integer khfz)
	{
		Ndkhzb ndkh=getNdkhzbById(id);
		ndkh.setZblx(zblx);
		ndkh.setZbmc(zbmc);
		ndkh.setZbsm(zbsm);
		ndkh.setZbyq(zbyq);
		ndkh.setKhff(khff);
		ndkh.setKhfz(khfz);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.update(ndkh);
		db.commit();
		db.close();
	}
	
	public static void NdkhzbDelete(Integer id)
	{
		Ndkhzb ndkh=getNdkhzbById(id);
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.delete(ndkh);
		db.commit();
		db.close();
	}
}
