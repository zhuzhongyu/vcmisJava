/**
 * 远程照护数据操库查询操作类
 * 编写人：关宏宇  2010年9月11日
 * 最后修改人：关宏宇
 */

package com.coboo.base.db;
import com.datebase.*;
import java.util.*;
import com.coboo.base.*;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;


public class YCZHOper {


	/**
	 * 血糖各时段情况饼图数据查询类
	 * @param arrlist 包括各饼图的时间段和目标值（time1,time2,mb1,mb2）
	 * @param riqi 按相应日期查询饼图
	 * @return arr（ArrayList）包括各饼图的时间段和时间段内的高于正常值的次数xt_hight，符合正常值的次数xt_middle，以及低于正常值的次数xt_lower
	 * @author ：关宏宇  2010年9月11日
	 * 最后修改人：关宏宇
	 */
	
	public static ArrayList<ArrayList<String>> getPieChart( ArrayList<ArrayList<String>> arrlist,String startDay,String endDay,String personid){
		HibernateDBManager db = new HibernateDBManager();
		
		ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
		int xt_hight=0;	//血糖高于正常值的次数
		int xt_middle=0;//血糖符合正常值的次数
		int xt_lower=0;	//血糖低于正常值的次数
		int xt_value=0;	//当前血糖值
		String time1="";//保存时段区间的起始时间
		String time2="";//保存时段区间的结束时间
		int mb1=0;//血糖正常范围的最小值
		int mb2=0;//血糖正常范围的最大值
		ArrayList<String> temp;
		try{
			db.open();
			for(int i=0;i<arrlist.size();i++){
				List<String> list1=(List<String>)arrlist.get(i);
				time1=list1.get(0).toString();
				time2=list1.get(1).toString();
				mb1=Integer.parseInt(list1.get(2).toString());
				mb2=Integer.parseInt(list1.get(3).toString());
				xt_hight=0;
				xt_middle=0;
				xt_lower=0;
				xt_value=0;
				String sqlString=" select a.xt from YczhXt a where a.personid='"+personid+"' and  a.mtime  between '"+time1+"' and '"+time2+"' and a.riqi between '"+startDay+"' and '"+endDay+"'";
				Iterator<Double> iter=db.complexQuery(sqlString);
				while(iter.hasNext()){
					Double temp1 = null;
					temp1 = (Double)iter.next();
					xt_value=temp1.intValue();
					if(xt_value<mb1){
						xt_lower++;
					}else if(xt_value<=mb2){
						xt_middle++;
					}else{
						xt_hight++;
					}
				}
				System.out.println(time1+"~"+time2+"高于数："+xt_hight+"  符合数:"+xt_middle+"  低于数:"+xt_lower);
				temp=new ArrayList<String>();
				temp.add(time1);
				temp.add(time2);
				temp.add(""+xt_hight);
				temp.add(""+xt_middle);
				temp.add(""+xt_lower);
				arr.add(temp);
			}
		}catch(Exception ex){ex.printStackTrace();}
	     return arr;
	}
	/**
	 * 获取全天的血糖趋势图
	 * @param arrlist 装载全天各取值时段的字符串
	 * @param riqi 查询日期
	 * @return 按取值顺序返回各时段的血糖值
	 * 编写人：关宏宇 
	 * 最后修改人：关宏宇
	 */
	public static ArrayList<ArrayList<Object>> getXT_AllDay( String start, String end,String personid){

	    HibernateDBManager db = new HibernateDBManager();
		ArrayList<ArrayList<Object>> arrlist=new ArrayList<ArrayList<Object>>();

		try{
			db.open();
			
			String sqlString="select a.riqi,  avg(a.xt) as avg from YczhXt a where a.personid='"+personid+"' and a.riqi between '"+start+"' and '"+end+"' group by a.riqi ";
			Iterator<Object[]> iter=db.complexQuery(sqlString);
			
			while(iter.hasNext()){
				Object[] temp1 = null;
				ArrayList<Object> temp=new ArrayList<Object>();
				temp1 = (Object[])iter.next();
				if(temp1[0]!=null&&temp1[1]!=null){
					temp.add(temp1[0]);
					temp.add(temp1[1]);
					arrlist.add(temp);
				}
			}
			
		}catch(Exception ex){ex.printStackTrace();}
	     return arrlist;
	}
	/**
	 * 获取全天的心跳趋势图
	 * @param arrlist 装载全天各取值时段的字符串
	 * @param riqi 查询日期
	 * @return 按取值顺序返回各时段的血糖值
	 * 编写人：关宏宇 
	 * 最后修改人：关宏宇
	 */
	public static ArrayList<ArrayList<String>> getXinTiao_AllDay( String start, String end,String personid){

	    HibernateDBManager db = new HibernateDBManager();
		ArrayList<ArrayList<String>> arrlist=new ArrayList<ArrayList<String>>();

		try{
			db.open();
			
			String sqlString="select a.riqi,  avg(a.xt) as avg from YczhXy a where a.personid='"+personid+"' and a.riqi between '"+start+"' and '"+end+"' group by a.riqi ";
			Iterator<Object[]> iter=db.complexQuery(sqlString);
			
			while(iter.hasNext()){
				Object[] temp1 = null;
				ArrayList<String> temp=new ArrayList<String>();
				temp1 = (Object[])iter.next();
				if(temp1!=null){
					temp.add(temp1[0].toString());
					temp.add(temp1[1].toString());
					arrlist.add(temp);
				}
			}
			
		}catch(Exception ex){ex.printStackTrace();}
	     return arrlist;
	}
	/**
	 * 获取全天的血压趋势图
	 * @param arrlist 装载全天各取值时段的字符串
	 * @param riqi 查询日期
	 * @return 按取值顺序返回各时段的血糖值
	 * 编写人：关宏宇 
	 * 最后修改人：关宏宇
	 */
	public static ArrayList<ArrayList<String>> getXY_AllDay( String start, String end,String personid){

	    HibernateDBManager db = new HibernateDBManager();
		ArrayList<ArrayList<String>> arrlist=new ArrayList<ArrayList<String>>();

		try{
			db.open();
			
			String sqlString="select a.riqi,  avg(a.ss),avg(a.sz) from YczhXy a where a.personid='"+personid+"' and a.riqi between '"+start+"' and '"+end+"' group by a.riqi ";
			Iterator<Object[]> iter=db.complexQuery(sqlString);
			
			while(iter.hasNext()){
				Object[] temp1 = null;
				ArrayList<String> temp=new ArrayList<String>();
				temp1 = (Object[])iter.next();
				if(temp1!=null){
					temp.add(temp1[0].toString());
					temp.add(temp1[1].toString());
					temp.add(temp1[2].toString());
					arrlist.add(temp);
				}
			}
			
		}catch(Exception ex){ex.printStackTrace();}
	     return arrlist;
	}
	/**
	 * 取得某天各时段的血糖平均值
	 * @param arrlist 转载各时段的起始值和结束值的字符串动态数组
	 * @param riqi 查询的日期
	 * @return 放回各时段血糖的平均值数组
	 * 编写人：关宏宇 
	 * 最后修改人：关宏宇
	 */
	
	public static int getXT_Average( String startTime,String endTime,String startDay,String endDay,String personid){

		HibernateDBManager db = new HibernateDBManager();
		int returnnum=0;
		try{
			db.open();
			//"select a.riqi,  avg(a.xt) as avg from YczhXt a where a.personid='"+personid+"' and a.riqi between '"+start+"' and '"+end+"' group by a.riqi ";
				String sqlString="select avg(a.xt) as avg from YczhXt a where a.personid='"+personid+"' and  a.mtime  between '"+startTime+"' and '"+endTime+"' and a.riqi between '"+startDay+"' and '"+endDay+"'";
				Iterator<Object> iter=db.complexQuery(sqlString);
				while(iter.hasNext()){
					Double temp1 = null;
					temp1 = (Double)iter.next();
					if(temp1!=null){
						returnnum=temp1.intValue();
						System.out.println(returnnum);
					}
				}
		
		}catch(Exception ex){ex.printStackTrace();}
	    return returnnum;
	}
	/**
	 * 取得某天各时段的心跳平均值
	 * @param arrlist 转载各时段的起始值和结束值的字符串动态数组
	 * @param riqi 查询的日期
	 * @return 放回各时段血糖的平均值数组
	 * 编写人：关宏宇 
	 * 最后修改人：关宏宇
	 */
	
	public static Object getXinTiao_Average( String startTime,String endTime,String startDay,String endDay,String personid){

		HibernateDBManager db = new HibernateDBManager();
		Object obj=null;
		//int returnnum=0;
		try{
			db.open();
			//"select a.riqi,  avg(a.xt) as avg from YczhXt a where a.personid='"+personid+"' and a.riqi between '"+start+"' and '"+end+"' group by a.riqi ";
				String sqlString="select avg(a.xt) as avg from YczhXy a where a.personid='"+personid+"' and  a.mtime  between '"+startTime+"' and '"+endTime+"' and a.riqi between '"+startDay+"' and '"+endDay+"'";
				Iterator<Object> iter=db.complexQuery(sqlString);
				while(iter.hasNext()){
					Object temp1 = null;
					temp1 = (Object)iter.next();
					if(temp1!=null){
						obj=temp1;

					}
				}
		
		}catch(Exception ex){ex.printStackTrace();}
	    return obj;
	}
	/**
	 * 取得某天各时段的血压平均值
	 * @param arrlist 转载各时段的起始值和结束值的字符串动态数组
	 * @param riqi 查询的日期
	 * @return 放回各时段血糖的平均值数组
	 * 编写人：关宏宇 
	 * 最后修改人：关宏宇
	 */
	
	public static ArrayList<Object> getXY_Average( String startTime,String endTime,String startDay,String endDay,String personid){

		HibernateDBManager db = new HibernateDBManager();
	
		ArrayList<Object> arr=new ArrayList<Object>();

		try{
			db.open();
			
				String sqlString="select avg(a.ss),avg(a.sz)  from YczhXy a where a.personid='"+personid+"' and  a.mtime  between '"+startTime+"' and '"+endTime+"' and a.riqi between '"+startDay+"' and '"+endDay+"'";
				Iterator<Object[]> iter=db.complexQuery(sqlString);
				while(iter.hasNext()){
					Object[] temp1 = null;
					temp1 = (Object[])iter.next();
					if(temp1!=null){
						arr.add(temp1[0]);
						arr.add(temp1[1]);

					}
				}
		
		}catch(Exception ex){ex.printStackTrace();}
	    return arr;
	}
	
	/**
	 * 根据输入的personid 日期 起始时间和结束时间 返回该时间段内的血糖平均值
	 * @param personid
	 * @param riqi
	 * @param startTime
	 * @param endTime
	 * @return obj
	 * @author 关宏宇 2010年9月21
	 */
	public static Object getXtzl(String personid,String riqi,String startTime,String endTime){
		HibernateDBManager db = new HibernateDBManager();
		Object obj=null;
		try{
			db.open();
			String sqlString="select  avg(a.xt) as avg from YczhXt a where a.personid='"+personid+"' and  a.mtime  between '"+startTime+"' and '"+endTime+"' and a.riqi= '"+riqi+"'";
			Iterator<Object> iter=db.complexQuery(sqlString);
			if(iter.hasNext()){
				obj = (Object)iter.next();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}
	/**
	 * 根据输入的personid 日期 起始时间和结束时间 返回该时间段内的血压和心跳的平均值
	 * @param personid
	 * @param riqi
	 * @param startTime
	 * @param endTime
	 * @return obj
	 * @author 关宏宇 2010年9月21
	 */
	public static Object[] getXyzl(String personid,String riqi,String startTime,String endTime){
		HibernateDBManager db = new HibernateDBManager();
		Object[] obj=null;
		try{
			db.open();
			String sqlString="select  avg(a.ss), avg(a.sz), avg(a.xt) from YczhXy a where a.personid='"+personid+"' and  a.mtime  between '"+startTime+"' and '"+endTime+"' and a.riqi= '"+riqi+"'";
			Iterator<Object[]> iter=db.complexQuery(sqlString);
			if(iter.hasNext()){
				obj = (Object[])iter.next();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}
	/**
	 * 根据输入的personid查询血压表里第一条数据的日期
	 * @param personid
	 * @return obj
	 * @author 关宏宇 2010年10月8日
	 * 最后修改人：关宏宇
	 */
	public static Object getXyStartDate(String personid){
		HibernateDBManager db = new HibernateDBManager();
		Object obj=null;
		try{
			db.open();
			String sqlString="select min(a.riqi) from YczhXy a where a.personid='"+personid+"'";
			Iterator<Object> iter=db.complexQuery(sqlString);
			if(iter.hasNext()){
				obj=(Object)iter.next();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return obj;
	}
	/**
	 * 根据输入的personid查询血糖表里第一条数据的日期
	 * @param personid
	 * @return obj
	 * @author 关宏宇 2010年10月8日
	 * 最后修改人：关宏宇
	 */
	public static Object getXtStartDate(String personid){
		HibernateDBManager db = new HibernateDBManager();
		Object obj=null;
		try{
			db.open();
			String sqlString="select min(a.riqi) from YczhXt a where a.personid='"+personid+"'";
			Iterator<Object> iter=db.complexQuery(sqlString);
			if(iter.hasNext()){
				obj=(Object)iter.next();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return obj;
	}
	/**
	 * 测试主函数
	 */
	//public static void main (String [] args){
		//YCZHOper oper=new YCZHOper();
		//Object obj=oper.getXtStartDate("210101198101011231");
		//System.out.println(obj.toString());
		
		
	//}
}
