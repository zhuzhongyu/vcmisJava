package com.coboo.users;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import com.common.HibernateDBManager;
import com.datebase.Users;

public class UpdatePwd {
	@SuppressWarnings("unchecked")
	public boolean update(String id,String pwd){
		
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		
		Users user = new Users();
		String hql = "from Users u where u.userid="+id+"";
		ArrayList<Users> a = (ArrayList<Users>)hdbm.query(hql);
		user = (Users)a.get(0);
		hdbm.refresh(user);
		
		user.setPwd(pwd);
		
		try {
			hdbm.update(user);
			hdbm.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally{
			hdbm.close();
		}
		return true;
	}
}
