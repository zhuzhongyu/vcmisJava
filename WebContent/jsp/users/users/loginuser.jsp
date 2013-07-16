<%@ page language="java" import="java.util.*, com.datebase.*, com.coboo.base.*,com.coboo.base.db.*" pageEncoding="UTF-8"%>
<%@page import="com.common.* "%>
<%
	response.setContentType("text/xml");

	String username = request.getParameter("username");
	String pwd = request.getParameter("userpwd");

	StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
	String hql = "from Users where name='" + username + "' and pwd='" + pwd + "'";
  
	ArrayList<Users> list = (ArrayList<Users>) Common.select(hql);
	sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	
	if(list.size() == 0)
	{
		sb.append("<user>");
		sb.append("<size>" + 0 + "</size>");
		sb.append("</user>");
	}
	else
	{
		Users users  = (Users) list.get(0);
		sb.append("<user>");
		sb.append("<id>" + users.getUserid() + "</id>");
		sb.append("<name>" + users.getName() + "</name>");
		sb.append("<chName>" + users.getChName() + "</chName>");
		sb.append("<pwd>" + users.getPwd() + "</pwd>");
		sb.append("<phone>" + users.getPhone()+ "</phone>");
		sb.append("<address>" + users.getAddress()+ "</address>");
		sb.append("<sex>" + users.getSex() + "</sex>");
		sb.append("<mail>" + users.getEmail()+ "</mail>");
		sb.append("<roleId>" + users.getRoles().getRoleid().toString() + "</roleId>");
		sb.append("<roleName>" + users.getRoles().getName() + "</roleName>");
		sb.append("<roleRight>" + users.getRoles().getRoleRight()+ "</roleRight>");
		sb.append("<orgaNum>" + users.getCommunity().getDirNum()+ "</orgaNum>");
		sb.append("<orgaParent>" + users.getCommunity().getArealev()+ "</orgaParent>");
		sb.append("<orgaName>" + users.getCommunity().getNameOfCommunity()+ "</orgaName>");

    String commHql = "from CommunityRegion where orgaId = " + users.getCommunity().getId().toString();
    ArrayList<CommunityRegion> list1 = (ArrayList<CommunityRegion>) Common.select(commHql);
    
    String xz = "";
    if(list1.size() > 0)
    {
        CommunityRegion c = (CommunityRegion)list1.get(0);
        xz = c.getRegionId();
        for(int j = 1; j< list1.size(); j++)
		    {
            CommunityRegion comm = (CommunityRegion)list1.get(j);
            xz = xz + ";" + comm.getRegionId();
        }
    }
    
		sb.append("<xzqyNum>" + xz+ "</xzqyNum>");
		sb.append("<size>" + 1 + "</size>");
	    sb.append("</user>");
	}
	
    out.println(sb.toString());	
	Common.close();
%>
