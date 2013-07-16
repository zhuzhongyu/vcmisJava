<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="coboo.service.client.vcmisServiceEvaluation.Gxy;"%>

<%
	response.setContentType("text/xml");
	 StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
  	 sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  	 sb.append("<datas>");
	
	String regionId=request.getParameter("regionId");
	String years=request.getParameter("years");
	
	String xzArr[] =  regionId.split(";");
	
	for(int i=0; i<xzArr.length; i++)
	{
	    String bh = xzArr[i];
	    String code = "";
		
	    String bhArr[] =  bh.split("-");
	    if(bhArr.length > 0)
            {
	       for(int j=0; j<bhArr.length; j++)
	       {
		  code = code + bhArr[j];
	       }
            }
	    else
	      code=bh;
        
	    code = code + "*";
	    System.out.println("code: " + code);
      Gxy gxy = new Gxy(code, years);
      String s = gxy.getBasicTable();
      sb.append(s);
	}
	
	sb.append("</datas>");
	out.println(sb.toString());	

%>
