 package coboo.impl.DocDriver.meta;

/**
 * 康复措施
 * HR54_01_008_02, HR54_01_008_03, HR54_01_008_04, HR54_01_008_01
 */
public class RehabilitationMeta extends Meta {
	public String metaname = "康复措施";
	String[] SIds = new String[] {"kf02", "kf03",
			"kf04", "kf01:cbywblfy_0","s4"};
	String[] SValues = new String[] { "", "", "", "","" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		Boolean flag = false;
		String[] readValueList = new String[4];
		readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {
			if (readValueList[i].equals("5")) {
				flag = true;
			}
		}
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		SValues[2] = readValueList[2];
		if (flag) {
			SValues[3] = readValueList[3];
		} else {
			SValues[3] = "";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/"
				+ storeValueList[2] + "/" + storeValueList[3];
		top();
		return;
	}

	public RehabilitationMeta() {
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