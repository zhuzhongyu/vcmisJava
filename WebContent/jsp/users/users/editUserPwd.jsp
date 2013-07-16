<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.coboo.userRights.UserOper;"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	out.println("<users>");
	String name = request.getParameter("name");
	String password=request.getParameter("pwd");
	String hql_where="name='"+name+"'";
	int num=0;
	num= UserOper.UpdatePwd(password,hql_where);
	
	out.println("<user>");
	out.println("<size>"+num+"</size>");	
	out.println("</user>");
	out.println("</users>");
%>