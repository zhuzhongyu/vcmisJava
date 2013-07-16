<%@ page language="java" import="java.util.*,com.datebase.*,com.common.*,com.coboo.base.db.HibernateDBManager " pageEncoding="UTF-8"%>
<%
  	response.setContentType("text/xml");
 
  String id = request.getParameter("id");
	String name = request.getParameter("name");
	String fzr = request.getParameter("fzr");
	String phone = request.getParameter("phone");
	String xy = request.getParameter("xy");
	String xz = request.getParameter("xz");
	String address = request.getParameter("address");
	String memo = request.getParameter("memo");
	String dirNum = request.getParameter("dirNum");
	String arealev = request.getParameter("arealev");
	String parentName = request.getParameter("parentName");
      
  HibernateDBManager dbb = new HibernateDBManager();
	dbb.open();
 
 System.out.println("id=: " + id);
     
  String d = "delete from community_region where orgaId = " + id;
  dbb.deleteRows(d);
  dbb.commit();
	dbb.close();
  
  HibernateDBManager db = new HibernateDBManager();
	db.open();
                                
   String hql = "from Community c where c.id =" + id;                                
  
   ArrayList<Community> list = (ArrayList<Community>) Common.select(hql);
   
   Community comm = list.get(0);
	
	comm.setNameOfCommunity(name);
	comm.setNameOfFzr(fzr);
	comm.setPhoneOfFzr(phone);
	comm.setXy(xy);
	comm.setAddress(address);
	comm.setMemo(memo);
	comm.setArealev(arealev);
	comm.setDirNum(dirNum);
  comm.setParentName(parentName);

	db.update(comm);
  
  String xzArr[] =  xz.split(";");
		
	for(int i=0; i<xzArr.length; i++)
	{
        CommunityRegion cr = new CommunityRegion();
        cr.setOrgaId(Integer.valueOf(id));
        cr.setRegionId(xzArr[i]);
        db.insert(cr);
  }         
   
  db.commit();
	db.close();
  Common.close();

%>