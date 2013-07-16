package coboo.impl.DocDriver.meta;

/**
 * 测试评分表 对应字段 HR3,HR4,HR5,HR6,HR7,HR8,HR9,HR10,HR11,HR12,HR13,HR14,
 * HR15,HR16,HR17,HR18,HR19,HR20,HR21,HR22,HR23,HR24,HR25,
 * HR26,HR27,HR28,HR29,HR30,HR32,HR33,HR34,HR35,HR36,HR37,
 * HR38,HR39,HR40,HR41,HR42,HR43,HR44,HR45
 * 
 * @author 任笑言
 */
public class TestScaleMeta extends Meta {
	public String metaname = "测试评分表 ";
	String[] SIds = new String[] {"jndnf1:HR3", "jndnf2:HR4", "xajsmjj1:HR5", "xajsmjj2:HR6", "jtsjh1:HR7", "jtsjh2:HR8",
			"jtsxqj1:HR9", "jtsxqj2:HR10", "xajjyf1:HR11", "xajjyf2:HR12", "nzxxnygss1:HR13", "nzxxnygss2:HR14", "nxzznygxq1:HR15", "nxzznygxq2:HR16",
			"nxzznyx1:HR17", "nxzznyx2:HR18", "nxzznyls1:HR19", "nxzznyls2:HR20", "pljsmdf1:HR21", "pljsmdf2:HR22", "fspq1:HR23", "fspq2:HR24",
			"fslq1:HR25", "fslq2:HR26", "fssm1:HR27", "fssm2:HR28", "ybjqjds1:HR29", "ybjqjds2:HR30", "brqb1:HR32", "brqb2:HR33",
			"fsssszssz1:HR34", "fsssszssz2:HR35", "yysnz1:HR36", "yysnz2:HR37", "jzdz1:HR38", "jzdz2:HR39", "fzdts1:HR40", "fzdts2:HR41",
			"syhwzjz1:HR42", "syhwzjz2:HR43", "zf1:HR44", "zf2:HR45" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", 
			"", "", "", "", "", "", "","", "", "", 
			"", "", "", "", "", "", "", "", "", "",
			"", ""  };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[42];
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
		SValues[28] = readValueList[28];
		SValues[29] = readValueList[29];
		SValues[30] = readValueList[30];
		SValues[31] = readValueList[31];
		SValues[32] = readValueList[32];
		SValues[33] = readValueList[33];
		SValues[34] = readValueList[34];
		SValues[35] = readValueList[35];
		SValues[36] = readValueList[36];
		SValues[37] = readValueList[37];
		SValues[38] = readValueList[38];
		SValues[39] = readValueList[39];
		SValues[40] = readValueList[40];
		SValues[41] = readValueList[41];
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/"
				+ storeValueList[2] + "/" + storeValueList[3] + "/"
				+ storeValueList[4] + "/" + storeValueList[5] + "/"
				+ storeValueList[6] + "/" + storeValueList[7] + "/"
				+ storeValueList[8] + "/" + storeValueList[9] + "/"
				+ storeValueList[10] + "/" + storeValueList[11] + "/"
				+ storeValueList[12] + "/" + storeValueList[13] + "/"
				+ storeValueList[14] + "/" + storeValueList[15] + "/"
				+ storeValueList[16] + "/" + storeValueList[17] + "/"
				+ storeValueList[18] + "/" + storeValueList[19] + "/"
				+ storeValueList[20] + "/" + storeValueList[21] + "/"
				+ storeValueList[22] + "/" + storeValueList[23] + "/"
				+ storeValueList[24] + "/" + storeValueList[25] + "/"
				+ storeValueList[26] + "/" + storeValueList[27] + "/"
				+ storeValueList[28] + "/" + storeValueList[29] + "/"
				+ storeValueList[30] + "/" + storeValueList[31] + "/"
				+ storeValueList[32] + "/" + storeValueList[33] + "/"
				+ storeValueList[34] + "/" + storeValueList[35] + "/"
				+ storeValueList[36] + "/" + storeValueList[37] + "/"
				+ storeValueList[38] + "/" + storeValueList[39] + "/"
				+ storeValueList[40] + "/" + storeValueList[41];
		top();
		return;
	}

	public TestScaleMeta() {
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
