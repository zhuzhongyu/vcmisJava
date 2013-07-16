<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.coboo.userRights.UserOper;"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String name = request.getParameter("name");
	
	UserOper.activate("name='"+name+"'");
	
	out.println("<activeuser>");
	out.println("<ok>ok</ok>");	
	out.println("</activeuser>");
%>