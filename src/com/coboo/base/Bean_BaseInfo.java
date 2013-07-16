package com.coboo.base;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import com.datebase.Community;



/**
 * 程序的基本信息和临时配置的封装
 * @author Administrator
 *
 */
/**
 * 2010-7-26 添加新生儿全局变量
 * @param CHILDREN_AGE_Y 
 * 最后修改人：王振东
 * 添加录入统计表所需变量 
 * OA_STAT_LRB  CA_STAT_LRB
 */
public class Bean_BaseInfo 
{

	
	//---授权号---
	public static String sKey = "";
	
	//区与社区数据库标识
	public static final String DISTRICT = "qu";//社区表Community中表示区及机构的数据库标识
	public static final String COMMUNITY = "community";//社区表Community中表示区及机构的数据库标识	
	
	//儿童、老年人年龄配置（老年人、儿童的查询、统计会用到）
	public static final int CHILDREN_AGE = 3; //系统中定义的儿童年龄的上限（根据卫生部标准，0~36个月儿童，所以规定儿童年龄上限为3岁）
	public static final int OLD_AGE = 65; //系统中定义的老年人年龄的下限
	public static final int CHILDREN_AGE_Y = 1; //系统中定义的新生儿的年龄 1岁以下为新生儿
	//录入统计表
	public static final int OA_STAT_LRB = 65; //录入统计表中需要的老年人年龄的下限
	public static final int CA_STAT_LRB = 3;//录入统计表中需要的儿童的年龄
	
	//户主标识
	public static final String HZ = "本人";//户主标识
	
	//各项查询统计标识
	public static final String NODE_JKTJB = "jktj"; //健康体检表
	
	public static final String NODE_FNBJ = "fnbj";//妇女保健
	public static final String NODE_FNJCJL = "fnjcjl";//妇女检查记录
	public static final String NODE_FNBCZDJ = "fnbczdj";//妇女表查治登记
	public static final String NODE_JHSYPC = "jhsypc";//计划生育普查
	public static final String NODE_JHSYDJ = "jhsydj";//计划生育登记
	
	public static final String NODE_YCF = "ycf";//孕产妇
	public static final String NODE_DYCCQSFFWJLB = "dyc";//第1次产前随访服务记录表
	public static final String NODE_DEDWCCQSFFWJLB = "dedwc";//第2~5次产前随访服务记录表
	public static final String NODE_CHFSJLB = "chfsjl";//产后访视记录表
	public static final String NODE_CHSSETJKJCJLB = "chjkjc";//产后42天健康检查记录表
	
	public static final String NODE_ETBJ = "etbj";//儿童保健
	public static final String NODE_XSEJTFSJLB = "xse";//新生儿家庭访视记录表
	public static final String NODE_YSYNETSFFWJLB = "ysyn";//1岁以内儿童随访服务记录表
	public static final String NODE_YDESETSFFWJLB = "ydes";//1~2以内儿童随访服务记录表
	public static final String NODE_SSETSFFWJLB = "ss";//3岁儿童随访服务记录表
	
	public static final String NODE_MXBGL = "mxbgl"; //高血压标识
	public static final String NODE_GXY = "gxy"; //高血压标识
	public static final String NODE_TNB = "tnb"; //糖尿病标识
	public static final String NODE_GXB = "gxb"; //冠心病
	public static final String NODE_NZZ = "nzz"; //脑卒中
	public static final String NODE_ZL = "zl";   //肿瘤
	
	public static final String NODE_JHMY = "jhmy";//计划免疫
	public static final String NODE_MYJZGL = "myjzgl";//免疫接种管理
	public static final String NODE_MYXXGL = "myxxgl";//免疫信息管理	
	
	public static final String NODE_KFXXGL = "kfxx";//康复信息管理
	public static final String NODE_CJ = "cj";//残疾人登记
	
	public static final String NODE_ZTKFXL = "ztkfxl";//肢体康复训练
	public static final String NODE_ZCXLDJ = "zcxldj";//肢残训练登记
	public static final String NODE_ZCXLPG = "zcxldj";//肢残训练评估
	public static final String NODE_ZCXLJH = "zcxldj";//肢残训练计划
	public static final String NODE_ZCXLJL = "zcxldj";//肢残训练记录
	
	public static final String NODE_JSBGL = "jsbgl";//精神病管理
	public static final String NODE_JSBRDJ = "jsbrdj";//精神病人登记
	public static final String NODE_JSBFSJL = "jsbfsjl";//精神病访视记录

	public static final String NODE_SXZZ_ZC = "zc";//双向转诊——转出
	public static final String NODE_SXZZ_HZ = "hz";//双向转诊——回转
	
	//传染病标识，当初为查询、统计传染病而定义，但因为现在系统已经不涉及传染病查询统计，因此此标识已被忽略
	public static final String NODE_CRB = "crb";//传染病标识
	//老年人标识
	public static final String LNR = "老年人";//老年人
	
	//档案中表的标识
	public static final String TABLE_GRJBXX = "grjbxx"; //个人基本信息表
	public static final String TABLE_ZZ_OUT = "zz_out";//双向转诊——转出表
	public static final String TABLE_ZZ_IN = "zz_in"; //双向转诊——回转表
	
	//社区封装
	public static ArrayList<Community> list_comm = new ArrayList<Community>();
	
	//报表列数
	public static final int COLUMN_COUNT = 9;
	
	//项目路径封装
	public static String webappsdir;
	public static String coboodir;
	public static String httpUrl;
	public static String project;
	public static String indexdir;
	public static String indexdir_2nd;
	public static String template;
	public static String index;
	public static String daurl;
	public static String daemon;
	
	public static String formworkOfPrint;
	public static String printUrl;
	public static String LockForPrint;
	
	public static String replacePath;
	
	//文档路径
	public static String normalfilesPath;
	
	//数据库中个人档案的路径信息
	private static String grda_url;
	//个人体检表的身高和体重
	public static String Height;
	public static String Weight;
	public static String McpjTime;
	public static String YcqTime;
	/**
	 * 将14位数字（年4位，月2位，日2位，小时2位，分钟2位，秒2位）时间格式串转换为 yyyy-MM-dd hh:mm:ss的时间格式，以方便在程序中显示
	 * @param time 14位数字时间格式
	 * @return yyyy-MM-dd hh:mm:ss 时间格式
	 */
	public static String changeTime(String time)
	{
		if(time==null||time=="")
		{
			return "";
		}
		
		String year = time.substring(0,4);
		String month = time.substring(4,6);
		String date = time.substring(6,8);
		String hour = time.substring(8,10);
		String min = time.substring(10,12);
		String sec = time.substring(12,14);
		
		return year+"-"+month+"-"+date+" "+hour+":"+min+":"+sec;
	}
	
	/**
	 * 删除所有报表
	 * @param url
	 */
	public static void deleteAllReports()
	{
		try{
			String url = Bean_BaseInfo.webappsdir+Bean_BaseInfo.project+"report";
			File files = new File(url);
			File[]r = files.listFiles();
			if(r!=null&&r.length>0){
				for(int i=0;i<r.length;i++)
				{
					String name = r[i].getName();			
					if(name.endsWith("xls"))
					{
						Calendar can = Calendar.getInstance();
						can.set(Calendar.MONTH, can.get(Calendar.MONTH)-1);
						long time = can.getTime().getTime();
						long t = r[i].lastModified();
						if(t<time)
						{
							r[i].delete();
						}				
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 四舍五入方法，并且保留两位小数。
	 * @param num 要四舍五入的数字
	 * @return 四舍五入后的两位小数
	 */
	public static double round(double num)
	{
		BigDecimal b = new BigDecimal(Double.toString(num));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one,2,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	


	/**
	 * 将生成的个人档案编号拆分为16个数字字符
	 * @param id 个人档案编号
	 * @return 16个数字字符
	 */
	public static String[] splitId(String id)
	{
		OutString.out(id);
		char[]chid = id.toCharArray();
		String[]sid = new String[chid.length];
		for(int i=0;i<sid.length;i++)
		{
			sid[i] = String.valueOf(chid[i]);
		}
		
		return sid;
	}
}
