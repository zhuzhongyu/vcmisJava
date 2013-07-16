package com.coboo.find;

import java.util.ArrayList;

import com.common.HibernateDBManager;
import com.datebase.Community;

public class BuildingManager {
	
	/**
	 * 根据commid得到一个城市的3级树结构。（第一个元素为市，第二个元素为区，第三个元素为社区）
	 * @param commid 市、区、社区id
	 * @param list_comm 城市内的所有的区与社区
	 * @return 一个城市的3级树结构。（第一个元素为市，第二个元素为区，第三个元素为社区）
	 */
	public static ArrayList<Community> GetCommunityTree(int commid,ArrayList<Community> list_comm){
		
		ArrayList<Community> list_tree = new ArrayList<Community>();
		
		Community temp = null;
		Community city = null;
		Community qu = null;
		Community comm = null;
		
		
		for(int i = 0;i<list_comm.size();i++){
			temp = list_comm.get(i);
			if(temp.getId().intValue() == commid){
				if(temp.getArealev().equals("city")){
					city = temp;
					for(int j=0;j<list_comm.size();j++){
						temp = list_comm.get(j);
						if(temp.getIsglzx().intValue() == city.getId().intValue()){
							qu = temp;
							break;
						}
						
					}
					for(int j=0;j<list_comm.size();j++){
						temp = list_comm.get(j);
						if(temp.getIsglzx().intValue() == qu.getId().intValue()){
							comm = temp;
							break;
						}
					}
				}else
				if(temp.getArealev().equals("qu")){
					qu = temp;
					for(int j=0;j<list_comm.size();j++){
						temp = list_comm.get(j);
						if(temp.getId().intValue() == qu.getIsglzx().intValue()){
							city = temp;
							break;
						}
						
					}
					for(int j=0;j<list_comm.size();j++){
						temp = list_comm.get(j);
						if(temp.getIsglzx().intValue() == qu.getId().intValue()){
							comm = temp;
							break;
						}
						
					}
				}else
				if(temp.getArealev().equals("community")){
					comm = temp;
					for(int j=0;j<list_comm.size();j++){
						temp = list_comm.get(j);
						if(temp.getId().intValue() == comm.getIsglzx().intValue()){
							qu = temp;
							break;
						}
						
					}
					for(int j=0;j<list_comm.size();j++){
						temp = list_comm.get(j);
						if(temp.getId().intValue() == qu.getIsglzx().intValue()){
							city = temp;
							break;
						}
						
					}
				}
				break;
			}
		}
		
		list_tree.add(city);
		list_tree.add(qu);
		list_tree.add(comm);
		
		return list_tree;
	}
	
	@SuppressWarnings("unchecked")
	public static Community GetCommunityByUpLevID(int commid){
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> list_comm1 = (ArrayList<Community>)db.query("from Community where isglzx="+commid);
		db.commit();
		db.close();
		if(list_comm1==null || list_comm1.size() == 0){
			return null;
		}
		return list_comm1.get(0);
	}
	@SuppressWarnings("unchecked")
	public static Community GetCommunityByID(int commid){
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> list_comm1 = (ArrayList<Community>)db.query("from Community where id="+commid);
		db.commit();
		db.close();
		if(list_comm1==null || list_comm1.size() == 0){
			return null;
		}
		return list_comm1.get(0);
	}
}
