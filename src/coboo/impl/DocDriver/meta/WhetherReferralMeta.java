 package coboo.impl.DocDriver.meta;

/**
 * 转诊 
 * HR42_01_010,HR52_02_044,HR21_01_022
 * @author 任笑言
 * 
 */
public class WhetherReferralMeta extends Meta {
	public String metaname = " 转诊";
	String[] SIds = new String[] { "jy29:HR42_01_010", "jy27:HR52_02_044", "jy28:HR21_01_022"};
	String[] SValues = new String[] { "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[3];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("无") && readValueList[1].equals("")
				&& readValueList[2].equals("")) {
			SValues[0] = "1";
			SValues[1] = "";
			SValues[2] = "";
		} else {
			SValues[0] = "2";
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String form = "";
		String line1 = "";
		String line2 = "";
		if (storeValueList[0].equals("1") && storeValueList[1].equals("")
				&& storeValueList[2].equals("")) {
			form = "无";
		} else {
			form = "有";
			line1 = storeValueList[1];
			line2 = storeValueList[2];
		}
		HValue = form + "/" + line1 + "/" + line2;
		top();
		return;
	}

	public WhetherReferralMeta() {
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
