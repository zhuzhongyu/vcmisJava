package com.coboo.find;

import java.util.ArrayList;
import java.util.List;
import com.common.*;
import com.datebase.Community;
import com.datebase.CommunityRegion;

public class Communitydao {
	
  @SuppressWarnings("unchecked")
public static Community getcurrcom(String orgnum){
	 String hql = "from Community c where c.dirNum like '"+orgnum+"%'"; 
	 List<Community> list= (List<Community>)Common.select(hql);
	 Community org = new Community();
	 List<Community> childorgs = new ArrayList<Community>();
	 for(Community com : list){
		 if(com.getDirNum().equals(orgnum))
			 childorgs =getchildren(list,com.getDirNum());
		      com.setList(childorgs);
			  org = com;
		  
	 }
	  Common.close();
	  return org;
  }
  
  

private static List<Community> getchildren(List<Community> list, String parent) {
	// TODO Auto-generated method stub
	List<Community> children = new ArrayList<Community>();
	for(Community child:list){
		if(child.getArealev().equals(parent)){
			children.add(child);
			getchildren(list, child.getDirNum());
		}
	}
	return children;
}



@SuppressWarnings("unchecked")
public static List<CommunityRegion> getRegion(int orgId){
	String hql = "from CommunityRegion cr where cr.orgaId= "+orgId;
	List<CommunityRegion> list = (List<CommunityRegion>)Common.select(hql);
	return list;
}
  public static void main(String[] args){
	  Community list = Communitydao.getcurrcom("5309-001");
	  for(Community com:list.getList()){
		 
			  
			  System.out.println(com.getNameOfCommunity()+"***********");
			  
	  }
  }
}
