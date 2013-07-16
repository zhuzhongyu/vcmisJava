package com.coboo.users;

import java.util.ArrayList;
import org.hibernate.HibernateException;

import com.coboo.base.Bean_BaseInfo;
import com.coboo.base.db.DB_Community;
import com.common.HibernateDBManager;
import com.datebase.Community;


public class UpdateComm {
	
	@SuppressWarnings("unchecked")
	public boolean update(String id,String name,String xy,String nameOfFzr,
			String phoneOfFzr,String address,String memo){
		
		HibernateDBManager hdbm = new HibernateDBManager();
		hdbm.open();
		
		Community community = new Community();
		String hql = "from Community c where c.id="+id+"";
		ArrayList<Community> a = (ArrayList<Community>)hdbm.query(hql);
		community = (Community)a.get(0);
		hdbm.refresh(community);
		
		community.setNameOfCommunity(name);
		community.setXy(xy);
		community.setNameOfFzr(nameOfFzr);
		community.setPhoneOfFzr(phoneOfFzr);
		community.setAddress(address);
		community.setMemo(memo);
		
		try {
			
			hdbm.update(community);
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
