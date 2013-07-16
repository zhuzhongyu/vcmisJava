package coboo.impl.DocDriver.meta;

/**
 * 1岁内儿童--3月龄表
 * @author rxy
 *
 */
public class Age1Month3Meta extends Meta {
	String		metaname	= "1岁内儿童--3月龄表";
	String[]	SIds		= new String[] { 
			"sf3:HR42_02_057_2","sf8:HR51_02_004_2","HR3","HR4","HR5","HR51_02_00_2:sf13","HR15","HR16","HR17","s9","cbms2:tj3","HR51_02_014_2:tj8","HR51_02_009_2:tj14","s13","s14"
			,"HR51_02_197_2:tj18","HR51_02_126_2","HR51_02_032_2","HR51_02_086_2:tj25","HR51_02_018_2:tj29","CV5502_03_05_2:tj33","HR51_02_016_2:tj37","CV5502_02_08_1:tj40","CV5502_02_08_4:tj43","HR51_02_191_02_2:tj48","s25","cbhw2:hw03","HR51_01_005_2:hw08","HR51_02_118_2:hw12","HR54_02_013_01_2:hw29"
			,"cbqt2:hw33","HR42_01_010_2:zz03","HR52_02_044_2","HR21_01_022_2","HR51_01_004_12","HR51_01_004_16","HR51_01_004_20","s37","zd2","HR51_01_004_24","HR42_02_090_2:sfrq2","cbsfysqm2:sfysqm2"
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

		String readValueList[] = new String[36];
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
		if (readValueList[27].equals("无")) {
			SValues[27] = "1";
		} else if (readValueList[27].equals("有")) {
			SValues[27] = "2";
		}
		SValues[28] = readValueList[28];
		SValues[29] = readValueList[29];
		if (readValueList[30].equals("喂养指导"))
			SValues[30] = "true";
		if (readValueList[31].equals("母乳喂养"))
			SValues[31] = "true";
		if (readValueList[32].equals("疾病预防"))
			SValues[32] = "true";
		SValues[33] = readValueList[33];
		SValues[34] = readValueList[34];
		SValues[35] = readValueList[35];
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
				+ storeValueList[24] + "/" + storeValueList[25] + "/" + storeValueList[26] + "/";
		if (storeValueList[27].equals("1")) {
			HValue += "无/";
		} else if (storeValueList[27].equals("2")) {
			HValue += "有/";
		}
		HValue += storeValueList[28] + "/" + storeValueList[29] + "/";
		if (storeValueList[30].equals("true"))
			HValue += "喂养指导/";
		if (storeValueList[31].equals("true"))
			HValue += "母乳喂养/";
		if (storeValueList[32].equals("true"))
			HValue += "疾病预防/";
		HValue += storeValueList[33] + "/" + storeValueList[34] + "/" + storeValueList[35];
		top();
		return;
	}

	public Age1Month3Meta() {
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
