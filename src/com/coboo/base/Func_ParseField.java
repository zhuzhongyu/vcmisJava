package com.coboo.base;

public class Func_ParseField
{
	/**
	 * 根据性别返回数值
	 * @param gender
	 * @return
	 */
	public static int parseGender(String gender)
	{
		if(Func_String.isNotNullAndEmpty(gender))
		{
			if(gender.equals("未知的性别"))
			{
				return 0;
			}
			else if(gender.equals("男"))
			{
				return 1;
			}
			else if(gender.equals("女"))
			{
				return 2;
			}
			else if(gender.equals("未说明的性别"))
			{
				return 9;
			}
		}		
		
		return 99;
	}
	/**
	 * 根据民族返回编号
	 * @param nation
	 * @return
	 */
	public static int parseNation(String nation)
	{
		if(Func_String.isNotNullAndEmpty(nation))
		{
			if(nation.equals("汉族"))
			{
				return 1;
			}
			else if(nation.equals("少数民族"))
			{
				return 2;
			}
		}
		
		return 99;
	}
	/**
	 * 根据婚姻状态返回编号
	 * @param marriageStatus
	 * @return
	 */
	public static int parseMarriageStatus(String marriageStatus)
	{
		if(Func_String.isNotNullAndEmpty(marriageStatus))
		{
			if(marriageStatus.equals("未婚"))
			{
				return 1;
			}
			else if(marriageStatus.equals("已婚"))
			{
				return 2;
			}
			else if(marriageStatus.equals("丧偶"))
			{
				return 3;
			}
			else if(marriageStatus.equals("离婚"))
			{
				return 4;
			}
			else if(marriageStatus.equals("未说明的婚姻状况"))
			{
				return 5;
			}			
		}
		
		return 99;
	}
	/**
	 * 根据教育程度返回编号
	 * @param education
	 * @return
	 */
	public static int parseEducation(String education)
	{
		if(Func_String.isNotNullAndEmpty(education))
		{
			if(education.equals("文盲及半文肓"))
			{
				return 1;
			}
			else if(education.equals("小学"))
			{
				return 2;
			}
			else if(education.equals("初中"))
			{
				return 3;
			}
			else if(education.equals("高中/技校/中专"))
			{
				return 4;
			}
			else if(education.equals("大学专科及以上"))
			{
				return 5;
			}
			else if(education.equals("不详"))
			{
				return 6;
			}
		}
		
		return 99;
	}
	/**
	 * 根据常住类型返回编号
	 * @param czlx
	 * @return
	 */
	public static int parseCzlx(String czlx)
	{
		if(Func_String.isNotNullAndEmpty(czlx))
		{
			if(czlx.equals("户籍"))
			{
				return 1;
			}
			else if(czlx.equals("非户籍"))
			{
				return 2;
			}
		}
		
		return 99;
	}
	/**
	 * 根据与户主关系返回编号
	 * @param relationWithHeadOfHousehold
	 * @return
	 */
	public static int parserelationWithHeadOfHousehold(String relationWithHeadOfHousehold)
	{
		if(Func_String.isNotNullAndEmpty(relationWithHeadOfHousehold))
		{
			if(relationWithHeadOfHousehold.equals("本人"))
			{
				return 1;
			}
			else if(relationWithHeadOfHousehold.equals("丈夫"))
			{
				return 2;
			}
			else if(relationWithHeadOfHousehold.equals("妻子"))
			{
				return 3;
			}
			else if(relationWithHeadOfHousehold.equals("父亲"))
			{
				return 4;
			}
			else if(relationWithHeadOfHousehold.equals("母亲"))
			{
				return 5;
			}
			else if(relationWithHeadOfHousehold.equals("儿子"))
			{
				return 6;
			}
			else if(relationWithHeadOfHousehold.equals("女儿"))
			{
				return 7;
			}
			else if(relationWithHeadOfHousehold.equals("孙子"))
			{
				return 8;
			}
			else if(relationWithHeadOfHousehold.equals("孙女"))
			{
				return 9;
			}
			else if(relationWithHeadOfHousehold.equals("外孙子"))
			{
				return 10;
			}
			else if(relationWithHeadOfHousehold.equals("外孙女"))
			{
				return 11;
			}
			else if(relationWithHeadOfHousehold.equals("其它"))
			{
				return 12;
			}
		}
		else
		{
			if(relationWithHeadOfHousehold==null)
			{
				return 99;
			}
			else
			{
				return 999;
			}
		}
		
		return 99;
	}	
	/**
	 * 根据人员类别返回编号
	 * @param kind
	 * @return
	 */
	public static String parsePersonKind(String kind)
	{
		if(Func_String.isNotNullAndEmpty(kind))
		{
			if(kind.equals("全部"))
			{
				return "all";
			}
			else if(kind.equals("儿童"))
			{
				return Bean_BaseInfo.NODE_ETBJ;
			}
			else if(kind.equals("老年人"))
			{
				return Bean_BaseInfo.LNR;
			}
			else if(kind.equals("孕产妇"))
			{
				return Bean_BaseInfo.NODE_YCF;
			}
			else if(kind.equals("重性精神病"))
			{
				return Bean_BaseInfo.NODE_JSBFSJL;
			}
			else if(kind.equals("高血压"))
			{
				return Bean_BaseInfo.NODE_GXY;
			}
			else if(kind.equals("糖尿病"))
			{
				return Bean_BaseInfo.NODE_TNB;
			}
			else if(kind.equals("冠心病"))
			{
				return Bean_BaseInfo.NODE_GXB;
			}
			else if(kind.equals("脑卒中"))
			{
				return Bean_BaseInfo.NODE_NZZ;
			}
			else if(kind.equals("肿瘤"))
			{
				return Bean_BaseInfo.NODE_ZL;
			}
		}
		
		return "no";
	}
	/**
	 * 报表统计：根据人员类别返回编号
	 * @param kind
	 * @return
	 */
	public static String parsePersonKindForReport(String kind)
	{
		if(Func_String.isNotNullAndEmpty(kind))
		{
			if(kind.equals("新生儿"))
			{
				return Bean_BaseInfo.NODE_XSEJTFSJLB;
			}
			else if(kind.equals("3岁以下儿童"))
			{
				return Bean_BaseInfo.NODE_ETBJ;
			}
			else if(kind.equals("65岁以上老人"))
			{
				return Bean_BaseInfo.LNR;
			}
			else if(kind.equals("孕产妇"))
			{
				return Bean_BaseInfo.NODE_YCF;
			}
			else if(kind.equals("重性精神疾病"))
			{
				return Bean_BaseInfo.NODE_JSBGL;
			}
			else if(kind.equals("高血压患者"))
			{
				return Bean_BaseInfo.NODE_GXY;
			}
			else if(kind.equals("糖尿病患者"))
			{
				return Bean_BaseInfo.NODE_TNB;
			}
			else if(kind.equals("冠心病患者"))
			{
				return Bean_BaseInfo.NODE_GXB;
			}
			else if(kind.equals("脑卒中患者"))
			{
				return Bean_BaseInfo.NODE_NZZ;
			}
			else if(kind.equals("肿瘤患者"))
			{
				return Bean_BaseInfo.NODE_ZL;
			}
			else if(kind.equals("残疾人"))
			{
				return Bean_BaseInfo.NODE_CJ;
			}
		}
		
		return "no";
	}
	/**
	 * 根据消息状态返回编号
	 * @param state
	 * @return
	 */
	public static int parseMessageState(String state)
	{
		if(state.equals("已经处理"))
		{
			return 1;
		}
		else if(state.equals("稍后处理"))
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}
	/**
	 * 根据消息状态编号返回消息状态
	 * @param state
	 * @return
	 */
	public static String parseMessageState(int state)
	{
		if(state==1)
		{
			return "已经处理";
		}
		else if(state==2)
		{
			return "稍后处理";
		}
		else
		{
			return "等待被统通知者查看";
		}
	}
	/**
	 * 根据处理消息返回编号
	 * @param state
	 * @return
	 */
	public static int parseDoMessageState(String state)
	{
		if(state.equals("马上处理"))
		{
			return 1;
		}
		
		return 2;
	}
}
