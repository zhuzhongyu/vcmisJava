<%@ page language="java" import="java.util.*,com.datebase.*,com.coboo.userRights.*" pageEncoding="UTF-8"%>
<%@ page import="com.common.*,java.util.*"%>
<%@ page import="com.coboo.base.db.*" %>
<%@page import="com.coboo.base.db.DB_Users;"%>

<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	String username = request.getParameter("username");   //保存用户名
	String chname = request.getParameter("chname");       //保存用户姓名
	String cardnums = request.getParameter("cardnums");   //保存用户卡号
	String lev = request.getParameter("lev");             //保存用户级别
	String start=request.getParameter("startpage");       //保存查询起始页
	String commid ="0";                                   //保存用户机构编号
	int comm_id=0;										  //保存机构编号Int类型
	Boolean flag=false;
	
	if(request.getParameter("code")!=null&&!request.getParameter("code").equals("")){
	//usercode=request.getParameter("code");
	flag=true;
}
	//如果参数不为空并且不等于""
	if((request.getParameter("commid")!=null)&&(!request.getParameter("commid").equals(""))){
		commid=request.getParameter("commid");
		comm_id=Integer.parseInt(request.getParameter("commid"));//获取登陆用户的机构编号
	}
	
	
	out.println("<user>");
	Users users = new Users();
	DB_Community dao=new DB_Community();

	StringBuffer sb=new StringBuffer(); //用户传递数据的字符流
	sb.append(comm_id+",");
	
	dao.findListByid(comm_id,sb,flag);//调用机构DAO的递归查询下级机构方法
	System.out.println(sb.toString());
	//存储过程查询条件
	
	int pageSize=10;          //存储过程查询条件2---每页行数
	int startLine=0;          //存储过程查询条件3---起始行
	if(Integer.parseInt(start)>0){
		startLine=Integer.parseInt(start);
	}
	String whereString = " where 1=1 ";//存储过程查询条件4---WHERE条件 
	String InString=sb.substring(0, (sb.lastIndexOf(",")));//存储过程查询条件 --- 查询条件字符串 "where 1=1 and commid in("+InString+");"
	whereString+=" and COMMID in("+InString+")";
	if(username!=null && !username.equals("")){
		whereString += " and name like '%"+username+"%'";
	}
	
	if(chname!=null && !chname.equals("")){
		whereString += " and chName like '%"+chname+"%'";
	}
	
	if(cardnums!=null && !cardnums.equals("")){
		whereString += " and cardNums like '%"+cardnums+"%'";
	}
	ArrayList<Community> list_allcommunity = (ArrayList<Community>)Common.select("from Community");
	ArrayList<Integer> list_commid = new ArrayList<Integer>();
	if(lev != null && !lev.equals("")){
		
		if(lev.equals("community")){
			//whereString += " and commid="+commid;
		}
		else
		{
			list_commid.add(Integer.valueOf(commid));
			Integer temp = 0;
			for(int i=0;i<list_allcommunity.size();i++){
				temp = list_allcommunity.get(i).getIsglzx();
				if(temp.intValue() == Integer.valueOf(commid).intValue()){
					list_commid.add(list_allcommunity.get(i).getId());
				}
			}
		}
	}
	whereString+=" and laselogtime ='' ";
	ArrayList<Community> list_comm_user = null;
	System.out.println("selectusers.jsp:select * from users "+whereString+" "+"limit"+startLine+","+pageSize+";");
	ArrayList list_users = new ArrayList(); 
	DB_Users user=new DB_Users();
 	list_users=user.getUserList(pageSize,startLine,whereString);

	int count=0;
	if(list_commid.size() == 0){
		for(int i = 0;i<list_users.size();i++){
			count++;
			users = (Users) list_users.get(i);
			out.println("<user>");
			list_comm_user = UserOper.GetCommunityTree(users.getCommunity().getId(),list_allcommunity);
		    out.println("<cityid>"+ list_comm_user.get(0).getId() +"</cityid>");
		    out.println("<cityname>"+ list_comm_user.get(0).getNameOfCommunity() +"</cityname>");
		    out.println("<citymemo>"+ list_comm_user.get(0).getMemo() +"</citymemo>");		
			out.println("<quid>"+ list_comm_user.get(1).getId() +"</quid>");
			out.println("<quname>"+ list_comm_user.get(1).getNameOfCommunity() +"</quname>");
			out.println("<qumemo>"+ list_comm_user.get(1).getMemo() +"</qumemo>");
			out.println("<group>"+ list_comm_user.get(2).getNameOfCommunity() +"</group>");
			out.println("<group_description>"+ list_comm_user.get(2).getMemo() +"</group_description>");
			out.println("<groupid>"+ list_comm_user.get(2).getId() +"</groupid>");
			out.println("<id>" + users.getUserid() + "</id>");
			out.println("<name>" + users.getName() + "</name>");
			out.println("<pwd>" + users.getPwd() + "</pwd>");
			out.println("<usercode>" + users.getUsercode() + "</usercode>");
			out.println("<name_ch>" + users.getChName() + "</name_ch>");
			out.println("<sex>" + users.getSex() + "</sex>");
			out.println("<phone>" + users.getPhone() + "</phone>");
			out.println("<address>" + users.getAddress() + "</address>");
			out.println("<email>" + users.getEmail() + "</email>");
			out.println("<ipnums>" + users.getIpNums() + "</ipnums>");
			out.println("<ippwd>" + users.getIpPwd() + "</ippwd>");
			out.println("<cardnums>" + users.getCardNums() + "</cardnums>");
			out.println("<memo>" + users.getMemo() + "</memo>");
			out.println("<laselogtime>" + users.getLaselogtime() + "</laselogtime>");
			out.println("<role_id>" + users.getRoles().getRoleid() + "</role_id>");
			out.println("<role_name>" + users.getRoles().getName() + "</role_name>");
			out.println("<role_description>" + users.getRoles().getDescription() + "</role_description>");
			out.println("</user>");
	    }
	}else{
		for(int jj=0;jj<list_commid.size();jj++){
			for(int i = 0;i<list_users.size();i++){
				users = (Users) list_users.get(i);
				if(users.getCommunity().getId().intValue() == list_commid.get(jj).intValue()){
					count++;
//					System.out.println(i+"<name>" + users.getName() + "</name>");
					out.println("<user>");
					list_comm_user = UserOper.GetCommunityTree(users.getCommunity().getId(),list_allcommunity);
				    out.println("<cityid>"+ list_comm_user.get(0).getId() +"</cityid>");
				    out.println("<cityname>"+ list_comm_user.get(0).getNameOfCommunity() +"</cityname>");
				    out.println("<citymemo>"+ list_comm_user.get(0).getMemo() +"</citymemo>");		
					out.println("<quid>"+ list_comm_user.get(1).getId() +"</quid>");
					out.println("<quname>"+ list_comm_user.get(1).getNameOfCommunity() +"</quname>");
					out.println("<qumemo>"+ list_comm_user.get(1).getMemo() +"</qumemo>");
					out.println("<group>"+ list_comm_user.get(2).getNameOfCommunity() +"</group>");
					out.println("<group_description>"+ list_comm_user.get(2).getMemo() +"</group_description>");
					out.println("<groupid>"+ list_comm_user.get(2).getId() +"</groupid>");
					out.println("<id>" + users.getUserid() + "</id>");
					out.println("<name>" + users.getName() + "</name>");
					out.println("<pwd>" + users.getPwd() + "</pwd>");
					out.println("<usercode>" + users.getUsercode() + "</usercode>");
					out.println("<name_ch>" + users.getChName() + "</name_ch>");
					out.println("<sex>" + users.getSex() + "</sex>");
					out.println("<phone>" + users.getPhone() + "</phone>");
					out.println("<address>" + users.getAddress() + "</address>");
					out.println("<email>" + users.getEmail() + "</email>");
					out.println("<ipnums>" + users.getIpNums() + "</ipnums>");
					out.println("<ippwd>" + users.getIpPwd() + "</ippwd>");
					out.println("<cardnums>" + users.getCardNums() + "</cardnums>");
					out.println("<memo>" + users.getMemo() + "</memo>");
					out.println("<laselogtime>" + users.getLaselogtime() + "</laselogtime>");
					out.println("<role_id>" + users.getRoles().getRoleid() + "</role_id>");
					out.println("<role_name>" + users.getRoles().getName() + "</role_name>");
					out.println("<role_description>" + users.getRoles().getDescription() + "</role_description>");
					out.println("</user>");
				}
		    }
	    }
	}
	out.println("<count>");
	out.println("<num>"+count+"</num>");
	out.println("</count>");
	out.println("</user>");
	
	Common.close();
//	db.commit();
//	db.close();
%>