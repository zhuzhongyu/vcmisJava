 package coboo.impl.DocDriver.meta;

/**
 * 查体--巩膜 sclera
 * "HR51_02_177_1","HR51_02_177_2"
 */
public class ScleraMeta extends Meta {
	public String metaname = "查体--巩膜";
	String[] SIds = new String[] { "gm1:HR51_02_177_1", "gm2:HR51_02_177_2" };
	String[] SValues = new String[] { "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[2];
		readValueList = humanReadValue.split("/");
		if (readValueList[1].equals("4")) {
			SValues[0] = readValueList[0];
			SValues[1] = "4";
		} else {
			SValues[0] = "";
			SValues[1] = readValueList[1];
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0] + "/" + storeValueList[1];
		top();
		return;
	}

	public ScleraMeta() {
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