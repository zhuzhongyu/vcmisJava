package coboo.impl.DocDriver.meta;

/**
 * 目前主要症状 HR51_01_006_02, HR51_01_006_03, HR51_01_006_04, HR51_01_006_05,
 * HR51_01_006_06, HR51_01_006_07, HR51_01_006_08, HR51_01_006_09,
 * HR51_01_006_010, HR51_01_006_011, HR51_01_006_012, HR51_01_006_013,
 * HR51_01_006_01
 */
public class PreviousMainDiseaseMeta extends Meta {
	public String metaname = "既往主要症状";
	String[] SIds = new String[] { "qt:HR51_01_006_01", "jw1:HR51_01_006_04",
			"jw2:HR51_01_006_05", "jw3:HR51_01_006_06","jw4:HR51_01_006_07", "jw5:HR51_01_006_08", "jw6:HR51_01_006_09",
			"jw7:HR51_01_006_010","s8:HR51_01_006_011","s9:HR51_01_006_012","s10:HR51_01_006_013","s11","s12"};
	String[] SValues = new String[] { "", "", "", "", "", "", "", "" ,"","","","",""};
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

	public PreviousMainDiseaseMeta() {
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