 package coboo.impl.DocDriver.meta;

/**
 * 主要用药情况--药物2 drug2
 */
public class Drug2Meta extends Meta {
	public String metaname = "主要用药情况--药物2";
	String[] SIds = new String[] { "ywmc02:HR53_01_002_2", "yf2:HR52_01_013_2",
			"yl2:HR52_01_033_2", "yysj2:HR52_01_037_01_2", "fyycx2:HR51_01_179_2" };
	String[] SValues = new String[] {  "", "", "", "", ""  };
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

	public Drug2Meta() {
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