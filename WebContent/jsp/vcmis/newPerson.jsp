<%@ page language="java"
	import="coboo.service.*"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String personId = request.getParameter("personId");
	String name = request.getParameter("name");
	String dah = request.getParameter("dah");
	String orgId = request.getParameter("orgId");
	String createrId = request.getParameter("createrId");
	// return 1 correct,-1 personId error,-2 same personid,-9 other error
	int ret=IService.newPerson(personId, name, dah, orgId, createrId);
	if (ret==1) {
		out.println("Y");
	} else if(ret==-1){
		out.println("身份证输入错误");
	}else if(ret==-2){
		out.println("身份证号码重复");
	}else if(ret==-9){
		out.println("系统抛出异常");
	}
%>