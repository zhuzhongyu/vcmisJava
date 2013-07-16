package com.common;

import java.util.List;
import org.hibernate.*;
import com.datebase.HibernateSessionFactory;
import java.util.Iterator;

public class HibernateDBManager 
{
	private Session session = null;
	private Transaction tr;

    public HibernateDBManager() 
    {
    	
    }
    
    public void open()
    {
        try 
        {
            session = HibernateSessionFactory.getSession();
            tr = session.beginTransaction();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
    }
    
    public void flush()
    {
        try 
        {
            session.flush();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
    }
    
    public void close()
    {
        try 
        {
//        	if (session != null && session.isOpen()) {   
//      		session.close();
//          }  

            session.close();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public List query(String hql)
    {
    	List list = null;
        try
        {
        	list = session.createQuery(hql).list();
        	session.clear();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public Iterator complexQuery(String hql)
    {
    	Iterator i = null;
        try
        {
        	i = session.createQuery(hql).list().iterator();
        	session.clear();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
        return i;
    }
    
    public SQLQuery sqlQuery(String sql)
    {
    	SQLQuery query = null;
        try
        {
        	query = session.createSQLQuery(sql);
        	session.clear();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
        return query;
    }
    
    
    public int insert(Object ob)
    {
        int ret;
        
    	try
        {
           session.save(ob);
        } 
        catch (Exception ex)
        {
        	ex.printStackTrace();
        	return -1;
        }
        return 1;
    }
    
    public int update(Object obj)
    {
    	try
    	{
			session.update(obj);
		}
    	catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
		}
    	return 1;
    }
    
    public int delete(Object obj)
    {
    	try
    	{
			session.delete(obj);
		}
    	catch (Exception e) 
    	{
			e.printStackTrace();
			return -1;
		}
    	return 1;
    }
    
    public int update(String hql)
    {
    	 try
         {
            
         	return session.createQuery(hql).executeUpdate();
         } 
         catch (Exception ex) 
         {
         	ex.printStackTrace();
         }
         return -1;
    }
    
    public void commit()
    {
        try 
        {
           tr.commit();
           session.flush();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
    }
    
    public void refresh(Object obj)
    {
    	try
    	{
			session.refresh(obj);
		}
    	catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
}
