<%@ page language="java" import="java.util.*,com.common.*, com.datebase.* ,coboo.config.*, coboo.service.*, coboo.document.* " pageEncoding="UTF-8"%>

<%!
	public int statRecord(String st)
	{
      XmlParser p = new XmlParser();
      String[] fieldNames = p.getKeys(st);
	    String[] fieldValues = p.getValues(st);
      int num =coboo.service.IService.statAnd(fieldNames,fieldValues);
      return num; 
	}

%>

<%
  response.setContentType("text/xml");                                                       
  String orgaId = request.getParameter("orgaId");
  
  int num = 0;
  
  StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
  sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  sb.append("<datas>");

  String hql = "from Users where community.id =" + orgaId;  
  
  ArrayList<Users> list = (ArrayList<Users>) Common.select(hql); 

   for(int i = 0; i < list.size(); i++)
   {
       Users user = list.get(i);
       String name = user.getName();
       String st = "<k><createrId>" + name + "</createrId></k>";
       num = statRecord(st);
       
       sb.append("<data>");
       sb.append("<user>" + name + "</user>");
       sb.append("<sum>" + String.valueOf(num) + "</sum>");
       sb.append("</data>");
    }
    sb.append("</datas>");
   out.println(sb.toString());	
   Common.close();        
%>
