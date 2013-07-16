<%@ page language="java"
	import="java.lang.*,coboo.config.*,coboo.service.*,coboo.document.XmlParser"
	pageEncoding="UTF-8"%>
<%
/** And 统计:统计条件之间是AND关系
从客户端获得keyXmlStr字符串，
keyXmlStr 格式：<k><gxy>true</gxy><tnb>false</tnb><zl>false</zl><gxb>false</gxb></k>
该字符串包含查询的字段和查询条件，查询得到的结果数量返回客户端**/
	  response.setContentType("text/xml");
   out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
   int[] number = new int[12];
   int length = 0;
   
   for(int i=0; i<12; i++)
  {
    String c = "c" + Integer.toString(i+1);
    String keyXmlStr = request.getParameter(c);
    
    if(keyXmlStr != null && !keyXmlStr.equals(""))
    {
    	XmlParser p = new XmlParser();
		  String[] fieldNames = p.getKeys(keyXmlStr);
		  String[] fieldValues = p.getValues(keyXmlStr);
		  number[i] = coboo.service.IService.statAnd(fieldNames,fieldValues);
      length++;
    }
    else
    	break;
  }
  
  out.println("<stat>");
  out.println("<length>" + length + "</length>");
  for(int i=0; i<length; i++)
  {
  	out.println("<n" + Integer.toString(i+1) + ">" + number[i] + "</n" + Integer.toString(i+1) + ">");
  }	
  out.println("</stat>");
%>