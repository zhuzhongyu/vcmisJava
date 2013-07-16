 package coboo.impl.DocDriver.meta;

/**
 * 危险因素控制 Risk factors control 
 * cbwxyskz1, cbwxyskz2, cbwxyskz3,
 * cbwxyskz4, cbwxyskz5, cbwxyskz6, 
 * cbwxyskz7, cbwxyskz8, cbwxyskz9
 */
public class RiskFactorsControlMeta extends Meta {
	public String metaname = "危险因素控制";
	String[] SIds = new String[] { "wxyskz1:cbwxyskz1", "wxyskz2:cbwxyskz2", "wxyskz3:cbwxyskz3",
			"wxyskz4:cbwxyskz4", "wxyskz5:cbwxyskz5", "wxyskz6:cbwxyskz6", "jtz:cbwxyskz7", "jsymjz:cbwxyskz8",
			"qt:cbwxyskz9" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		boolean flag1 = false; // 是否减轻体重标识
		boolean flag2 = false; // 是否接种育苗标识
		boolean flag3 = false; // 其他标识
		String[] readValueList = new String[9];
		readValueList = humanReadValue.split("/");

		for (int i = 0; i < readValueList.length; i++) {

			if (i < 6) {
				SValues[i] = readValueList[i];
			}
			if (readValueList[i].equals("5")) {
				flag1 = true;
			}
			if (readValueList[i].equals("6")) {
				flag2 = true;
			}
			if (readValueList[i].equals("7")) {
				flag3 = true;
			}
		}

		if (flag1) {
			SValues[6] = readValueList[6];
		} else {
			SValues[6] = "";
		}

		if (flag2) {
			SValues[7] = readValueList[7];
		} else {
			SValues[7] = "";
		}
		if (flag3) {
			SValues[8] = readValueList[8];
		} else {
			SValues[8] = "";
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

	public RiskFactorsControlMeta() {
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