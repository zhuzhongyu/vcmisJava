package com.coboo.insert;

import org.hibernate.HibernateException;
import com.common.HibernateDBManager;
import com.datebase.Community;
import com.coboo.base.Bean_BaseInfo;
import com.coboo.base.db.DB_Community;

public class AddComm {
	
	public boolean insert(String nameOfCommunity,String nameOfFzr,String phoneOfFzr){
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		
		Community community = new Community();
		community.setNameOfCommunity(nameOfCommunity);
		community.setNameOfFzr(nameOfFzr);
		community.setPhoneOfFzr(phoneOfFzr);
		community.setIsglzx(Integer.valueOf(0));
		community.setXy("");
		community.setAddress("");
		community.setMemo("");
		try {
			hdbm.insert(community);
			hdbm.commit();			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally{
			hdbm.close();
		}
		Bean_BaseInfo.list_comm = DB_Community.communtiyList(-1,null);
		return true;
	}
}
