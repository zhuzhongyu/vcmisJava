package coboo.impl.DocDriver.meta;

/**
 * 血糖测试
 * 
 * @author rxy
 * 
 */
public class BloodGlucoseTestMeta extends Meta {
	String metaname = "血糖测试";
	String[] SIds = new String[] { "kf:HR51_03_092", "ch:HR51_03_093", "sj:cbsjxt01",
			"zcfw:cbsjxt02", "yc:cbsjxt03" };
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[5];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("空腹")) {
			SValues[0] = "true";
		} else if (readValueList[1].equals("餐后2小时")) {
			SValues[1] = "true";
		} else if (readValueList[2].equals("随机")) {
			SValues[2] = "true";
		} else if (readValueList[3].equals("正常范围")) {
			SValues[3] = "true";
		} else if (readValueList[4].equals("异常")) {
			SValues[4] = "true";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "空腹/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "餐后2小时/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "随机/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "正常范围/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "异常/";
		}
		top();
		return;
	}

	public BloodGlucoseTestMeta() {
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
