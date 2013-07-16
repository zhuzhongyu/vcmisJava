package com.coboo.users;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.common.HibernateDBManager;
import com.datebase.Community;

public class Delete_comm {
	
	@SuppressWarnings("unchecked")
	public boolean delete(String id) {
		
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		
		String hql = "from Community c where c.id="+id;
		ArrayList<Community> a = (ArrayList<Community>)hdbm.query(hql);
		Community comm = (Community)a.get(0);
		try {
			hdbm.delete(comm);
			hdbm.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			hdbm.close();
		}
		return true;
	}
}
