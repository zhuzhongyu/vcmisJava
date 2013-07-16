<%@ page language="java" import="com.coboo.base.*,com.coboo.base.db.*" pageEncoding="utf-8"%>
<%@ page import="com.common.*,java.util.*"%>
<%@ page import="com.coboo.base.db.*" %>
<%@page import="com.coboo.base.db.DB_Users;"%>
<%
response.setContentType("text/xml");
String usercode="";
Boolean flag=false;
//String commid=request.getParameter("commid");
String lev=request.getParameter("lev");

if(request.getParameter("code")!=null&&!request.getParameter("code").equals("")){
	usercode=request.getParameter("code");
	flag=true;
}
//调用查询机构DAO
	DB_Community dao=new DB_Community();
	int comm_id=0;
	int Count=0;
	//System.out.println("commid:"+commid);
	if((request.getParameter("commid")==null)){
	 	comm_id=0;
	 	System.out.println(""+comm_id);
	}
	else {
		comm_id=Integer.parseInt(request.getParameter("commid"));//获取登陆用户的机构编号
		System.out.println(""+comm_id);
	}
	StringBuffer sb1=new StringBuffer(); //用户传递数据的字符流
	sb1.append(comm_id+",");
	
	dao.findListByid(comm_id,sb1,flag);//调用机构DAO的递归查询下级机构方法
	System.out.println(sb1.toString());
	String InString=sb1.substring(0, (sb1.lastIndexOf(",")));//存储过程查询条件 --- 查询条件字符串 "where 1=1 and commid in("+InString+");"
	
StringBuffer sb=new StringBuffer();
sb.append(Func_String.XML_HEADER);
if(flag==true){
	String sqlString = "where 1=1 and COMMID in("+InString+")  and laselogtime = '' ;";
	DB_Users user=new DB_Users();
 	Count=user.getUserCount(sqlString);
}else if(lev.equals("community")){
	String sqlString = "where 1=1  and COMMID in("+InString+") and laselogtime = '' ;";
	DB_Users user=new DB_Users();
 	Count=user.getUserCount(sqlString);
}else {
	String sqlString = "where 1=1 and laselogtime = ''";
	DB_Users user=new DB_Users();
 	Count=user.getUserCount(sqlString);
}
out.println("<Users>");
out.println("<user>");
out.println("<count>"+Count+"</count>");
out.println("</user>");
out.println("</Users>");

%>
