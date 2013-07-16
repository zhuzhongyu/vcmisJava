<%@ page language="java" import="java.util.*, com.datebase.*, com.coboo.base.db.*" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
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
  
	Community commList = new Community();
	
	commList.setNameOfCommunity(nameOfCommunity);
	commList.setNameOfFzr(nameOfFzr);
	commList.setPhoneOfFzr(phoneOfFzr);
	commList.setXy(xy);
	commList.setAddress(address);
	commList.setMemo(memo);
	commList.setArealev(arealev);
	commList.setDirNum(dirNum);
  commList.setParentName(parentName);
  
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	int ret = db.insert(commList);
              
  if(ret == 1)
  {
    String xzArr[] =  xz.split(";");
	 for(int i=0; i<xzArr.length; i++)
	 {
        CommunityRegion cr = new CommunityRegion();
        cr.setOrgaId(commList.getId());
        cr.setRegionId(xzArr[i]);
        ret = db.insert(cr);
    }
 }
  
	db.commit();
	db.close();
	
	if (ret == 1)
   {
		out.println("<jbxx>");
		out.println("<size>" + 1 + "</size>");
		out.println("</jbxx>");
	} else {
		out.println("<jbxx>");
		out.println("<size>" + 0 + "</size>");
		out.println("</jbxx>");
	}
  
%>