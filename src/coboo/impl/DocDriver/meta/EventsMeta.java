package coboo.impl.DocDriver.meta;

/**
 * 患病对家庭社会的影响事件
 * HR51_01_207_06,HR51_01_207_01,HR51_01_207_02,HR51_01_207_03,HR51_01_207_04,HR51_01_207_05
 */
public class EventsMeta extends Meta {
	public String metaname = "患病对家庭社会的影响事件";
	String[] SIds = new String[] {  "yx01",
			"yx02", "yx03", "yx04",
			"yx05" };
	String[] SValues = new String[] {  "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[6];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("无")) {
			SValues[0] = "6";
			SValues[1] = "";
			SValues[2] = "";
			SValues[3] = "";
			SValues[4] = "";
			SValues[5] = "";

		} else {
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			SValues[4] = readValueList[4];
			SValues[5] = readValueList[5];

		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0];
		top();
		return;
	}

	public EventsMeta() {
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
