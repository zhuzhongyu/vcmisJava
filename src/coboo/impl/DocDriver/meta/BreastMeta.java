package coboo.impl.DocDriver.meta;

/**
 * 查体--乳腺 breast
 * HR51_01_022_1,HR51_01_022_2,HR51_01_022_3,HR51_01_022_4,HR51_01_022_5
 */
public class BreastMeta extends Meta {
	public String metaname = " 查体--乳腺";
	String[] SIds = new String[] { "lx1:HR51_01_022_1", "lx2:HR51_01_022_2",
			"lx3:HR51_01_022_3", "lx4:HR51_01_022_4", "lx5:HR51_01_022_5" };
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[5];
		readValueList = humanReadValue.split("/");

		if (readValueList[1].equals("5") || readValueList[2].equals("5")
				|| readValueList[3].equals("5") || readValueList[4].equals("5")) {
			SValues[0] = readValueList[0];
		} else {
			SValues[0] = "";
		}

		for (int i = 1; i < readValueList.length; i++) {
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

	public BreastMeta() {
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