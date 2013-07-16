package coboo.impl.DocDriver.meta;

/**
 * 第五次随访转诊
 * 
 * HR52_02_027_10,HR52_02_027_11,HR52_02_027_12
 */
public class FifthTimesReferralMeta extends Meta {
	public String metaname = "第五次随访转诊";
	String[] SIds = new String[] { "zz41:HR52_02_027_010", "zz42:HR52_02_027_011",
			"zz44:HR52_02_027_012" };
	String[] SValues = new String[] { "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[3];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("1")) {
			SValues[0] = "1";
			SValues[1] = "";
			SValues[2] = "";
		} else {
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0] + "/" + storeValueList[1] + "/"
				+ storeValueList[2];
		top();
		return;
	}

	public FifthTimesReferralMeta() {
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