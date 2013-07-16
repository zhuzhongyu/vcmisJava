package coboo.impl.DocDriver.meta;
/**
 * 1岁内儿童--8月龄表
 * @author rxy
 *
 */
public class Age1Month8Meta extends Meta{
	String metaname = "1岁内儿童--8月龄表";
	String[] SIds = new String[] { 
			"s0:HR42_02_057_4:sf5","s1:HR51_02_004_4:sf10", "s2:HR9", "s3:HR10", "s4:HR11", "s5:HR51_02_00_4:sf15", "s6:HR21", "s7:HR22", "s8:HR23", "s9",
			"s10:cbms4:tj5", "s11:HR51_02_014_4:tj10", "s12:HR51_02_009_4:tj16", "s13", "s14:HR51_02_197_4:tj20", "s15:HR51_02_126_4", "s16:HR51_02_032_4:tj23", "s17:HR51_02_086_4:tj27","s18:HR51_02_018_4:tj31", "s19:HR51_02_016_4:tj39", 
			"s20:CV5502_02_08_3:tj42", "s21:CV5502_02_08_6:tj45", "s22", "s23:HR51_03_094_2:tj51", "s24:cbhw4:hw05", "s25:HR51_01_005_4:hw10", "s26:HR51_02_118_4:hw14", "s27:HR54_02_013_01_4:hw31","s28:cbqt4:hw35", "s29:HR42_01_010_4:zz05", 
			"s30:HR52_02_044_4", "s31:HR21_01_022_4", "s32:HR51_01_004_14", "s33:HR51_01_004_18", "s34:HR51_01_004_22", "s35", "s36", "s37:HR51_01_004_26:zd4","s38:HR42_02_090_4:sfrq4", "s39:cbsfysqm4:sfysqm4"};
	String[] SValues = new String[] {
			"",	"", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "",	"", "", 
			"", "", "", "", "", "", "", "",	"", "", 
			"", ""		
	};
	String HValue;

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
		HValue += storeValueList[9] + "/" + storeValueList[10] + "/"
				+ storeValueList[11] + "/" + storeValueList[12] + "/"
				+ storeValueList[13] + "/" + storeValueList[14] + "/"
				+ storeValueList[15] + "/" + storeValueList[16] + "/"
				+ storeValueList[17] + "/" + storeValueList[18] + "/"
				+ storeValueList[19] + "/" + storeValueList[20] + "/"
				+ storeValueList[21] + "/" + storeValueList[22] + "/"
				+ storeValueList[23] + "/" + storeValueList[24] + "/"
				+ storeValueList[25] + "/" + storeValueList[26] + "/";
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
		HValue += storeValueList[33] + "/" + storeValueList[34] + "/"
				+ storeValueList[35];
		top();
		return;
	}

	public Age1Month8Meta() {
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
