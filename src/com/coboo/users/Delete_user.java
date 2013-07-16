package com.coboo.users;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.common.HibernateDBManager;
import com.datebase.Users;

public class Delete_user {
	
	@SuppressWarnings("unchecked")
	public boolean delete(String id) {
		
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		String hql = "from Users u where u.id="+id;
		ArrayList<Users> a = (ArrayList<Users>)hdbm.query(hql);
		Users user = (Users)a.get(0);
		try {
			hdbm.delete(user);
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
