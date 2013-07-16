package com.coboo.insert;

import org.hibernate.HibernateException;

import com.common.HibernateDBManager;
import com.datebase.Community;

public class Insert_fwz {
	
	public boolean insert(Integer isglzx, String shequname, String fzr, String phone, 
			String xy, String address, String memo) {
		
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		
		Community c = new Community();
		c.setNameOfCommunity(shequname);
		c.setNameOfFzr(fzr);
		c.setPhoneOfFzr(phone);
		c.setXy(xy);
		c.setAddress(address);
		c.setMemo(memo);
		c.setIsglzx(isglzx);
		c.setArealev("community");
		try {
			hdbm.insert(c);
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
