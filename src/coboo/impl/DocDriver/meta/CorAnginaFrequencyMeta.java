package coboo.impl.DocDriver.meta;

/**
 * 冠心病--心绞痛频率
 * 
 * @author rxy CV5502_16_12_11~CV5502_16_12_16 CV5502_16_12_21~CV5502_16_12_26
 */
public class CorAnginaFrequencyMeta extends Meta {
	String metaname = "冠心病--心绞痛频率";
	String[] SIds = new String[] { "cq1:CV5502_16_12_11", "y1:CV5502_16_12_12",
			"I1:CV5502_16_12_13", "II1:CV5502_16_12_14", "III1:CV5502_16_12_15",
			"IV1:CV5502_16_12_16", "cq2:CV5502_16_12_21", "y2:CV5502_16_12_22",
			"I2:CV5502_16_12_23", "II2:CV5502_16_12_24", "III2:CV5502_16_12_25",
			"IV2:CV5502_16_12_26" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[12];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		if (readValueList[2].equals("l1"))
			SValues[2] = "true";
		if (readValueList[3].equals("ll1"))
			SValues[3] = "true";
		if (readValueList[4].equals("lll1"))
			SValues[4] = "true";
		if (readValueList[5].equals("lV1"))
			SValues[5] = "true";
		SValues[6] = readValueList[6];
		SValues[7] = readValueList[7];
		if (readValueList[8].equals("l2"))
			SValues[8] = "true";
		if (readValueList[9].equals("ll2"))
			SValues[9] = "true";
		if (readValueList[10].equals("lll2"))
			SValues[10] = "true";
		if (readValueList[11].equals("lV2"))
			SValues[11] = "true";
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/";
		if (storeValueList[2].equals("true"))
			HValue += "l1/";
		if (storeValueList[3].equals("true"))
			HValue += "ll1/";
		if (storeValueList[4].equals("true"))
			HValue += "lll1/";
		if (storeValueList[5].equals("true"))
			HValue += "lV1/";
		HValue += storeValueList[6] + "/" + storeValueList[7] + "/";
		if (storeValueList[8].equals("true"))
			HValue += "l2/";
		if (storeValueList[9].equals("true"))
			HValue += "ll2/";
		if (storeValueList[10].equals("true"))
			HValue += "lll2/";
		if (storeValueList[11].equals("true"))
			HValue += "lV2/";
		top();
		return;
	}

	public CorAnginaFrequencyMeta() {
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
