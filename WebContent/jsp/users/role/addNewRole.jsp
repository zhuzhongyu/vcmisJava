<%@ page language="java" import="java.util.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@page import="com.common.HibernateDBManager"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String roleRight = request.getParameter("roleRight");
	
	Roles role = new Roles();
	role.setName(name);
	role.setDescription(desc);
	role.setRoleRight(roleRight);
	
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	int ret = db.insert(role);
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