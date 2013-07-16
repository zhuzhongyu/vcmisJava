<%@ page language="java"
	import="java.util.*,coboo.config.*,coboo.service.*"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String personId = request.getParameter("personId");

	String tableClassName = request.getParameter("tableNameClassName");
	String dah=null;
	 dah = request.getParameter("dah");
	String[][] docslist = null;
	if (dah !=null) {
		docslist = IService.getDocsList(dah, personId, tableClassName);
	} else {
		docslist = IService.getDocsList(personId, tableClassName);
	}
	out.println("<Files>");
	if (docslist == null) {
		out.println("<File>");
		out.println("<F>");
		out.println(0);
		out.println("</F>");
		out.println("</File>");
	} else {

		for (int i = 0; i < docslist.length; i++) {
			out.println("<File>");
			out.println("<createTime>");
			out.println(docslist[i][0]);
			out.println("</createTime>");
			out.println("<createUser>");
			out.println(docslist[i][1]);
			out.println("</createUser>");
			out.println("<F>");
			out.println(docslist[i][2]);
			out.println("</F>");
			out.println("</File>");
		}
	}

	out.println("</Files>");
%>
