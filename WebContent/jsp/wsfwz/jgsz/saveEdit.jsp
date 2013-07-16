<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*,com.coboo.base.*,com.coboo.base.db.DB_Community" pageEncoding="UTF-8"%>
<%
//---修改机构---柴振兴
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String id = request.getParameter("id");
	String nameOfCommunity = request.getParameter("nameOfCommunity");
	String nameOfFzr = request.getParameter("nameOfFzr");
	String phoneOfFzr = request.getParameter("phoneOfFzr");
	String xy = request.getParameter("xy");
	String address = request.getParameter("address");
	String memo = request.getParameter("memo");
	String arealev = request.getParameter("arealev");
	String dirNum = request.getParameter("dirNum");
	String xz = request.getParameter("xz");
	
	HibernateDBManager db = new HibernateDBManager();
	
	db.open();	
	ArrayList<Community> list_community = (ArrayList<Community>)db.query("from Community where id="+id);
	System.out.println("id = " + id);
	Community commList = list_community.get(0);
	commList.setNameOfCommunity(nameOfCommunity);
	commList.setNameOfFzr(nameOfFzr);
	commList.setPhoneOfFzr(phoneOfFzr);
	commList.setXy(xy);
	commList.setAddress(address);
	commList.setMemo(memo);
	commList.setDirNum(dirNum);
	commList.setXzqy(xz);
	commList.setArealev(arealev);
	
	int ret = db.update(commList);
	db.commit();
	db.close();
	
	if (ret == 1) {
		out.println("<jbxx>");
		out.println("<size>" + 1 + "</size>");
		out.println("</jbxx>");
	} else {
		out.println("<jbxx>");
		out.println("<size>" + 0 + "</size>");
		out.println("</jbxx>");
	}
%>