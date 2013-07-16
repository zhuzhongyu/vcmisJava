<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*,com.coboo.base.*,com.coboo.base.db.DB_Community" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String desc = request.getParameter("desc");
	String roleRight = request.getParameter("roleRight");
	
	HibernateDBManager db = new HibernateDBManager();
	db.open();	
	ArrayList<Roles> list_community = (ArrayList<Roles>)db.query("from Roles where roleid="+id);
	
	Roles role = list_community.get(0);
	role.setName(name);
	role.setDescription(desc);
	role.setRoleRight(roleRight);
	
	int ret = db.update(role);
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