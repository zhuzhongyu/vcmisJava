package com.coboo.userRights;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.datebase.Community;
import com.datebase.HibernateSessionFactory;
import com.datebase.Users;

public class UserOper {

	public static void delete(String hql_where){
		Session session=HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();

		tr = session.beginTransaction();
		String hqlUpdate =  "delete from Users where "+hql_where;
		
		@SuppressWarnings("unused")
		int  updatedEntities = session.createQuery(hqlUpdate)
//		.setString( "newNum", nums_)
		.executeUpdate();
		tr.commit();
		session.close();
	}

	/**
	 * 根据监听管理员的操作冻结其选择的用户
	 * @param hql_where String 传递过来的条件
	 * 编写人：关宏宇
	 * 最后修改人：关宏宇
	*/
	public static void freeze(String hql_where){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		tr=session.beginTransaction();
		String hqlUpdate="update Users set laselogtime = 'no' where "+hql_where;
		@SuppressWarnings("unused")
		int updateEntities =session.createQuery(hqlUpdate).executeUpdate();
		tr.commit();
		session.close();
	}
	/**
	 * 根据监听管理员的操作激活其选择的用户
	 * @param hql_where String 传递过来的条件
	 * 编写人：关宏宇
	 * 最后修改人：关宏宇
	*/
	public static void activate(String hql_where){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		tr=session.beginTransaction();
		String hqlUpdate="update Users set laselogtime = '' where "+hql_where;
		@SuppressWarnings("unused")
		int updateEntities =session.createQuery(hqlUpdate).executeUpdate();
		tr.commit();
		session.close();
	}
	/**
	 * 修改用户密码
	 * @param Password 新用户密码
	 * @param hql_where 传递过来的条件
	 * @return updateEntities 返回int型返回值
	 * 编写人:关宏宇
	 * 最后修改人:关宏宇
	*/
	public static int UpdatePwd(String Password, String hql_where){
		Session session = HibernateSessionFactory.getSession();
		Transaction tr=session.beginTransaction();
		tr=session.beginTransaction();
		String hqlUpdate="update Users set pwd='"+Password+"' where "+hql_where;
		@SuppressWarnings("unused")
		int updateEntities =session.createQuery(hqlUpdate).executeUpdate();
		tr.commit();
		session.close();
		return updateEntities;
	}
	
	/**
	 * ���������ݴ������û���ʶ�ţ�creatCode����ô����ߴ���������û���ʶ�ţ�maxUserCode�����������ݴ������û���ʶ�ţ�creatCode����ô����ߴ���������û���ʶ�ţ�maxUserCode��根据creatCode与maxUserCode生成creatCode下级新用户号����¼��û���ʶ�ţ�
	 * 
	 * @param creatCode �������û���ʶ�ţ�
	 * @param maxUserCode ����û���ʶ�ţ�
	 * @return ���û����û���ʶ�š�
	 */
	public static String CreatNewNextLevUserCode(String creatCode,String maxUserCode){
		String cuc = creatCode;
		System.out.println("创建者"+creatCode);
		String[] code = cuc.split("\\.");
		String[] code1 = maxUserCode.split("\\.");
		String reStr = "";
		for(int i = 0;i<code.length;i++){
			if(code[i].equals("0")){
				code1[i] = String.valueOf(Integer.valueOf(code1[i]).intValue() + 1);
				break;
			}
		}
		
		for(int j=0;j<code1.length;j++){
			reStr += code1[j];
			if(j < code1.length-1){
				reStr +=".";
			}
		}
		System.out.println("UserOper.CreatNewNextLevUserCode:"+reStr);
		return reStr;
	}

	
	/**
	 * ���������ݴ������û���ʶ�ţ�creatCode����ô����ߴ���������û���ʶ�ţ�maxUserCode��根据creatCode与maxUserCode生成creatCode同级新用户号
	 * @param creatCode �������û���ʶ�ţ�
	 * @param maxUserCode ����û���ʶ�ţ�
	 * @return ���û����û���ʶ�š�
	 */
	public static String CreatNewSameLevUserCode(String creatCode,String maxUserCode){
		String cuc = creatCode;
		System.out.println("创建者"+creatCode);
		String[] code = cuc.split("\\.");
		String[] code1 = maxUserCode.split("\\.");
		String reStr = "";
		for(int i = 0;i<code.length;i++){
			if(code[i].equals("0")){
				code1[i-1] = String.valueOf(Integer.valueOf(code1[i-1]).intValue() + 1);
				break;
			}
		}
		
		for(int j=0;j<code1.length;j++){
			reStr += code1[j];
			if(j < code1.length-1){
				reStr +=".";
			}
		}
		System.out.println("UserOper.CreatNewSameLevUserCode:"+reStr);
		return reStr;
	}
	
	
	/**
	 * 得到list_users中用户表示号最大的一个。 
	 * @param list_users �б�
	 * @return ����û���ʶ�š�
	 */
	public static String getMaxUserCode(int sing,ArrayList<Users> list_users){
		
		ArrayList<Users> list_users_bak = new ArrayList<Users>();
		
		if(sing < 3){
			for(int i=0;i<list_users.size();i++){
				if(list_users.get(i).getUsercode().split("\\.")[sing+1].equals("0")){
					list_users_bak.add(list_users.get(i));
				}
			}
		}else{
			list_users_bak = list_users;
		}
		
		String srccode = "1.1.1.1";
		String[] user_max = srccode.split("\\.");;
		String[] user_index = null;
		String reStr = "";
		System.out.println("******************************************"+list_users_bak.size());
		int max_code = 0;
		int index_code = 0;
		System.out.println(sing);
		if(list_users_bak != null && list_users_bak.size() != 0){
			for(int i=0;i<list_users_bak.size();i++){
				if(i == 0){
					user_max = list_users_bak.get(0).getUsercode().split("\\.");
				}else{
					user_index = list_users_bak.get(i).getUsercode().split("\\.");
					max_code = Integer.valueOf(user_max[sing]).intValue();
					index_code = Integer.valueOf(user_index[sing]).intValue();
					if(max_code < index_code){
						user_max = user_index;
					}
				}
			}
		}else{
			for(int j=0;j<user_max.length;j++){
				if(j >= sing){
					user_max[j] = "0";
				}
			}
		}
		
		
		for(int j=0;j<user_max.length;j++){
			reStr += user_max[j];
			if(j < user_max.length-1){
				reStr +=".";
			}
		}
		System.out.println("UserOper.getMaxUserCode:"+reStr);
		return reStr;
	}
	
	
	public static String mathUserCodeStyle(String usercode,String arealev){
		
		String[] user_code = usercode.split("\\.");
		String re_str = "";
		for(int i = 0;i<user_code.length;i++){
			if(arealev.equals("community")){
				if(i < user_code.length-1){
					if(user_code[i].equals("0")){
						user_code[i] = "1";
					}
				}else
				if(i == user_code.length-1){
					user_code[i] = "0";
				}
			}
			if(arealev.equals("qu")){
				if(i > 1){
					user_code[i] = "0";
				}else{
					if(user_code[i].equals("0")){
						user_code[i] = "1";
					}
				}
			}
			if(arealev.equals("city")){
				if(i > 0){
					user_code[i] = "0";
				}else{
					if(user_code[0].equals("0")){
						user_code[0] = "1";
					}
				}
			}
			
			re_str += user_code[i];
			if(i < user_code.length-1){
				re_str +=".";
			}
		}
		System.out.println("UserOper.mathUserCodeStyle:"+re_str);
		return re_str;
	}
	
	
	/**
	 * 根据commid得到一个完整的市、区、卫生服务站的树结构。
	 * @param commid 市、区、卫生服务站id
	 * @param list_community 所有机构
	 * @return
	 */
	public static ArrayList<Community> GetCommunityTree(Integer commid,ArrayList<Community> list_community){
		ArrayList<Community> list_return = new ArrayList<Community>();
		Community community = new Community();
		Community qu = new Community();
		Community city = new Community();
		Community temp = null;
		for(int i=0;i<list_community.size();i++){
			temp = list_community.get(i);
			if(temp.getId().intValue() == commid.intValue()){
				break;
			}
		}
		
		if(temp.getArealev().equals("city")){
			city = temp;
			qu = temp;//.setNameOfCommunity("市直用户");
			community = temp;//.setNameOfCommunity("市直用户");
		}else
		if(temp.getArealev().equals("qu")){
			qu = temp;
			community = temp;
			for(int i=0;i<list_community.size();i++){
				temp = list_community.get(i);
				if(temp.getId().intValue() == qu.getIsglzx().intValue() && temp.getArealev().equals("city")){
					city = temp;
					break;
				}
			}
//			community.setNameOfCommunity("区直用户");
		}else
		if(temp.getArealev().equals("community")){
			community = temp;
			//---开始找 区 单位。
			for(int i=0;i<list_community.size();i++){
				temp = list_community.get(i);
				if(temp.getId().intValue() == community.getIsglzx().intValue() && temp.getArealev().equals("qu")){
					qu = temp;
					break;
				}
			}
			//---开始找 市 单位。
			for(int i=0;i<list_community.size();i++){
				temp = list_community.get(i);
				if(temp.getId().intValue() == qu.getIsglzx().intValue() && temp.getArealev().equals("city")){
					city = temp;
					break;
				}
			}
		}
		list_return.add(city);
		list_return.add(qu);
		list_return.add(community);
		return list_return;
	}
}
