 package coboo.impl.DocDriver.meta;

/**
 * 辅助检查--血常规 Routine blood
 * HR51_03_005, HR51_03_008, HR51_03_011, HR51_03_041
 */
public class RoutineBloodMeta extends Meta {
	public String metaname = "辅助检查--血常规";
	String[] SIds = new String[] { "xhdb:HR51_03_005", "bxb:HR51_03_008", "xxb:HR51_03_011",
			"xcgqt:HR51_03_041" };
	String[] SValues = new String[] { "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[4];
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

	public RoutineBloodMeta() {
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