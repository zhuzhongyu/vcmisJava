<%@ page language="java" import="java.util.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@page import="com.common.HibernateDBManager;"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	out.println("<data>");
	
	String commid = request.getParameter("commid");
	String userlev = request.getParameter("userlev");
	System.out.println("用户级别"+userlev);
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	
	Community groups = new Community();
	String hql_groups = "from Community where 1=1";
	if(userlev != null && !userlev.equals("")){
		if(userlev.equals("city")){
			hql_groups += " and arealev='city' or arealev='qu' or id="+commid+" or isglzx="+commid;
		}else
		if(userlev.equals("qu")){
			hql_groups += " and id="+commid+" or isglzx="+commid;
		}else
		if(userlev.equals("community")){
			hql_groups += " and id="+commid;
		}
	}
	
	System.out.println(hql_groups);
	ArrayList<Community> list_groups = (ArrayList<Community>) db.query(hql_groups);

    Roles role = new Roles();
    String hql_roles="";
    if(userlev.equals("qu")||userlev.equals("community")){
    	hql_roles = "from Roles where roleid not in (1)";
    }else{
		hql_roles = "from Roles";
	}
	ArrayList<Roles> list_roles = (ArrayList<Roles>) db.query(hql_roles);


	for(int i = 0;i<list_groups.size();i++){
		groups = (Community) list_groups.get(i);
	    out.println("<comm>");
		out.println("<id>" + groups.getId() + "</id>");
		out.println("<name>" + groups.getNameOfCommunity() + "</name>");
		out.println("<description>" + groups.getMemo() + "</description>");
		out.println("<arealev>" + groups.getArealev() + "</arealev>");
	    out.println("</comm>");
    }
	for(int i = 0;i<list_roles.size();i++){
		role = (Roles) list_roles.get(i);
	    out.println("<role>");
		out.println("<id>" + role.getRoleid() + "</id>");
		out.println("<name>" + role.getName() + "</name>");
		out.println("<description>" + role.getDescription() + "</description>");
	    out.println("</role>");
    }
    
    
	out.println("</data>");
	db.commit();
	db.close();
%>