<%@ page language="java" import="java.util.*, com.common.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@page import="coboo.service.client.vcmisServiceEvaluation.Gxy;"%>

<%
	  response.setContentType("text/xml");
	  StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
  	 sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  	 sb.append("<datas>");
	
	String orgaNum=request.getParameter("orgaNum");
	String years=request.getParameter("years");
  
//	String hql = "from Community c  where c.dirNum like '" +orgaNum + "%'";
  
//  ArrayList<Community> list_comm = (ArrayList<Community>) Common.select(hql);
  
//	for(int i = 0; i< list_comm.size(); i++)
//	{
//	    Community comm = list_comm.get(i);
       
      Gxy gxy = new Gxy("*", years);
      String s = gxy.getTownshipSummary(orgaNum);
      sb.append(s);
//	}
	
	sb.append("</datas>");
	out.println(sb.toString());	

%>
