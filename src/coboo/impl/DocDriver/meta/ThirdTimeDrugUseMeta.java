 package coboo.impl.DocDriver.meta;

/**
 * 用药情况
 * "HR53_01_002_21", "HR52_01_037_01_21","HR52_01_037_03_21", 
 * "HR53_01_002_22", "HR52_01_037_01_22","HR52_01_037_03_22", 
 * "HR53_01_002_23", "HR52_01_037_01_23","HR52_01_037_03_23", 
 * "HR53_01_002_24", "HR4", "HR5"
 * @author WangZhendong
 */
public class ThirdTimeDrugUseMeta extends Meta {
	public String metaname = " 用药情况 ";
	String[] SIds = new String[] { "ywmc3:HR53_01_002_21", "yf5:HR52_01_037_01_21",
			"yf6:HR52_01_037_03_21", "ywmc7:HR53_01_002_22", "yf13:HR52_01_037_01_22",
			"yf14:HR52_01_037_03_22", "ywmc11:HR53_01_002_23", "yf21:HR52_01_037_01_23",
			"yf22:HR52_01_037_03_23", "ywmc15:HR53_01_002_24", "yf29:HR4", "yf30：HR5" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "" };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String[] valueList = new String[12];
		valueList = humanReadValue.split("/");
		SValues[0] = valueList[0];
		SValues[1] = valueList[1];
		SValues[2] = valueList[2];
		SValues[3] = valueList[3];
		SValues[4] = valueList[4];
		SValues[5] = valueList[5];
		SValues[6] = valueList[6];
		SValues[7] = valueList[7];
		SValues[8] = valueList[8];
		SValues[9] = valueList[9];
		SValues[10] = valueList[10];
		SValues[11] = valueList[11];
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
				+ storeValueList[10] + "/" + storeValueList[11];

		top();
		return;
	}

	public ThirdTimeDrugUseMeta() {
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