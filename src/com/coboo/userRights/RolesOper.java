package com.coboo.userRights;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.datebase.HibernateSessionFactory;
import com.datebase.Roles;

public class RolesOper {
	public static boolean insertRole(String name,String description){
		
		Session session=HibernateSessionFactory.getSession();
		Roles roles = new Roles();
		Transaction tr=session.beginTransaction();
		try {
			roles.setName(name);
			roles.setDescription(description);
			
			session.save(roles);
			tr.commit();
			session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			tr.rollback();
			return false;
		}finally{
			session.close();
		}
		return true;
	}
	
	/**
	 * ɾ���ɫ��
	 * @param hql_where
	 */
	public static void delete(String hql_where){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();

		tr = session.beginTransaction();
		String hqlUpdate =  "delete from MedicineDiaobodan where "+hql_where;
		
		@SuppressWarnings("unused")
		int  updatedEntities = session.createQuery(hqlUpdate)
//		.setString( "newNum", nums_)
		.executeUpdate();
		tr.commit();
		session.close();
	}
}
