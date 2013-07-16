<%@ page language="java" import="java.util.*,com.common.*,com.datebase.*" pageEncoding="UTF-8"%>

<%
  response.setContentType("text/xml");
  String number = request.getParameter("number");
  StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
  sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  sb.append("<datas>");
  
  String hql = "from Xzqy x ";
 
  if(number!= null && !number.equals(""))
  {
		String xzArr[] =  number.split(";");
		ArrayList<Xzqy> list1 ;
		
		for(int i=0; i<xzArr.length; i++)
		{
			hql = "from Xzqy where number like '" + xzArr[i] + "%'";
			list1 = (ArrayList<Xzqy>) Common.select(hql);
			for(int j = 0; j< list1.size(); j++)
			{
				Xzqy xzqy = list1.get(j);
				
				int rel = sb.indexOf("<number>" + xzqy.getNumber()+ "</number>");
				if(rel > 0) continue;
				
		  		sb.append("<data>");
		  		sb.append("<id>" + xzqy.getId().toString() + "</id>");
		  		sb.append("<name>" + xzqy.getName() + "</name>");
		  		sb.append("<number>" + xzqy.getNumber()+ "</number>");
		  		sb.append("<level>" + xzqy.getLevel().toString() + "</level>");
		  		sb.append("<parent>" + xzqy.getParent() + "</parent>");
          sb.append("<peoples>" + xzqy.getPeoples() + "</peoples>");
          sb.append("<cityName>" + xzqy.getCityName() + "</cityName>");
		  		sb.append("</data>");         
			}
		}
  	}
    else
    {
  		ArrayList<Xzqy> list = (ArrayList<Xzqy>) Common.select(hql);
		for(int i = 0; i< list.size(); i++)
		{
		  	Xzqy xzqy = list.get(i);
		  	sb.append("<data>");
		  	sb.append("<id>" + xzqy.getId().toString() + "</id>");
		  	sb.append("<name>" + xzqy.getName() + "</name>");
		  	sb.append("<number>" + xzqy.getNumber()+ "</number>");
		  	sb.append("<level>" + xzqy.getLevel().toString() + "</level>");
		  	sb.append("<parent>" + xzqy.getParent() + "</parent>");
        sb.append("<peoples>" + xzqy.getPeoples() + "</peoples>");
        sb.append("<cityName>" + xzqy.getCityName() + "</cityName>");
		  	sb.append("</data>");                                                     
		}
	}
	sb.append("</datas>");
	out.println(sb.toString());	
	Common.close();
%>