 package coboo.impl.DocDriver.meta;

/**
 * 用药情况
 */
public class DrugSituationMeta extends Meta {
	public String metaname = "用药情况";
	String[] SIds = new String[] {"yw001:HR53_01_002_01", "yw002:HR52_01_037_01_01",
			"yw003:HR52_01_037_03_01", "yw004:HR53_01_002_02", "yw005:HR52_01_037_01_02",
			"yw006:HR52_01_037_03_02", "yw007:HR53_01_002_03", "yw008:HR2",
			"yw009:HR3"};
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[9];
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
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/"
				+ storeValueList[2] + "/" + storeValueList[3] + "/"
				+ storeValueList[4] + "/" + storeValueList[5] + "/"
				+ storeValueList[6] + "/" + storeValueList[7] + "/"
				+ storeValueList[8];
		top();
		return;
	}

	public DrugSituationMeta() {
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
