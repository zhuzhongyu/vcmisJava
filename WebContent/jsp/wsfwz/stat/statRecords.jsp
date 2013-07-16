<%@ page language="java" import="java.util.*,com.common.*, com.datebase.* ,coboo.config.*, coboo.service.*, coboo.document.* " pageEncoding="UTF-8"%>

<%
  response.setContentType("text/xml");
  String number = request.getParameter("number");
  String xzArr[] =  number.split(";");
  
  
  StringBuffer sb=new StringBuffer(); //向用户传递数据的字符流
  sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
  sb.append("<datas>");
  long sum = 0;
  //妇女统计
  String women1 = "<womenCheckInfoTab>true</womenCheckInfoTab>";
  String women2 = "<womenDiseaseCheckInfoTab>true</womenDiseaseCheckInfoTab>";
  String women3 = "<SecondToFifthTimesAntenatalFollowUpRecordTab>true</SecondToFifthTimesAntenatalFollowUpRecordTab>";
  String women4 = "<PostpartumFortyTowDaysCheckRecordTab>true</PostpartumFortyTowDaysCheckRecordTab>";
  String women5 = "<FirstTimesAntenatalFollowUpRecordTab>true</FirstTimesAntenatalFollowUpRecordTab>";    
    
  //孕妇统计                   
  String pregnant1 = "<SecondToFifthTimesAntenatalFollowUpRecordTab>true</SecondToFifthTimesAntenatalFollowUpRecordTab>";
  String pregnant2 = "<PostpartumFortyTowDaysCheckRecordTab>true</PostpartumFortyTowDaysCheckRecordTab>";
  String pregnant3 = "<FirstTimesAntenatalFollowUpRecordTab>true</FirstTimesAntenatalFollowUpRecordTab>";
                        
  //残疾人统计
  String disable = "<DisabledRegisterTab>true</DisabledRegisterTab>";
  
  //重度精神病
  String jsb = "<jsbgl>true</jsbgl>";
  
  //慢性病
  String mxb1 = "<tnb>true</tnb>";
  String mxb2 = "<gxb>true</gxb>";
  String mxb3 = "<zl>true</zl>";
  String mxb4 = "<nzz>true</nzz>";
  String mxb5 = "<gxy>true</gxy>";      

  for(int i=0; i<xzArr.length; i++)
	{
     String hql = "from Xzqy where number like '" + xzArr[i] + "%'";
     ArrayList<Xzqy> list = (ArrayList<Xzqy>) Common.select(hql);
		 for(int j = 0; j< list.size(); j++)
		 {
				Xzqy xzqy = list.get(j);
        if(xzqy.getLevel() == 3)
        {
          int rel = sb.indexOf("<code>" + xzqy.getNumber()+ "</code>");
  				if(rel > 0) continue;
          
          sb.append("<data>");
          sb.append("<code>" + xzqy.getNumber()+ "</code>");
  		  	sb.append("<name>" + xzqy.getName() + "</name>");
          sb.append("<peoples>" + xzqy.getPeoples() + "</peoples>");
 
          String bh[] =  xzqy.getNumber().split("-");
          String code = bh[0] + bh[1] + bh[2];
  
      //档案数量    
         String st = "<k><dah>" + code + "*</dah></k>";
         XmlParser p = new XmlParser();
         String[] fieldNames = p.getKeys(st);
	       String[] fieldValues = p.getValues(st);
         int num =coboo.service.IService.statAnd(fieldNames,fieldValues); 
         
         sum = sum + num;
         sb.append("<count>" + String.valueOf(num) + "</count>");

        
         //妇女数量
         String  st1 = "<key><dah>" + code + "*</dah>" + women1 + "</key>";
         XmlParser p1 = new XmlParser();
         String[] fieldNames1 = p1.getKeys(st1);
	       String[] fieldValues1 = p1.getValues(st1);
          int num1 =coboo.service.IService.statAnd(fieldNames1,fieldValues1); 
          
          String st2 = "<key><dah>" + code + "*</dah>" + women2 + "</key>";
          XmlParser p2 = new XmlParser();
          String[] fieldNames2 = p2.getKeys(st2);
	        String[] fieldValues2 = p2.getValues(st2);
          int num2 =coboo.service.IService.statAnd(fieldNames2,fieldValues2); 
          
          String st3 = "<key><dah>" + code + "*</dah>" + women3 + "</key>";
          XmlParser p3 = new XmlParser();
          String[] fieldNames3 = p3.getKeys(st3);
	        String[] fieldValues3 = p3.getValues(st3);
          int num3 =coboo.service.IService.statAnd(fieldNames3,fieldValues3); 
          
          String st4 = "<key><dah>" + code + "*</dah>" + women4 + "</key>";
          XmlParser p4 = new XmlParser();
          String[] fieldNames4 = p4.getKeys(st4);
	        String[] fieldValues4 = p4.getValues(st4);
          int num4 =coboo.service.IService.statAnd(fieldNames4,fieldValues4); 
          
          String st5 = "<key><dah>" + code + "*</dah>" + women5 + "</key>";
          XmlParser p5 = new XmlParser();
          String[] fieldNames5 = p5.getKeys(st5);
	        String[] fieldValues5 = p5.getValues(st5);
          int num5 =coboo.service.IService.statAnd(fieldNames5,fieldValues5); 
          sb.append("<women>" + String.valueOf(num1+num2+num3+num4+num5) + "</women>");
       
       //孕妇数量   
          String st11 = "<key><dah>" + code + "*</dah>" + pregnant1 + "</key>";
          XmlParser p11 = new XmlParser();
          String[] fieldNames11 = p11.getKeys(st11);
	        String[] fieldValues11 = p11.getValues(st11);
          int num11 =coboo.service.IService.statAnd(fieldNames11,fieldValues11); 
          
          String st12 = "<key><dah>" + code + "*</dah>" + pregnant2 + "</key>";
          XmlParser p12 = new XmlParser();
          String[] fieldNames12 = p12.getKeys(st12);
	        String[] fieldValues12 = p12.getValues(st12);
          int num12 =coboo.service.IService.statAnd(fieldNames12,fieldValues12); 
          
          String st13 = "<key><dah>" + code + "*</dah>" + pregnant3 + "</key>";
          XmlParser p13 = new XmlParser();
          String[] fieldNames13 = p13.getKeys(st13);
	        String[] fieldValues13 = p13.getValues(st13);
          int num13 =coboo.service.IService.statAnd(fieldNames13,fieldValues13); 
          sb.append("<pregnant>" + String.valueOf(num11+num12+num13) + "</pregnant>");
       
       //残疾人统计      
          String st21 = "<key><dah>" + code + "*</dah>" + disable + "</key>";
          XmlParser p21 = new XmlParser();
          String[] fieldNames21 = p21.getKeys(st21);
	        String[] fieldValues21 = p21.getValues(st21);
          int num21 =coboo.service.IService.statAnd(fieldNames21,fieldValues21); 
          sb.append("<disable>" + String.valueOf(num21) + "</disable>");
       
       //重度精神病   
          String st31 = "<key><dah>" + code + "*</dah>" + jsb + "</key>";
          XmlParser p31 = new XmlParser();
          String[] fieldNames31 = p31.getKeys(st31);
	        String[] fieldValues31 = p31.getValues(st31);
          int num31 =coboo.service.IService.statAnd(fieldNames31,fieldValues31); 
          sb.append("<jsb>" + String.valueOf(num31) + "</jsb>");
       
        //慢性病
          String st41 = "<key><dah>" + code + "*</dah>" + mxb1 + "</key>";
          XmlParser p41 = new XmlParser();
          String[] fieldNames41 = p41.getKeys(st41);
	        String[] fieldValues41 = p41.getValues(st41);
          int num41 =coboo.service.IService.statAnd(fieldNames41,fieldValues41); 
          
          String st42 = "<key><dah>" + code + "*</dah>" + mxb2 + "</key>";
          XmlParser p42 = new XmlParser();
          String[] fieldNames42 = p42.getKeys(st42);
	        String[] fieldValues42 = p42.getValues(st42);
          int num42 =coboo.service.IService.statAnd(fieldNames42,fieldValues42); 
          
          String st43 = "<key><dah>" + code + "*</dah>" + mxb3 + "</key>";
          XmlParser p43 = new XmlParser();
          String[] fieldNames43 = p43.getKeys(st43);
	        String[] fieldValues43 = p43.getValues(st43);
          int num43 =coboo.service.IService.statAnd(fieldNames43,fieldValues43); 
          
          String st44 = "<key><dah>" + code + "*</dah>" + mxb4 + "</key>";
          XmlParser p44 = new XmlParser();
          String[] fieldNames44 = p44.getKeys(st44);
	        String[] fieldValues44 = p44.getValues(st44);
          int num44 =coboo.service.IService.statAnd(fieldNames44,fieldValues44); 
          
          String st45 = "<key><dah>" + code + "*</dah>" + mxb5 + "</key>";
          XmlParser p45 = new XmlParser();
          String[] fieldNames45 = p45.getKeys(st45);
	        String[] fieldValues45 = p45.getValues(st45);
          int num45 =coboo.service.IService.statAnd(fieldNames45,fieldValues45); 
          sb.append("<mxb>" + String.valueOf(num41+num42+num43+num44+num45) + "</mxb>"); 
          
          sb.append("</data>");
        }
     }
  }
  
  sb.append("<sum>" + String.valueOf(sum) + "</sum>");
  sb.append("</datas>");
	out.println(sb.toString());	
	Common.close();
%>