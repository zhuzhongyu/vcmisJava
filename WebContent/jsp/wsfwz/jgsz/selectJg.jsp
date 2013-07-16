<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*" pageEncoding="UTF-8"%>

<%
	/*
	 * 组织机构树  
	 * 王立炜
	 */
  response.setContentType("text/xml");
  String orgaNum = request.getParameter("orgaNum");
  
  StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
  String hql = "from Community c ";
 
  if(orgaNum != null && !orgaNum.equals(""))
  {
		hql += " where c.dirNum like '" +orgaNum + "%'";
	}
  
  ArrayList<Community> list_comm = (ArrayList<Community>) Common.select(hql);
  
  sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  sb.append("<datas>");
	for(int i = 0; i< list_comm.size(); i++)
	{
		  Community commList = list_comm.get(i);
		  sb.append("<data>");
		  sb.append("<id>" + commList.getId().toString() + "</id>");
		  sb.append("<orgaName>" + commList.getNameOfCommunity() + "</orgaName>");
  		sb.append("<leader>" + commList.getNameOfFzr() + "</leader>");
      sb.append("<phone>" + commList.getPhoneOfFzr() + "</phone>");        
      sb.append("<memo>" + commList.getMemo() + "</memo>");
      sb.append("<address>" + commList.getAddress() + "</address>");
      sb.append("<orgaNum>" + commList.getDirNum() + "</orgaNum>");
      sb.append("<parent>" + commList.getArealev() + "</parent>");
    
      String commHql = "from CommunityRegion where orgaId = " + commList.getId().toString();
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
      sb.append("<xzqy>" + xz + "</xzqy>");
      sb.append("<xy>" + commList.getXy() + "</xy>");  
      sb.append("<parentName>" + commList.getParentName() + "</parentName>");    
      sb.append("</data>");                                                      
	}
	sb.append("</datas>");
	out.println(sb.toString());	
	Common.close();
%>