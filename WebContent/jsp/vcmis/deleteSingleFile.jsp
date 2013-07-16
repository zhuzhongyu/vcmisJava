<%@ page language="java"
	import="java.util.*,coboo.config.*,coboo.service.*" pageEncoding="UTF-8"%>
<%
response.setContentType("text/xml");
out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");


String personId= request.getParameter("personId");
String tableClassName= request.getParameter("tableClassName");
String fileAbsoluteName = request.getParameter("fileAbsoluteName");

int status= IService.deleteSingleFile( personId, tableClassName, fileAbsoluteName);

%>