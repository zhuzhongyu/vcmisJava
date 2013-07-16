package com.coboo.find;

import java.util.ArrayList;
import java.util.List;
import com.common.*;
import com.datebase.Xzqy;
public class Xzqydao {

	
		
	  @SuppressWarnings("unchecked")
	public static List<Xzqy> gettown(String number){
		 String hql = "from Xzqy x where x.number like '"+number+"%'"; 
		 List<Xzqy> list= (List<Xzqy>)Common.select(hql);
		 List<Xzqy> xzqys = new ArrayList<Xzqy> ();
		 for(Xzqy com : list){
			  String[] str =com.getNumber().split("-");
			  if(str.length == 3){
				  xzqys.add(com);
			  }
		 }
		  Common.close();
		  return xzqys;
	  }
	  

	  public static void main(String[] args){
		  List<Xzqy> list = Xzqydao.gettown("211002");
		  for(Xzqy com:list){
			  System.out.println(com.getName());
		  }
	  }

}
