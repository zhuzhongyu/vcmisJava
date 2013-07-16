package coboo.impl.DocDriver.meta;
/**
 * 1-2岁内儿童--18月龄表
 * @author rxy
 *
 */
public class Age1Month18Meta extends Meta {
	String metaname = "1-2岁内儿童--18月龄表";
	String[] SIds = new String[] { 
			"HR42_02_057_2:sf7","HR51_02_004_2:sf8", "HR3", "HR4", "HR5", "HR51_02_00_2:sf9", "HR15", "HR16", "HR17", "cbms2:tg6",
			"s10", "HR51_02_009_2:tg11", "s12", "HR51_02_197_2:tg13", "HR51_02_126_2", "HR51_02_032_2:tg16", "s16", "HR51_02_086_2:tg20","HR51_02_018_2:tg24", "HR51_02_016_2:tg28", 
			"cbbt1:tg31", "CV5502_02_08_4:tg34", "HR51_03_094_1:tg37", "cbhw2:hw3", "HR51_01_005_2:hw8", "HR51_02_118_2:fy2", "HR54_02_013_01_2:fy13", "cbqt2:fy17","HR42_01_010_2:zz3", "HR52_02_044_2", 
			"HR21_01_022_2", "HR51_01_004_12", "HR51_01_004_16", "HR51_01_004_20", "s34", "s35", "HR51_01_004_24:zhid2", "HR42_02_090_2:xzsfrq2","cbsfysqm2:sfysqm2"};
	String[] SValues = new String[] {
			"",	"", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",	"", "", 
			"", "", "", "", "", "", "", "",	"", "", 
			"", "" };
	String HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[34];
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
		SValues[24] = readValueList[24];
		if (readValueList[25].equals("无")) {
			SValues[25] = "1";
		} else if (readValueList[25].equals("有")) {
			SValues[25] = "2";
		}
		SValues[26] = readValueList[26];
		SValues[27] = readValueList[27];
		if (readValueList[28].equals("喂养指导"))
			SValues[28] = "true";
		if (readValueList[29].equals("意外伤害"))
			SValues[29] = "true";
		if (readValueList[302].equals("疾病预防"))
			SValues[30] = "true";
		SValues[31] = readValueList[31];
		SValues[32] = readValueList[32];
		SValues[33] = readValueList[33];
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
		HValue += storeValueList[9] + "/" + storeValueList[10] + "/"
				+ storeValueList[11] + "/" + storeValueList[12] + "/"
				+ storeValueList[13] + "/" + storeValueList[14] + "/"
				+ storeValueList[15] + "/" + storeValueList[16] + "/"
				+ storeValueList[17] + "/" + storeValueList[18] + "/"
				+ storeValueList[19] + "/" + storeValueList[20] + "/"
				+ storeValueList[21] + "/" + storeValueList[22] + "/"
				+ storeValueList[23] + "/" + storeValueList[24] + "/";
		if (storeValueList[25].equals("1")) {
			HValue += "无/";
		} else if (storeValueList[25].equals("2")) {
			HValue += "有/";
		}
		HValue += storeValueList[26] + "/" + storeValueList[27] + "/";
		if (storeValueList[28].equals("true"))
			HValue += "喂养指导/";
		if (storeValueList[29].equals("true"))
			HValue += "意外伤害/";
		if (storeValueList[30].equals("true"))
			HValue += "疾病预防/";
		HValue += storeValueList[31] + "/" + storeValueList[32] + "/"
				+ storeValueList[33];
		top();
		return;
	}

	public Age1Month18Meta() {
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
