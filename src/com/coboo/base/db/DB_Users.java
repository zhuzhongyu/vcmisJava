package com.coboo.base.db;
//最后修改人：王振东 添加查询用户名称单列的方法
import com.datebase.Users;
import com.datebase.HibernateSessionFactory;
import com.coboo.base.Func_String;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import java.sql.CallableStatement;   
import java.sql.Connection;   
import java.sql.PreparedStatement;   
import java.sql.ResultSet;   
import java.sql.SQLException;   
import java.util.List;   
import org.hibernate.Query;   
import org.hibernate.Session;  

//用户列表DAO
public class DB_Users
{
	@SuppressWarnings("unchecked")
	public static ArrayList<Users> getUserListByDistrictOrCommunityName(String name)
	{
		ArrayList list = new ArrayList();
		if(Func_String.isNotNullAndEmpty(name))
		{
			String hql = "from Users as u where u.community.nameOfCommunity = '"+name+"'";
			HibernateDBManager db = new HibernateDBManager();
			db.open();
			list = (ArrayList<Users>)db.query(hql);
			db.commit();
			db.close();
		}
		
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList getUserListByCommunityName(String name)
	{
		ArrayList list = new ArrayList();
		if(Func_String.isNotNullAndEmpty(name))
		{
			String hql = "select name from Users as u where u.community.nameOfCommunity = '"+name+"'";
			HibernateDBManager db = new HibernateDBManager();
			db.open();
			list = (ArrayList)db.query(hql);
			db.commit();
			db.close();
		}
		
		
		return list;
	}
	
	
	
	public static Users getUserById(Integer id)
	{
		HibernateDBManager db = new HibernateDBManager();
		db.open();
		Users u = (Users)db.getObjectById(Users.class, id);
		db.commit();
		db.close();
		
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList getUserListByWhereString(String whereString)
	{
		ArrayList<Users> list = new ArrayList();
		if(Func_String.isNotNullAndEmpty(whereString))
		{
			String hql = "select * from Users as u where u.community.id in ("+whereString+")";
			HibernateDBManager db = new HibernateDBManager();
			db.open();
			list = (ArrayList<Users>)db.query(hql);
			db.commit();
			db.close();
		}
		
		
		return list;
	}

	/**通过调用存储过程统计查询用户数 
	 * @param whereString(String) 查询条件字符串
	 * @return count(int)返回查询结果
	 * 编写人：关宏宇 2010年8月10日
	 * 最后修改人：关宏宇 2010年8月12日
	*/
	
	public static int getUserCount(String whereString) throws SQLException{            
		Session session=null;            
		Connection conn=null;            
		PreparedStatement pst=null;
		CallableStatement call=null;
		ResultSet rs=null;      
		int count=0;
		try{                 
			session=HibernateSessionFactory.getSession();
			session.flush();
			conn=session.connection();                   
			call=conn.prepareCall("{call procdure_users_count(?)}");
			call.setString(1, whereString);
			call.executeUpdate();
			rs = call.getResultSet();
			while(rs.next()){
				count=rs.getInt(1);
			}                       
		}catch(Exception e){e.printStackTrace();}            
		finally{                 
			if(rs!=null){                      
				rs.close();                 
			}                 
			if(pst!=null){                     
				pst.close();                 
			}                 
			if(conn!=null){                      
				conn.close();                 
			}                 
			if(session!=null){                      
				//session.close();                 
			}            
		}
		return count;
	}
	
  

	/**通过调用存储过程统计查询用户列表
	 * @param pagesize(int) 设置单页显示数
	 * @param start(int) 设置单页查询起始行
	 * @param whereString(String) 查询条件字符串
	 * @return list(ArrayList<Users>) 返回用户列表
	 * 编写人：关宏宇 2010年8月8日
	 * 最后修改人：关宏宇 2010年8月11日
	*/     
	public static ArrayList<Users> getUserList(int pagesize,int start,String whereString) throws SQLException{            
		Session session=null;            
		Connection conn=null;            
		PreparedStatement pst=null;            
		ResultSet rs=null;      
		ArrayList<Users> list=new ArrayList<Users>();
		try{                 
			session=HibernateSessionFactory.getSession();  
			session.flush();
			conn=session.connection();                   
			pst=conn.prepareCall("{call procdure_users_list(?,?,?)}");                 
			pst.setInt(1, pagesize); 
			pst.setInt(2, start); 
			pst.setString(3, whereString);
			rs=pst.executeQuery();   
			Users user=new Users();
			
			while(rs.next()){     
				int userid=rs.getInt("USERID");
				user=getUserById(userid);
				list.add(user);
			}                           
		}catch(Exception e){e.printStackTrace();}            
		finally{                 
			if(rs!=null){                      
				rs.close();                 
			}                 
			if(pst!=null){                     
				pst.close();                 
			}                 
			if(conn!=null){                      
				conn.close();                 
			}                 
			if(session!=null){                      
				//session.close();                 
			}            
		}
		return list;
	}
    
	
	 /*/测试mian函数
	public static void main(String [] args) throws SQLException{            
		//DB_Users td=new DB_Users();            
		//ArrayList<Users> arr=td.getUserList(10,0,"");
		//Users u=new Users();
		//for(int i=0;i<arr.size();i++){
			//u=arr.get(i);
			//System.out.println("UserID:"+u.getUserid()+" UserName:"+u.getName()+" PassWord:"+u.getPwd());
		//}
		String sql="where commid in (2,3,4,5)";
		int Count =0;
		Count=getUserCount(sql);
		System.out.println("总数"+Count);
		//DB_Users us=new DB_Users();
		//int num=us.queryUsersCount("");
		//System.out.println();	
		}*/ 
	 
}
