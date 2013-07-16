<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*" pageEncoding="UTF-8"%>

<%
	response.setContentType("text/xml");
	StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
	
	String hql = "from Roles ";
  
  ArrayList<Roles> list = (ArrayList<Roles>) Common.select(hql);
  
  sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  sb.append("<datas>");
	for(int i = 0; i< list.size(); i++)
	{
		  Roles role = list.get(i);
		  sb.append("<data>");
		  sb.append("<id>" + role.getRoleid().toString() + "</id>");
		  sb.append("<name>" + role.getName() + "</name>");
		  sb.append("<desc>" + role.getDescription()+ "</desc>");
		  sb.append("<roleRight>" + role.getRoleRight()+ "</roleRight>");
		  sb.append("</data>");                                                     
	}
	sb.append("</datas>");
	out.println(sb.toString());	
	Common.close();
%>