<%@ page language="java" import="java.util.*,com.datebase.*,com.coboo.userRights.*" pageEncoding="UTF-8"%>
<%@page import="com.common.*;"%>
<%
	response.setContentType("text/xml");

	StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
	String memo = request.getParameter("memo");
	String hql_users = "from Users u where u.memo like '" + memo + "%'";
	
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	
	ArrayList<Users> list = (ArrayList<Users>)db.query(hql_users);
	sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	sb.append("<datas>");
	for(int i = 0; i< list.size(); i++)
	{
		  Users user = list.get(i);
		  sb.append("<data>");
		  sb.append("<id>" + user.getUserid().toString() + "</id>");
		  sb.append("<name>" + user.getName() + "</name>");
		  sb.append("<chName>" + user.getChName() + "</chName>");
		  sb.append("<password>" + user.getPwd()+ "</password>");
		  sb.append("<phone>" + user.getPhone()+ "</phone>");
		  sb.append("<sex>" + user.getSex() + "</sex>");
			sb.append("<mail>" + user.getEmail()+ "</mail>");
		   sb.append("<address>" + user.getAddress()+ "</address>");
		   sb.append("<roleId>" + user.getRoles().getRoleid().toString() + "</roleId>");
		  sb.append("<roleName>" + user.getRoles().getName() + "</roleName>");
		  sb.append("<roleRight>" + user.getRoles().getRoleRight()+ "</roleRight>");
		  sb.append("<orgaId>" + user.getCommunity().getId().toString()+ "</orgaId>");
		  sb.append("<orgaNum>" + user.getCommunity().getDirNum()+ "</orgaNum>");
		  sb.append("<orgaName>" + user.getCommunity().getNameOfCommunity()+ "</orgaName>");
		  sb.append("</data>");                                                     
	}
	sb.append("</datas>");
	
    out.println(sb.toString());	
    db.close();
%>