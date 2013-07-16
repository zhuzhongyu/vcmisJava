<%@ page language="java" pageEncoding="UTF-8"%>
<%
	/**加入新文档到已经登记的居民档案库中**/
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String personId = request.getParameter("personId");
	String keyXmlStr = request.getParameter("keyXmlStr");//这个参数已经没用作废，为了向前兼容保留
	String docXmlStr = request.getParameter("docXmlStr");
	String createrId = request.getParameter("createrId");
	String[] docXmlStrArray = new String[1];
	String dah=null;
	 dah = request.getParameter("dah");
	System.out.println("dah:"+dah+"personId"+personId);
	docXmlStrArray[0] = docXmlStr;
	if (dah == null) {
		if (coboo.service.IService.addDocs(personId, createrId, keyXmlStr, docXmlStrArray)) {
			out.println("Y");
		} else {
			out.println("N");
		}
	} else {

				if (coboo.service.IService.addDocs(dah,personId, createrId, keyXmlStr, docXmlStrArray)) {
			out.println("Y");
	} else {
			out.println("N");
	}
	}
%>