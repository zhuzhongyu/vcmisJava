package coboo.impl.DocDriver.meta;

public class Age1Month6Meta extends Meta {
	String		metaname	= "1岁内儿童--6月龄表";
	String[]	SIds		= new String[] { 
			"HR42_02_057_3:sf4", "HR51_02_004_3:sf9", "HR6", "HR7", "HR8", "HR51_02_00_3:sf14", "HR18", "HR19", "HR20", "s9", "cbms3",
			"cbms3:tj4", "HR51_02_014_3:tj9", "HR51_02_009_3:tj15", "s13", "s14", "HR51_02_197_3:tj19", "HR51_02_126_3", "s17", "HR51_02_032_3:tj22", "HR51_02_086_3:tj26",
			"HR51_02_018_3:tj30", "HR51_02_016_3:tj38", "CV5502_02_08_2:tj41", "CV5502_02_08_5:tj44", "HR51_02_191_02_3:tj49", "HR51_03_094_1:tj50", "cbhw3:hw04", "HR51_01_005_3:hw09", "HR51_02_118_3:hw13", "HR54_02_013_01_3:hw30",
			"cbqt3,hw34", "HR42_01_010_3:zz04", "HR52_02_044_3", "HR21_01_022_3", "HR51_01_004_13", "HR51_01_004_17", "HR51_01_004_21", "s37", "s38", "HR51_01_004_25:zd3",
			"HR42_02_090_3:sfrq3", "cbsfysqm3:sfysqm3"
	};
	String[]	SValues		= new String[] {
			"", "", "", "", "", "", "", "", "", "", 
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "",
			"", "", "", ""
			};
	String		HValue;

	@Override
	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[37];
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
		SValues[25] = readValueList[25];
		SValues[26] = readValueList[26];
		SValues[27] = readValueList[27];
		if (readValueList[28].equals("无")) {
			SValues[28] = "1";
		} else if (readValueList[28].equals("有")) {
			SValues[28] = "2";
		}
		SValues[29] = readValueList[29];
		SValues[30] = readValueList[30];
		if (readValueList[31].equals("喂养指导"))
			SValues[31] = "true";
		if (readValueList[32].equals("母乳喂养"))
			SValues[32] = "true";
		if (readValueList[33].equals("疾病预防"))
			SValues[33] = "true";
		SValues[34] = readValueList[34];
		SValues[35] = readValueList[35];
		SValues[36] = readValueList[36];
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
				+ storeValueList[19] + "/" + storeValueList[20] + "/" + storeValueList[21] + "/" + storeValueList[22] + "/" + storeValueList[23] + "/"
				+ storeValueList[24] + "/" + storeValueList[25] + "/" + storeValueList[26] + "/" + storeValueList[27] + "/";
		if (storeValueList[28].equals("1")) {
			HValue += "无/";
		} else if (storeValueList[28].equals("2")) {
			HValue += "有/";
		}
		HValue += storeValueList[29] + "/" + storeValueList[30] + "/";
		if (storeValueList[31].equals("true"))
			HValue += "喂养指导/";
		if (storeValueList[32].equals("true"))
			HValue += "母乳喂养/";
		if (storeValueList[33].equals("true"))
			HValue += "疾病预防/";
		HValue += storeValueList[34] + "/" + storeValueList[35] + "/" + storeValueList[36];
		top();
		return;
	}

	public Age1Month6Meta() {
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
