<%@ page language="java" import="java.util.*,com.datebase.*,com.coboo.userRights.*" pageEncoding="UTF-8"%>
<%@page import="com.common.*;"%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	String username = request.getParameter("username");
	String chname = request.getParameter("chname");
	String cardnums = request.getParameter("cardnums");
	String commid = request.getParameter("commid");
	String lev = request.getParameter("lev");
//	HibernateDBManager db = new HibernateDBManager();
//	db.open();
	
	out.println("<user>");
	Users users = new Users();

	String hql_users = "from Users where 1=1";
	
	if(username!=null && !username.equals("")){
		hql_users += " and name like '%"+username+"%'";
	}
	
	if(chname!=null && !chname.equals("")){
		hql_users += " and chName like '%"+chname+"%'";
	}
	
	if(cardnums!=null && !cardnums.equals("")){
		hql_users += " and cardNums like '%"+cardnums+"%'";
	}
	hql_users += " and laselogtime ='no' ";
	System.out.println("selectusers.jsp:"+hql_users);
	ArrayList<Community> list_allcommunity = (ArrayList<Community>)Common.select("from Community");
	ArrayList<Integer> list_commid = new ArrayList<Integer>();
	if(lev != null && !lev.equals("")){
		
		if(lev.equals("community")){
			hql_users += " and commid="+commid;
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
	
	ArrayList<Community> list_comm_user = null;
	
	ArrayList<Users> list_users = (ArrayList<Users>) Common.select(hql_users);

	if(list_commid.size() == 0){
		for(int i = 0;i<list_users.size();i++){
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
	out.println("</user>");
	Common.close();
//	db.commit();
//	db.close();
%>