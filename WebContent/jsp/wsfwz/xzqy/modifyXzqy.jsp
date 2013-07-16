<%@ page language="java" import="java.util.*,com.datebase.*,com.common.*,com.coboo.base.db.HibernateDBManager " pageEncoding="UTF-8"%>
<%
	response.setContentType("text/xml");
	
  String id = request.getParameter("id");
	String name = request.getParameter("name");
	String number = request.getParameter("number");
	String level = request.getParameter("level");
	String parent = request.getParameter("parent");
  String cityName = request.getParameter("cityName");
	String peoples = request.getParameter("peoples");
  
  HibernateDBManager db = new HibernateDBManager();
	db.open();
	 System.out.println("name: " + name)   ;
  String hql = "from Xzqy z where z.id =" + id;
  
  ArrayList<Xzqy> list = (ArrayList<Xzqy>) Common.select(hql);
  
  Xzqy xzqy = list.get(0);
  xzqy.setName(name);
  xzqy.setNumber(number);
  xzqy.setLevel(Integer.valueOf(level));
  xzqy.setParent(parent);
  xzqy.setCityName(cityName);
  xzqy.setPeoples(peoples);
  
 // String hql = "update Xzqy set name='" + name + "', number='" + number + "', parent='" + parent + "', level=" + level + ", peoples='" + peoples + "', cityName='" + cityName + "' where id =" + id;
  
	db.update(xzqy);
	db.commit();
	db.close();
  Common.close();
%>
                                           