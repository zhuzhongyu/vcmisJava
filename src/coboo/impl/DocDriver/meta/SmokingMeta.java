 package coboo.impl.DocDriver.meta;

/**
 * 生活方式--吸烟情况
 * "HR51_01_186", "HR51_01_108", "HR51_01_164","HR51_01_187"
 */
public class SmokingMeta extends Meta {
	public String metaname = "生活方式--吸烟情况 ";
	String[] SIds = new String[] { "xyzk:HR51_01_186", "rxyl:HR51_01_108", "ksxynl:HR51_01_164",
			"jynl:HR51_01_187" };
	String[] SValues = new String[] { "","","","" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[4];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("1")) {

			SValues[0] = "1";
			SValues[1] = SValues[2] = SValues[3] = "";

		} else {
			for (int i = 0; i < readValueList.length; i++) {
				SValues[i] = readValueList[i];
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

	public SmokingMeta() {
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