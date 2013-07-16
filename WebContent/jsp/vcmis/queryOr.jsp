
<%@ page language="java"
	import="java.lang.*,coboo.config.*,coboo.service.*,coboo.document.XmlParser"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String keyXmlStr = request.getParameter("keyXmlStr");
	String sortFieldName = request.getParameter("sortFieldName");
	String pageNumberStr = request.getParameter("pageNumber");
	int pageNumber = Integer.parseInt(pageNumberStr);

	//keyXmlStr xml字符串，例如<k><gxy>true</gxy><tnb>false</tnb><zl>false</zl><gxb>false</gxb></k>

	XmlParser p = new XmlParser();
	String[] fieldNames = p.getKeys(keyXmlStr);
	String[] fieldValues = p.getValues(keyXmlStr);
	//for(int i=0;i<fieldNames.length;i++){
//		out.println(fieldNames[i]);
//		out.println(fieldValues[i]);
//	}
	Object[] result = IService.queryOr(fieldNames, fieldValues, sortFieldName, pageNumber);
	String[] titles=(String[])result[0];
	String[][] records=(String[][])result[1];
	 int totalPageNumber=(Integer)result[2];
	 int totalNumber=(Integer)result[3];
	out.println("<rs>");
		out.println("<pageNums>");
	 		out.println(totalPageNumber);
	 	out.println("</pageNums>");
	 	out.println("<totalNumber>");
 		out.println(totalNumber);
 		out.println("</totalNumber>");
	for(int i=0;i<records.length;i++){
		out.println("<r>");
		for(int j=0;j<titles.length;j++){
			out.println("<"+titles[j]+">");
			out.println(records[i][j]);
			out.println("</"+titles[j]+">");
		}
		out.println("</r>");
	}
	out.println("</rs>");
%>