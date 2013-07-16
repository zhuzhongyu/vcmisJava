<%@ page language="java"
	import="java.lang.*,coboo.config.*,coboo.service.*,coboo.document.XmlParser"
	pageEncoding="UTF-8"%>
<%
/** And/Or 统计:统计条件之间关系由<p>and/or<p>确定
从客户端获得keyXmlStr字符串，
keyXmlStr 格式：
<k>
<gxy op='and'>true</gxy>
<tnb op='or'>true</tnb>
<zl op='not'>true</zl>
<gxb op='or'>true</gxb>
<birthDate op='and' begin='19000101',end='19461119'></birthDate>
</k>
说明：
op表示该条件节点和下一个节点之间的关系分为
“and” 跟相邻的下个节点之间是“并且”(and)关系。
“or”  跟相邻的下个节点之间是“或者”(or)关系。
“not” 表示不包含下一结点条件所包含的范围。
begin 表示范围查询的上边界。
end 表示范围查询的下边界。
没有begin或者end表示不是范围查询 （注意：范围查询非常耗费资源和时间）
以上例子表示符合 高血压 '并且' 糖尿病 '或者' 肿瘤'不包含'冠心病出生日期大于1900年1月1日，小于1946年11月19日
**/

	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

	String keyXmlStr = request.getParameter("keyXmlStr");
 
	int number=coboo.service.IService.statAndOr(keyXmlStr);
	out.println(number);
%>
