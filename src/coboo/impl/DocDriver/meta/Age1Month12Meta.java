package coboo.impl.DocDriver.meta;

/**
 * 1-2岁内儿童--12月表
 * @author rxy
 *
 */
public class Age1Month12Meta extends Meta {
	String		metaname	= "1-2岁内儿童--12月表";
	String[]	SIds		= new String[] { 
			"HR42_02_057_1:sf4","HR51_02_004_1:sf5", "HR0", "HR1", "HR2", "HR51_02_00_1:sf6", "HR12", "HR13", "HR14", "cbms1:tg5",
			"HR51_02_014_1:tg9", "HR51_02_009_1:tg10", "s12", "HR51_02_197_1:tg12", "HR51_02_126_1", "s15", "HR51_02_032_1", "s17","HR51_02_086_1:tg19", "HR51_02_018_1:tg23", 
			"HR51_02_016_1:tg27", "CV5502_02_08_3", "cbhw1:hw2", "HR51_01_005_1:hw7", "HR51_02_118_1:fy1", "HR54_02_013_01_1:fy12", "cbqt1:fy16", "HR42_01_010_1:zz2",	"HR52_02_044_1", "HR21_01_022_1", 
			"HR51_01_004_1", "HR51_01_004_15", "HR51_01_004_19", "s33", "s34", "zhid1:HR51_01_004_23", "HR42_02_090_1:xzsfrq1", "cbsfysqm1:sfysqm1"};
	String[]	SValues		= new String[] { 
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", 
			"", "", "", "", "", "", "", "", "", "", 
			"" };
	String		HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[33];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		if (readValueList[2].equals("上"))
			SValues[2] = "true";
		if (readValueList[3].equals("中"))
			SValues[3] = "true";
		if (readValueList[4].equals("下"))
			SValues[4] = "true";
		SValues[5] = readValueList[5];
		if (readValueList[6].equals("上"))
			SValues[6] = "true";
		if (readValueList[7].equals("中"))
			SValues[7] = "true";
		if (readValueList[8].equals("下"))
			SValues[8] = "true";
		SValues[9] = readValueList[9];
		SValues[10] = readValueList[10];
		SValues[11] = readValueList[11];
		SValues[12] = readValueList[12];
		SValues[13] = readValueList[13];
		SValues[14] = readValueList[14];
		SValues[15] = readValueList[15];
		SValues[16] = readValueList[16];
		SValues[17] = readValueList[17];
		SValues[18] = readValueList[18];
		SValues[19] = readValueList[19];
		SValues[20] = readValueList[20];
		SValues[21] = readValueList[21];
		SValues[22] = readValueList[22];
		SValues[23] = readValueList[23];
		if (readValueList[24].equals("无")) {
			SValues[24] = "1";
		} else if (readValueList[24].equals("有")) {
			SValues[24] = "2";
		}
		SValues[25] = readValueList[25];
		SValues[26] = readValueList[26];
		if (readValueList[27].equals("喂养指导"))
			SValues[27] = "true";
		if (readValueList[28].equals("意外伤害"))
			SValues[28] = "true";
		if (readValueList[29].equals("疾病预防"))
			SValues[29] = "true";
		SValues[30] = readValueList[30];
		SValues[31] = readValueList[31];
		SValues[32] = readValueList[32];
		top();
		return;
	}

	@Override
	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/";
		if (storeValueList[2].equals("true"))
			HValue += "上/";
		if (storeValueList[3].equals("true"))
			HValue += "中/";
		if (storeValueList[4].equals("true"))
			HValue += "下/";
		HValue += storeValueList[5] + "/";
		if (storeValueList[6].equals("true"))
			HValue += "上/";
		if (storeValueList[7].equals("true"))
			HValue += "中/";
		if (storeValueList[8].equals("true"))
			HValue += "下/";
		HValue += storeValueList[9] + "/" + storeValueList[10] + "/" + storeValueList[11] + "/" + storeValueList[12] + "/" + storeValueList[13] + "/"
				+ storeValueList[14] + "/" + storeValueList[15] + "/" + storeValueList[16] + "/" + storeValueList[17] + "/" + storeValueList[18] + "/"
				+ storeValueList[19] + "/" + storeValueList[20] + "/" + storeValueList[21] + "/" + storeValueList[22] + "/" + storeValueList[23] + "/";
		if (storeValueList[24].equals("1")) {
			HValue += "无/";
		} else if (storeValueList[24].equals("2")) {
			HValue += "有/";
		}
		HValue += storeValueList[25] + "/" + storeValueList[26] + "/";
		if (storeValueList[27].equals("true"))
			HValue += "喂养指导/";
		if (storeValueList[28].equals("true"))
			HValue += "意外伤害/";
		if (storeValueList[29].equals("true"))
			HValue += "疾病预防/";
		HValue += storeValueList[30] + "/" + storeValueList[31] + "/" + storeValueList[32];
		top();
		return;
	}

	public Age1Month12Meta() {
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
