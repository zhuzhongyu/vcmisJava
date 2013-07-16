<%@ page language="java"
	import="java.lang.*,coboo.config.*,coboo.service.*,coboo.document.XmlParser"
	pageEncoding="UTF-8"%>
<%
/** or 统计:统计条件之间是OR关系
从客户端获得keyXmlStr字符串，
keyXmlStr 格式：<k><gxy>true</gxy><tnb>false</tnb><zl>false</zl><gxb>false</gxb></k>
该字符串包含查询的字段和查询条件，查询得到的结果数量返回客户端**/

	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String keyXmlStr = request.getParameter("keyXmlStr");

	XmlParser p = new XmlParser();
	String[] fieldNames = p.getKeys(keyXmlStr);
	String[] fieldValues = p.getValues(keyXmlStr);


	int number=coboo.service.IService.statOr(fieldNames,fieldValues);
	out.println(number);
%>