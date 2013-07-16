 package coboo.impl.DocDriver.meta;

/**
 * 主要用药情况--药物1 drug1
 */
public class Drug1Meta extends Meta {
	public String metaname = "主要用药情况--药物";
	String[] SIds = new String[] { "ywmc01:HR53_01_002_1", "yf1:HR52_01_013_1",
			"yl1:HR52_01_033_1", "yysj1:HR52_01_037_01_1", "fyycx1:HR51_01_179_1" };
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[5];
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

	public Drug1Meta() {
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