package coboo.impl.DocDriver.meta;
/**
 * 1-2岁内儿童--30月龄表
 * @author rxy
 *
 */
public class Age1Month30Meta extends Meta {
	String metaname = "1-2岁内儿童--30月龄表";
	String[] SIds = new String[] {
			"HR42_02_057_4:sf13","HR51_02_004_4:sf14", "HR9", "HR10", "HR11", "HR51_02_00_4:sf15", "HR21", "HR22", "HR23", "cbms4:tg8",
			"s10", "HR51_02_197_4:tg15", "HR51_02_126_4", "HR51_02_032_4:tg18", "s14", "HR51_02_086_4:tg22", "HR51_02_018_4:tg26", "HR51_02_016_4:tg30","cbbt3:tg33", "HR51_03_094_2:tg38", 
			"cbhw4:hw5", "HR54_02_013_01_4:fy15", "cbqt4:fy19", "HR42_01_010_4:zz5", "HR52_02_044_4", "HR21_01_022_4", "HR51_01_004_14", "HR51_01_004_18","HR51_01_004_22", "s29", 
			"s30", "zhid4", "HR42_02_090_4:xzsfrq4", "cbsfysqm4:sfysqm4"};
	String[] SValues = new String[] {
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "","" };
	String HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[32];
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
		if (readValueList[23].equals("无")) {
			SValues[23] = "1";
		} else if (readValueList[23].equals("有")) {
			SValues[23] = "2";
		}
		SValues[24] = readValueList[24];
		SValues[25] = readValueList[25];
		if (readValueList[26].equals("喂养指导"))
			SValues[26] = "true";
		if (readValueList[27].equals("意外伤害"))
			SValues[27] = "true";
		if (readValueList[28].equals("疾病预防"))
			SValues[28] = "true";
		SValues[29] = readValueList[29];
		SValues[30] = readValueList[30];
		SValues[31] = readValueList[31];
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
				+ storeValueList[21] + "/" + storeValueList[22] + "/";
		if (storeValueList[23].equals("1")) {
			HValue += "无/";
		} else if (storeValueList[23].equals("2")) {
			HValue += "有/";
		}
		HValue += storeValueList[24] + "/" + storeValueList[25] + "/";
		if (storeValueList[26].equals("true"))
			HValue += "喂养指导/";
		if (storeValueList[27].equals("true"))
			HValue += "意外伤害/";
		if (storeValueList[28].equals("true"))
			HValue += "疾病预防/";
		HValue += storeValueList[29] + "/" + storeValueList[30] + "/"
				+ storeValueList[31];
		top();
		return;
	}

	public Age1Month30Meta() {
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
