<%@ page language="java" pageEncoding="UTF-8"%>
<%
	/**从文档库中删除一个人**/

	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String personId = request.getParameter("personId");
	String dah=null;
	 dah = request.getParameter("dah");
	if (dah ==null) {
		coboo.service.IService.deletePerson(personId);
	} else {
		
		coboo.service.IService.deletePerson(personId, dah);
	}
%>