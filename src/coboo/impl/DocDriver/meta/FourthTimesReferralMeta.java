package coboo.impl.DocDriver.meta;

/**
 * 第四次随访转诊 HR52_02_027_07,HR52_02_027_08,HR52_02_027_09
 */
public class FourthTimesReferralMeta extends Meta {
	public String metaname = "第四次随访转诊";
	String[] SIds = new String[] { "zz31:HR52_02_027_07", "zz32:HR52_02_027_08",
			"zz34:HR52_02_027_09" };
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

	public FourthTimesReferralMeta() {
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