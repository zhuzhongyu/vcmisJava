package coboo.impl.DocDriver.meta;
/**
 * 妇科检查--阴道 HR51_02_055_01,HR51_02_055_02
 * @author rxy
 *
 */
public class WCEAVaginalCheckMeta extends Meta{
	String metaname = "妇科检查--阴道";
	String[] SIds = new String[] { "yd1:HR51_02_055_01", "yd2:HR51_02_055_02" };
	String[] SValues = new String[] { "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String readValueList[] = new String[2];
		readValueList = humanReadValue.split("/");
		if (readValueList[1].equals("未见异常")) {
			SValues[0] = "";
			SValues[1] = "1";
		} else {
			SValues[0] = readValueList[0];
			SValues[1] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		if (storeValueList[1].equals("1")) {
			HValue = storeValueList[0] + "/" + "未见异常";
		} else {
			HValue = storeValueList[0] + "/" + "异常";
		}
		top();
		return;
	}

	public WCEAVaginalCheckMeta() {
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
