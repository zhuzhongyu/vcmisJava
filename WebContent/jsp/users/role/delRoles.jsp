<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*,com.coboo.base.*,com.coboo.base.db.DB_Community" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String right = request.getParameter("right");
	
	HibernateDBManager db = new HibernateDBManager();
	Roles role = new Roles();
	role.setRoleid(Integer.valueOf(id));
	role.setName(name);
	role.setDescription(desc);
	role.setRoleRight(right);
	
	db.open();	
	int ret = db.delete(role);
	db.commit();
	db.close();
	
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
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
