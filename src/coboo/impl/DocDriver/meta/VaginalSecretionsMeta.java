 package coboo.impl.DocDriver.meta;

/**
 * 辅助检查--阴道分泌物
 * "HR51_03_007_02", "HR51_03_007_03","HR51_03_007_04", "HR51_03_007_01" 
 */
public class VaginalSecretionsMeta extends Meta {
	public String metaname = "辅助检查--阴道分泌物";
	String[] SIds = new String[] { "ydfmw1:HR51_03_007_01", "ydfmw2:HR51_03_007_02",
			"ydfmw3:HR51_03_007_03", "ydfmw:HR51_03_007_04"};
	String[] SValues = new String[] { "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[4];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("1")) {

			SValues[0] = "1";
			SValues[1] = "";
			SValues[2] = "";
			SValues[3] = "";

		} else {

			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];// 其他内容

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

	public VaginalSecretionsMeta() {
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