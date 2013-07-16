<%@ page language="java" import="java.util.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@page import="com.common.HibernateDBManager;"%>
<%
	//---修改密码------------------------------------------
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	out.println("<users>");
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	HibernateDBManager db = new HibernateDBManager();
	db.open();
	
	ArrayList<Users> list_users = (ArrayList<Users>)db.query("from Users where id="+id);
	Users user = list_users.get(0);
	user.setPwd(pwd);
	
	db.update(user);
	db.commit();
	db.close();
	out.println("</users>");
	
%>