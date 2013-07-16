<%@ page language="java" import="java.util.*,com.coboo.base.db.HibernateDBManager " pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	
	String number = request.getParameter("number");

	String hql = "delete from Community where dirNum like '" + number + "%'";
  
	HibernateDBManager db = new HibernateDBManager();
	
	db.open();	
	int ret = db.deleteRows(hql);
  db.commit();
	db.close();
  
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	if (ret >0) {
		out.println("<jbxx>");
		out.println("<size>" + 1 + "</size>");
		out.println("</jbxx>");
	} else {
		out.println("<jbxx>");
		out.println("<size>" + 0 + "</size>");
		out.println("</jbxx>");
	}
%>