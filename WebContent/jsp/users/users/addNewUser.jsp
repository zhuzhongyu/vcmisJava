<%@ page language="java" import="java.util.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@page import="com.common.HibernateDBManager"%>
<%@page import="com.coboo.userRights.UserOper;"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String loginName = request.getParameter("loginName");
	String pwd = request.getParameter("pwd");
	String roadId = request.getParameter("roadId");
	String userName = request.getParameter("userName");
	String sex = request.getParameter("sex");
	String phone = request.getParameter("phone");
	String mail = request.getParameter("mail");
	String memo = request.getParameter("orgaNum");
	String orgaId = request.getParameter("orgaId");
	
	Users user = new Users();
	user.setName(loginName);
	user.setPwd(pwd);
	user.setChName(userName);
	user.setSex(sex);
	user.setPhone(phone);
	user.setEmail(mail);
	user.setMemo(memo);
	
	Roles role = new Roles();
	role.setRoleid(Integer.valueOf(roadId));
	user.setRoles(role);
	
	Community comm = new Community();
	comm.setId(Integer.valueOf(orgaId));
	user.setCommunity(comm);
	
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	int ret = db.insert(user);
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