package coboo.impl.DocDriver.meta;

public class PreviousMainDisease2Meta extends Meta {
	public String metaname = "目前主要症状";
	String[] SIds = new String[] {  "qt1:HR51_02_020_02", "qt2:HR51_02_020_03",
			"at3:HR51_02_020_04", "qt4:HR51_02_020_05", "qt5:HR51_02_020_06",
			"qt6:HR51_02_020_07", "qt7:HR51_02_020_08", "qt:HR51_02_020_01"  };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "",};
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		Boolean flag = false;
		String[] readValueList = new String[13];
		readValueList = humanReadValue.split("/");
		for (int i = 0; i < (readValueList.length - 1); i++) {
			SValues[i] = readValueList[i];
			if (readValueList[i].equals("12")) {
				flag = true;
			}
		}
		if (flag) {
			SValues[12] = readValueList[12];
		} else {
			SValues[12] = "";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/"
				+ storeValueList[2] + "/" + storeValueList[3] + "/"
				+ storeValueList[4] + "/" + storeValueList[5] + "/"
				+ storeValueList[6] + "/" + storeValueList[7] + "/"
				+ storeValueList[8] + "/" + storeValueList[9] + "/"
				+ storeValueList[10] + "/" + storeValueList[11] + "/"
				+ storeValueList[12];

		top();
		return;
	}

	public PreviousMainDisease2Meta() {
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
