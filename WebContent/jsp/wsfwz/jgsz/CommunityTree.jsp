<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.coboo.base.*,com.coboo.base.db.*" %>
<%@ page import="com.common.*,java.util.*"%>


<%
//---机构列表---关宏宇
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	String commid=request.getParameter("commid");
	String userlev=request.getParameter("userlev");
	DB_Community dao=new DB_Community();
	StringBuffer sb=new StringBuffer(); //用户传递数据的字符流
	ArrayList<Community> list_comm = new ArrayList<Community>();
	ArrayList<Community> temp_comm;
	int comm_id=Integer.parseInt(commid);
	sb.append("<node>");
	//out.println("<node>");
	if(userlev.equals("city")){
		//if(comm_id<2){
		//	comm_id=2;
		//}
		Community community=dao.getCommunityById(Integer.valueOf(comm_id));
		sb.append("<node name='"+community.getNameOfCommunity()+"' commid='"+community.getId()+"' >");
		list_comm=dao.findCommListByGlzxID(Integer.parseInt(commid));
		for(int i=0;i<list_comm.size();i++){
			
			Community comm = list_comm.get(i);
			sb.append("<node name='"+comm.getNameOfCommunity()+"' commid='"+comm.getId()+"' type='District' >");
			temp_comm=new ArrayList<Community>();
			temp_comm=dao.findCommListByGlzxID(comm.getId());
			
			for(int j=0;j<temp_comm.size();j++){
				Community tmpcom=temp_comm.get(j);
				sb.append("<node name='"+tmpcom.getNameOfCommunity()+"' commid='"+tmpcom.getId()+"' type='Community' ISGLZX='"+comm.getNameOfCommunity()+"' />");
			}
			sb.append("</node>");
		}
		
		sb.append("</node>");
		
	}
	else if(userlev.equals("qu")){
		
		Community community=dao.getCommunityById(Integer.valueOf(1));
		sb.append("<node name='"+community.getNameOfCommunity()+"' commid='"+community.getId()+"'>");
			Community comm=dao.getCommunityById(Integer.valueOf(comm_id));
			sb.append("<node name='"+comm.getNameOfCommunity()+"' commid='"+comm.getId()+"' type='District'>");
				temp_comm=new ArrayList<Community>();
				temp_comm=dao.findCommListByGlzxID(comm.getId());
				for(int j=0;j<temp_comm.size();j++){
					Community tmpcom=temp_comm.get(j);
					sb.append("<node name='"+tmpcom.getNameOfCommunity()+"' commid='"+tmpcom.getId()+"' type='Community' ISGLZX='"+comm.getNameOfCommunity()+"' />");
				}
			sb.append("</node>");
		sb.append("</node>");
		
	}
	else if(userlev.equals("community")){
		Community community=dao.getCommunityById(Integer.valueOf(1));
		sb.append("<node name='"+community.getNameOfCommunity()+"' commid='"+community.getId()+"'>");
		Community tmpcom=dao.getCommunityById(Integer.valueOf(comm_id));
		Community comm= dao.getCommunityById(tmpcom.getIsglzx());
		sb.append("<node name='"+comm.getNameOfCommunity()+"' commid='"+comm.getId()+"' type='District'> ");
		sb.append("<node name='"+tmpcom.getNameOfCommunity()+"' commid='"+tmpcom.getId()+"' type='Community' ISGLZX='"+comm.getNameOfCommunity()+"'  />");
		sb.append("</node>");
		sb.append("</node>");
		
	}
	sb.append("</node>");
	System.out.println(sb.toString());
	out.println(sb.toString());
%>