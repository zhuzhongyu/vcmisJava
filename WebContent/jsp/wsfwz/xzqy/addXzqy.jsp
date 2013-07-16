<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*,com.coboo.base.*,com.coboo.base.db.DB_Community" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String name = request.getParameter("name");
	String number = request.getParameter("number");
	String level = request.getParameter("level");
	String parent = request.getParameter("parent");
  String peoples = request.getParameter("peoples");
  String cityName = request.getParameter("cityName");
  
	Xzqy xzqy = new Xzqy();
	
	xzqy.setName(name);
	xzqy.setNumber(number);
	xzqy.setLevel(Integer.valueOf(level));
	xzqy.setParent(parent);
	xzqy.setPeoples(peoples);
  xzqy.setCityName(cityName);
  
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	int ret = db.insert(xzqy);
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
