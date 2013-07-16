package com.coboo.base.db;

import com.coboo.base.Func_String;
import java.util.Iterator;
import com.coboo.base.OutString;

public class DB_Cq 
{
	@SuppressWarnings("unchecked")
	public static Integer getPopulationOfArea(String city,String district,String community)
	{
		int total = 0;
		
		HibernateDBManager db = new HibernateDBManager();
		
		if(Func_String.isNotNullAndEmpty(community))
		{
			int ncommunity = DB_Community.getIdOfCommunityByName(community);
			db.open();
			String hql = "select c.bqrks from Cq as c where c.sssq = "+ncommunity;
			Iterator<Integer> i = db.complexQuery(hql);
			if(i.hasNext())
			{
				total = (Integer)i.next();
			}
		}
		else
		{
			if(Func_String.isNotNullAndEmpty(district))
			{
				int ndistrict = DB_Community.getIdOfCommunityByName(district);
				db.open();
				String hql = "select c.bqrks from Cq as c where c.sssq = "+ndistrict;
				Iterator<Integer> i = db.complexQuery(hql);
				if(i.hasNext())
				{
					total = (Integer)i.next();
				}
			}
			else
			{
				int ncity = DB_Community.getIdOfCommunityByName(city);
				db.open();
				String hql = "select c.bqrks from Cq as c where c.sssq = "+ncity;
				Iterator<Integer> i = db.complexQuery(hql);
				if(i.hasNext())
				{
					total = (Integer)i.next();
				}
			}
		}
		db.commit();
		db.close();
		
		OutString.out("本辖区人口："+total);
		
		return total;
	}
	/**本辖区户口
	 * 作者：王振东
	 * 最后修改人：王振东
	 * @param city
	 * @param district
	 * @param community
	 * return 本辖区户口
	 */
	@SuppressWarnings("unchecked")
	public static Integer getFamilyNumOfArea(String city,String district,String community)
	{
		int total = 0;
		
		HibernateDBManager db = new HibernateDBManager();
		
		if(Func_String.isNotNullAndEmpty(community))
		{
			int ncommunity = DB_Community.getIdOfCommunityByName(community);
			db.open();
			String hql = "select c.bqhks from Cq as c where c.sssq = "+ncommunity;
			Iterator<Integer> i = db.complexQuery(hql);
			if(i.hasNext())
			{
				total = (Integer)i.next();
			}
		}
		else
		{
			if(Func_String.isNotNullAndEmpty(district))
			{
				int ndistrict = DB_Community.getIdOfCommunityByName(district);
				db.open();
				String hql = "select c.bqhks from Cq as c where c.sssq = "+ndistrict;
				Iterator<Integer> i = db.complexQuery(hql);
				if(i.hasNext())
				{
					total = (Integer)i.next();
				}
			}
			else
			{
				int ncity = DB_Community.getIdOfCommunityByName(city);
				db.open();
				String hql = "select c.bqhks from Cq as c where c.sssq = "+ncity;
				Iterator<Integer> i = db.complexQuery(hql);
				if(i.hasNext())
				{
					total = (Integer)i.next();
				}
			}
		}
		db.commit();
		db.close();
		
		OutString.out("本辖区户口："+total);
		
		return total;
	}
}
