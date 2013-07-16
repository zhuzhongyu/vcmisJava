 package coboo.impl.DocDriver.meta;

/**
 * 生活方式--饮酒情况
 */
public class DrinkingMeta extends Meta {
	public String metaname = "生活方式--饮酒情况";
	String[] SIds = new String[] { "yjpl:HR51_01_110", "ryjl:ryj:HR51_01_111",
			"sfjj1:HR51_01_189_02", "sfjj2:HR51_01_189_01", "ksyjnl:HR51_01_169", "jynnsfczj:cbjynnsfczj",
			"yjzl0:HR53_05_002_1", "yjzl1:HR53_05_002_2", "yjzl2:HR53_05_002_3","S11","S12" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[9];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("1")) {

			SValues[0] = "1";
			SValues[1] = SValues[2] = SValues[3] = SValues[4] = SValues[5] = SValues[6] = SValues[7] = SValues[8] = "";

		} else {
			for (int i = 0; i < readValueList.length; i++) {
				SValues[i] = readValueList[i];
			}
			if (readValueList[7].equals("5") || readValueList[8].equals("5")) {
				SValues[6] = readValueList[6];
			} else {
				SValues[6] = "";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = "";
		for (int i = 0; i < storeValueList.length; i++) {
			if (i < (storeValueList.length - 1)) {
				HValue += storeValueList[i] + "/";
			} else {
				HValue += storeValueList[i];
			}
		}
		top();
		return;
	}

	public DrinkingMeta() {
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