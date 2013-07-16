<%@ page language="java" import="java.util.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@page import="com.common.HibernateDBManager;"%>
<%
	//---修改用户信息------------------------------------------
	
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String id = request.getParameter("id");
	String loginName = request.getParameter("loginName");
	String pwd = request.getParameter("pwd");
	String roadId = request.getParameter("roadId");
	String userName = request.getParameter("userName");
	String sex = request.getParameter("sex");
	String phone = request.getParameter("phone");
	String mail = request.getParameter("mail");
	String orgaId = request.getParameter("orgaId");
	String memo = request.getParameter("orgaNum");
	
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	
	ArrayList<Users> list_users = (ArrayList<Users>)db.query("from Users where id="+id);
	ArrayList<Community> list_groups = (ArrayList<Community>)db.query("from Community where id="+orgaId);
	ArrayList<Roles> list_roles = (ArrayList<Roles>)db.query("from Roles where roleid="+roadId);
	
	Users user = list_users.get(0);
	user.setName(loginName);
	user.setPwd(pwd);
	user.setChName(userName);
	user.setSex(sex);
	user.setPhone(phone);
	user.setEmail(mail);
	user.setRoles(list_roles.get(0));
	user.setCommunity(list_groups.get(0));
	user.setMemo(memo);
	
	int ret = db.update(user);
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