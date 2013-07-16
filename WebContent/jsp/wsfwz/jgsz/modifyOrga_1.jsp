<%@ page language="java" import="java.util.*,com.datebase.*,com.common.*,com.coboo.base.db.HibernateDBManager " pageEncoding="UTF-8"%>
<%

	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
 
  String id = request.getParameter("id");
	String nameOfCommunity = request.getParameter("nameOfCommunity");
	String nameOfFzr = request.getParameter("nameOfFzr");
	String phoneOfFzr = request.getParameter("phoneOfFzr");
	String xy = request.getParameter("xy");
	String xz = request.getParameter("xz");
	String address = request.getParameter("address");
	String memo = request.getParameter("memo");
	String dirNum = request.getParameter("dirNum");
	String arealev = request.getParameter("arealev");
	String parentName = request.getParameter("parentName");
  
   HibernateDBManager db = new HibernateDBManager();
   HibernateDBManager dbb = new HibernateDBManager();
	 db.open();
   dbb.open();
    /*                                 
   String hql = "from Community c where c.id =" + id;                                
  
   ArrayList<Community> list = (ArrayList<Community>) Common.select(hql);
   
   Community comm = list.get(0);
	
	comm.setNameOfCommunity(nameOfCommunity);
	comm.setNameOfFzr(nameOfFzr);
	comm.setPhoneOfFzr(phoneOfFzr);
	comm.setXy(xy);
	comm.setAddress(address);
	comm.setMemo(memo);
	comm.setArealev(arealev);
	comm.setDirNum(dirNum);
  comm.setParentName(parentName);

	db.update(comm);
      */
  String d = "delete from CommunityRegion c where c.orgaId=" + id;
  db.deleteRows(d);
  db.commit();
	db.close();
  /*
  String xzArr[] =  xz.split(";");
		
	for(int i=0; i<xzArr.length; i++)
	{
        CommunityRegion cr = new CommunityRegion();
        cr.setOrgaId(Integer.valueOf(id));
        cr.setRegionId(xzArr[i]);
        dbb.insert(cr);
  }         
  
	dbb.commit();
  */
	dbb.close();
%>