package com.coboo.base.db;

import java.util.List;
import org.hibernate.*;
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
    
    public void close()
    {
        try 
        {
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
    
    public int deleteRows(String sql)
    {
    	int ret = 0;
    	try
        {
        	Query query = session.createSQLQuery(sql);
        	ret = query.executeUpdate();
        } 
        catch (Exception ex) 
        {
        	ex.printStackTrace();
        }
        return ret;
    }
    
    public int insert(Object ob)
    {
        int ret = 0;
    	try
        {
           session.save(ob);
           ret  =1;
        } 
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
        
        return ret;
    }
    
    public void update(Object obj)
    {
    	try
    	{
			session.update(obj);
		}
    	catch (Exception e) 
		{
			e.printStackTrace();
		}
    }
    
    public int delete(Object obj)
    {
    	int ret = 0;
    	try
    	{
			session.delete(obj);
			ret = 1;
		}
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	
    	return ret;
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
    
    @SuppressWarnings("unchecked")
	public Object getObjectById(Class cls,Integer id)
    {
    	return session.get(cls,id);
    }
    
    @SuppressWarnings("unchecked")
	public Object getObjectById(Class cls,String id)
    {
    	return session.get(cls,id);
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
}
