<%@ page language="java"
	import="java.util.*,coboo.config.*,coboo.service.*" pageEncoding="UTF-8"%>
<%
response.setContentType("text/xml");
out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

String Docfilename = request.getParameter("Docfilename");

String DocXmlStr= IService.getDoc( Docfilename);
out.println(DocXmlStr);
%>