package com.coboo.insert;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.common.HibernateDBManager;
import com.datebase.Community;

public class Update_fwz {
	
	@SuppressWarnings("unchecked")
	public boolean update(String id, String shequname, String fzr, 
			String phone, String xy, String address, String memo) {
		
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		
		Community c = new Community();
		String hql = "from Community c where c.id="+id+"";
		ArrayList<Community> a = (ArrayList<Community>)hdbm.query(hql);
		c = (Community)a.get(0);
		hdbm.refresh(c);
		
		c.setNameOfCommunity(shequname);
		c.setNameOfFzr(fzr);
		c.setPhoneOfFzr(phone);
		c.setXy(xy);
		c.setAddress(address);
		c.setMemo(memo);
		try {
			hdbm.update(c);
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
