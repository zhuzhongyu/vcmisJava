package com.coboo.find;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.common.HibernateDBManager;
import com.datebase.Community;

public class DeleteCommOper {

	@SuppressWarnings("unchecked")
	public boolean delete(String xy)
	{
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();

		Community comm = new Community();
		String hql = "from Community c where c.xy='"+xy+"'";
		ArrayList<Community> a = (ArrayList<Community>)hdbm.query(hql);
		comm = (Community)a.get(0);

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
