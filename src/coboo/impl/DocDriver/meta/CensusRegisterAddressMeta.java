package coboo.impl.DocDriver.meta;

/**
 * 户籍地址 HR03_00_001_00", "HR03_00_001_01","HR03_00_001_02", "HR03_00_001_03",
 * "HR03_00_001_04
 */
public class CensusRegisterAddressMeta extends Meta {
	public String metaname = "户籍地址";
	String[] SIds = new String[] {"xx1:HR03_00_001_01", "s:HR03_00_001_02",
			"xx2:HR03_00_001_03", "xz1:HR03_00_001_04","s4:HR03_00_001_00"};
	String[] SValues = new String[] { "", "", "", "",""};
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[5];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("1")) {
			SValues[0] = "1";
			SValues[1] = "";
			SValues[2] = "";
			SValues[3] = "";
			SValues[4] = "";
		} else {
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			SValues[4] = readValueList[4];
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = storeValueList[0] + "/" + storeValueList[1] + "/"
				+ storeValueList[2] + "/" + storeValueList[3] + "/"
				+ storeValueList[4];
		top();
		return;
	}

	public CensusRegisterAddressMeta() {
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