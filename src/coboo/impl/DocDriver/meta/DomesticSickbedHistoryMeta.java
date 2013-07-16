 package coboo.impl.DocDriver.meta;

/**
 * 住院治疗情况--家庭病床史 
 */
public class DomesticSickbedHistoryMeta extends Meta {
	public String metaname = "住院治疗情况--家庭病床史";
	String[] SIds = new String[] { "jcrq:HR42_02_107_1", "ccrq:HR42_02_106_1",
			"jtbcs1:HR54_01_009_3", "jtbcsyljgmc1:HR21_01_031_3", "jtbcs3:HR01_00_010_3", "jcrq1:HR42_02_107_2",
			"ccrq1:HR42_02_106_1_2", "jtbcs2:HR54_01_009_4", "jtbcsyljgmc2:HR21_01_031_4", "jtbcs4:HR01_00_010_4" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[10];
		readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {
			SValues[i] = readValueList[i];
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

	public DomesticSickbedHistoryMeta() {
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