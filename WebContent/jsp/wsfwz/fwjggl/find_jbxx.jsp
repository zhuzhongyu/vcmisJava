<%@ page language="java" import="java.util.*,com.coboo.base.db.*"
	pageEncoding="UTF-8"%>
<%-- 最后修改人：王振东 添加 q.bqhks,q.sqhks 字段
	  用来向前台返回 本区户口数 社区服务覆盖户口数 --%>
<%
	response.setContentType("text/xml");
	out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	out.println("<jbxxs>");
	
	String sssq = request.getParameter("sssq");
		
	String hql = "select c.nameOfCommunity,q.cqid,q.bqrks,q.sqrks,q.jdbscs,q.fwzxjds,q.fwjgjds,"
	+ "q.szq,q.szfwzxs,q.szfwzs,q.lcjq,q.lcjfwzxs,q.lcjfwzs,q.gmq,q.gmfwzxs,q.gmfwzs,q.ljztr,"
	+ "q.rjbz,q.sssq,q.zfbfwzxs,q.zfbfwzs,q.mqyss,q.mqhss,q.mwqyss,q.dzs,q.bks,q.zjzcs,q.gjzcs,"
	+ "q.sqzrs,q.tds,q.tdfgs,q.zlrc,q.rcbl,q.jdl,q.czrcs,q.bqhks,q.sqhks,q.mbrcs,q.cjrkfs,q.jkjycs,q.xcclfs,"
	+ "q.jkjyrc,q.syzxrs,q.ycfbj,q.etbj,q.jsjjgs,q.jsjdas " 
	+ "from Cq as q , Community as c " 
	+ "where q.sssq=c.id";
	
	
	hql += " and q.sssq = "+sssq+"";
	
	
	HibernateDBManager db = new HibernateDBManager();
	db.open();
	Iterator list = db.complexQuery(hql);	
	db.commit();
	db.close();
	
	int i = 0;
	while(list.hasNext()) 
	{
		i++;
		out.println("<jbxx>");
		Object[]obj = (Object[])list.next();
		out.println("<nameOfquunity>" + obj[0].toString() + "</nameOfquunity>");
		out.println("<cqid>" + obj[1].toString() + "</cqid>");
		out.println("<bqrks>" + obj[2].toString() + "</bqrks>");
		out.println("<sqrks>" + obj[3].toString() + "</sqrks>");
		out.println("<jdbscs>" + obj[4].toString() + "</jdbscs>");
		out.println("<fwzxjds>" + obj[5].toString() + "</fwzxjds>");
		out.println("<fwjgjds>" + obj[6].toString() + "</fwjgjds>");
		out.println("<szq>" + obj[7].toString() + "</szq>");
		out.println("<szfwzxs>" + obj[8].toString() + "</szfwzxs>");
		out.println("<szfwzs>" + obj[9].toString() + "</szfwzs>");
		out.println("<lcjq>" + obj[10].toString() + "</lcjq>");
		out.println("<lcjfwzxs>" + obj[11].toString() + "</lcjfwzxs>");
		out.println("<lcjfwzs>" + obj[12].toString() + "</lcjfwzs>");
		out.println("<gmq>" + obj[13].toString() + "</gmq>");
		out.println("<gmfwzxs>" + obj[14].toString() + "</gmfwzxs>");
		out.println("<gmfwzs>" + obj[15].toString() + "</gmfwzs>");
		out.println("<ljztr>" + obj[16].toString() + "</ljztr>");
		out.println("<rjbz>" + obj[17].toString() + "</rjbz>");
		out.println("<sssq>" + obj[18].toString() + "</sssq>");
		out.println("<zfbfwzxs>" + obj[19].toString() + "</zfbfwzxs>");
		out.println("<zfbfwzs>" + obj[20].toString() + "</zfbfwzs>");
		out.println("<mqyss>" + obj[21].toString() + "</mqyss>");
		out.println("<mqhss>" + obj[22].toString() + "</mqhss>");
		out.println("<mwqyss>" + obj[23].toString() + "</mwqyss>");
		out.println("<dzs>" + obj[24].toString() + "</dzs>");
		out.println("<bks>" + obj[25].toString() + "</bks>");
		out.println("<zjzcs>" + obj[26].toString() + "</zjzcs>");
		out.println("<gjzcs>" + obj[27].toString() + "</gjzcs>");
		out.println("<sqzrs>" + obj[28].toString() + "</sqzrs>");
		out.println("<tds>" + obj[29].toString() + "</tds>");
		out.println("<tdfgs>" + obj[30].toString() + "</tdfgs>");
		out.println("<zlrc>" + obj[31].toString() + "</zlrc>");
		out.println("<rcbl>" + obj[32].toString() + "</rcbl>");
		out.println("<jdl>" + obj[33].toString() + "</jdl>");
		out.println("<czrcs>" + obj[34].toString() + "</czrcs>");
        out.println("<bqhks>" + obj[35].toString() + "</bqhks>");
		out.println("<sqhks>" + obj[36].toString() + "</sqhks>");
		out.println("<mbrcs>" + obj[37].toString() + "</mbrcs>");
		out.println("<cjrkfs>" + obj[38].toString() + "</cjrkfs>");
		out.println("<jkjycs>" + obj[39].toString() + "</jkjycs>");
		out.println("<xcclfs>" + obj[40].toString() + "</xcclfs>");
		out.println("<jkjyrc>" + obj[41].toString() + "</jkjyrc>");
		out.println("<syzxrs>" + obj[42].toString() + "</syzxrs>");
		out.println("<ycfbj>" + obj[43].toString() + "</ycfbj>");
		out.println("<etbj>" + obj[44].toString() + "</etbj>");
		out.println("<jsjjgs>" + obj[45].toString() + "</jsjjgs>");
		out.println("<jsjdas>" + obj[46].toString() + "</jsjdas>");
		out.println("<size>" + 1 + "</size>");
		out.println("</jbxx>");
	}
	if (i == 0) {
		out.println("<jbxx>");
		out.println("<size>" + 0 + "</size>");
		out.println("</jbxx>");
	}
	out.println("</jbxxs>");
%>
