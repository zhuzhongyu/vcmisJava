package com.coboo.base.db;

import java.util.ArrayList;
import com.datebase.Community;
import com.coboo.base.Func_String;
import com.coboo.base.Bean_BaseInfo;

public class DB_Community 
{
	/**
	 * 区列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> districtList()
	{
		String hql = "from Community as c where c.arealev = '"+Bean_BaseInfo.DISTRICT+"' order by c.id";
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		
		return com;
	}
	
	/**
	 * 区、社区列表
	 * @param districtId
	 * @param communityName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> communtiyListAll()
	{
		String hql = "from Community as c order by c.id";
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		
		return com;
	}
	
	/**
	 * 区列表
	 * @param cityId
	 * @param districtName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> districtListId(int cityId,String districtName)
	{
		String hql = "from Community as c where c.arealev = '"+Bean_BaseInfo.DISTRICT+"' and c.isglzx = "+cityId;
		
		if(Func_String.isNotNullAndEmpty(districtName))
		{
			hql += " and c.nameOfCommunity = '"+districtName+"'";
		}
		
		hql += " order by c.id"; 
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		
		return com;
	}
	
	/**
	 * 社区列表
	 * @param districtId
	 * @param communityName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> communtiyList(int districtId,String communityName)
	{
		String hql = "from Community as c where c.arealev = '"+Bean_BaseInfo.COMMUNITY+"' and c.isglzx = "+districtId;
		
		if(Func_String.isNotNullAndEmpty(communityName))
		{
			hql += " and c.nameOfCommunity = '"+communityName+"'";
		}
		
		hql += " order by c.id"; 
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		
		return com;
	}

	/**
	 * 录入统计表中区为空时调用此函数社区列表
	 * @param 
	 * @param communityName
	 * 作者：王振东
	 * 最后修改人：王振东
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> communtiyListNoDid(String communityName)
	{
		    String hql = "from Community as c where c.arealev = '"+Bean_BaseInfo.COMMUNITY+"'";
			
			if(Func_String.isNotNullAndEmpty(communityName))
			{
				hql += " and c.nameOfCommunity = '"+communityName+"'";
			}
			
			hql += " order by c.id"; 
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		return com;
	}
	/**
	 * 录入统计表中疾病详细信息页面调用此函数获取所有的社区列表
	 * @param 
	 * @param communityName
	 * 作者：王振东
	 * 最后修改人：王振东
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> communtiyListNoDidAll()
	{
		    String hql = "from Community as c where c.arealev = '"+Bean_BaseInfo.COMMUNITY+"'";		
			hql += " order by c.id"; 
		
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		return com;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Community> getWsfwzList()
	{
		String hql = "from Community as c where c.isglzx=1 and c.nameOfCommunity is not null and c.nameOfCommunity!='' order by c.id";
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		
		return com;
	}
	
	public static Community getCommunityById(Integer id)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		Community com = (Community)db.getObjectById(Community.class, id);
		db.commit();
		db.close();
		
		return com;
	}
	
	/**
	 * 
	 * 从内存中读取id对应的社区。
	 * @param id 社区id
	 * @return Cmmunity
	 */
	public static Community getCommunityByIdInMem(Integer id)
	{
		ArrayList<Community> list_comm = Bean_BaseInfo.list_comm;
		Community com = null;
		for(int i=list_comm.size();i>0;i--){
			com = list_comm.get(i-1);
			if(com.getId().intValue() == id.intValue()){
				break;
			}
		}
		return com;
	}

	/**根据登陆用户机构编号递归查询其下级机构编号
	 * @param commid 登陆用户的机构编号
	 * @param sb 储存机构编号的字符流
	 * 编写人：关宏宇 2010年8月11日
	 * 最后修改人：关宏宇 2010年8月11日
	 */

	public static void findListByid(Integer commid,StringBuffer sb,Boolean bool){
		String hql="from Community as c where c.isglzx="+commid;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com=(ArrayList<Community>)db.query(hql);
		if(com!=null){
			for(int i=0;i<com.size();i++){
				sb.append(""+com.get(i).getId()+",");
				if(bool==false){
					findListByid(com.get(i).getId(),sb,bool);
				}
			}
		}
	}
	
	public static ArrayList<ArrayList> findArrayByid(Integer commid,Boolean bool){
		ArrayList<ArrayList> arr=new ArrayList<ArrayList>();
		String hql="from Community as c where c.isglzx="+commid;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com=(ArrayList<Community>)db.query(hql);
		if(com!=null){
			arr.add(com);
			for(int i=0;i<com.size();i++){
				
				if(bool==false){
					findArrayByid(com.get(i).getId(),bool);
				}
			}
		}
		return arr;
	}
	
	public static ArrayList<Community> findCommListByGlzxID(Integer commid){
		
		String hql="from Community as c where c.isglzx="+commid;
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> com=(ArrayList<Community>)db.query(hql);
	
		return com;
	}
	
	@SuppressWarnings("unchecked")
	public static Integer getIdOfCommunityByName(String name)
	{
		String hql = "from Community as c where c.nameOfCommunity = '"+name+"'";
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		ArrayList<Community> list_com = (ArrayList<Community>)db.query(hql);
		db.commit();
		db.close();
		
		if(list_com!=null&&list_com.size()>0)
		{
			Community com = list_com.get(0);
			return com.getId();
		}
		
		return -1;
	}
	
	public static void communityUpdate(Community c)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		db.update(c);
		db.commit();
		db.close();
	}
}
