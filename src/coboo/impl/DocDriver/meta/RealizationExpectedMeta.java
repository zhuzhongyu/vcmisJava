 package coboo.impl.DocDriver.meta;

/**
 * 康复目标：训练对象经6个月训练后预期实现 对应字段 
 * cbkfxl_fanshen, cbkfxl_zhuo, cbkfxl_zhan,
 * cbkfxl_zhuanyi, cbkfxl_bxhqdly, cbkfxl_sxtj, cbkfxl_jinshi, cbkfxl_ctyw,
 * cbkfxl_xisu, cbkfxl_ruce, cbkfxl_jiaoliu, cbkfxl_zuojiawu, cbkfxl_cjshsh
 * 
 * @author 任笑言
 */
public class RealizationExpectedMeta extends Meta {
	public String metaname = "康复目标：训练对象经6个月训练后预期实现";
	String[] SIds = new String[] { "cbkfxl_fanshen:fs", "cbkfxl_zhuo:aa",
			"cbkfxl_zhan:zhan", "cbkfxl_zhuanyi:zy1", "cbkfxl_bxhqdly:bx", "cbkfxl_sxtj:sxtj",
			"cbkfxl_jinshi:js", "cbkfxl_ctyw:ctyw", "cbkfxl_xisu:xs", "cbkfxl_ruce:rc",
			"cbkfxl_jiaoliu:jl", "cbkfxl_zuojiawu:zjw", "cbkfxl_cjshsh:sjshsh" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[13];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		SValues[2] = readValueList[2];
		SValues[3] = readValueList[3];
		SValues[4] = readValueList[4];
		SValues[5] = readValueList[5];
		SValues[6] = readValueList[6];
		SValues[7] = readValueList[7];
		SValues[8] = readValueList[8];
		SValues[9] = readValueList[9];
		SValues[10] = readValueList[10];
		SValues[11] = readValueList[11];
		SValues[12] = readValueList[12];
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "翻身/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "坐/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "站/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "转移/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "步行或驱动轮椅/";
		}
		if (storeValueList[5].equals("true")) {
			HValue += "上下台阶/";
		}
		if (storeValueList[6].equals("true")) {
			HValue += "进食/";
		}
		if (storeValueList[7].equals("true")) {
			HValue += "穿脱衣物/";
		}
		if (storeValueList[8].equals("true")) {
			HValue += "洗漱/";
		}
		if (storeValueList[9].equals("true")) {
			HValue += "入厕/";
		}
		if (storeValueList[10].equals("true")) {
			HValue += "交流/";
		}
		if (storeValueList[11].equals("true")) {
			HValue += "做家务/";
		}
		if (storeValueList[12].equals("true")) {
			HValue += "参加社会活动/";
		}
		top();
		return;
	}

	public RealizationExpectedMeta() {
		top();
	}

	void top() {
		super.SIds = SIds;
		super.SValues = SValues;
		super.HValue = HValue;
		super.metaname = metaname;
	}

	/**
	 * @return the sValues
	 */
	public String[] getSValues() {
		return SValues;
	}

	/**
	 * @param sValues
	 *            the sValues to set
	 */
	public void setSValues(String[] sValues) {
		SValues = sValues;
		con_svalue2hvalue(SValues);
	}

	/**
	 * @return the hValue
	 */
	public String getHValue() {
	
		return HValue;
	}

	/**
	 * @param hValue
	 *            the hValue to set
	 */
	public void setHValue(String hValue) {
		HValue = hValue;
		con_hvalue2svalue(HValue);
	}

	/**
	 * @return the sIds
	 */
	public String[] getSIds() {
		return SIds;
	}

	public String getMetaName() {
		return metaname;
	}

	/**
	 * @param sIds the sIds to set
	 */
	public void setSIds(String[] sIds) {
		SIds = sIds;
	}
}