package com.coboo.find;

import java.util.ArrayList;

import com.common.HibernateDBManager;
import com.datebase.Community;

public class FindQuId {
	
	@SuppressWarnings("unchecked")
	public int getId(String qu)
	{
		Community c = new Community();
		
		HibernateDBManager hdbm = new HibernateDBManager();
		
		hdbm.open();

		String hql = "from Community c where c.nameOfCommunity='"+qu+"'";
		
		ArrayList<Community> list = (ArrayList<Community>) hdbm.query(hql);
		
		hdbm.commit();
		
		try {
			c = (Community) list.get(0);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			hdbm.close();
		}
		
		return c.getId();
	}
}
