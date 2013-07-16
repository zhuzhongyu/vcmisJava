package com.coboo.users;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.datebase.HibernateSessionFactory;

public class LoginUser 
{
	@SuppressWarnings("unchecked")
	public List getLoginUser(String username, String password) {
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		List list = null;

		tr = session.beginTransaction();
		String hql = "from Users m where m.name = ? and m.pwd = ?";
		
		try {
			Query query = session.createQuery(hql);
			query.setString(0, username);
			query.setString(1, password);
			list = query.list();
			tr.commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	session.close();
		}
		return list;
	}
}
