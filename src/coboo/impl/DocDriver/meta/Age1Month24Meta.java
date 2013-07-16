package coboo.impl.DocDriver.meta;
/**
 * 1-2岁内儿童--24月龄表
 * @author rxy
 *
 */
public class Age1Month24Meta extends Meta {
	String metaname = "1-2岁内儿童--24月龄表";
	String[] SIds = new String[] {
			"s0:HR42_02_057_3:sf10","s1:HR51_02_004_3:sf11", "s2:HR6", "s3:HR7", "s4:HR8", "s5:HR51_02_00_3:sf12", "s6:HR18", "s7:HR19", "s8:HR20", "s9:cbms3:tg7",
			"s10", "s11", "s12", "s13:HR51_02_197_3:tg14", "s14:HR51_02_126_3", "s15", "s16:HR51_02_032_3:tg17", "s17:","s18:HR51_02_086_3:tg21", "s19:HR51_02_018_3:tg25", 
			"s20:HR51_02_016_3:tg29", "s21:cbbt2:tg32", "s22:CV5502_02_08_5:tg35", "s23:cbhw3:hw4", "s24:HR51_01_005_3:hw9", "s25:HR51_02_118_3", "s26:HR54_02_013_01_3:fy14", "s27:cbqt3:fy18","s28:HR42_01_010_3:zz4", "s29:HR52_02_044_3", 
			"s30:HR21_01_022_3", "s31:HR51_01_004_13", "s32:HR51_01_004_17", "s33:HR51_01_004_21", "s34", "s35", "s36:HR51_01_004_25:zhid3", "s37:HR42_02_090_3:xzsfrq3","cbsfysqm3:sfysqm3"};
	String[] SValues = new String[] {
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "" };
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

	public Age1Month24Meta() {
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
