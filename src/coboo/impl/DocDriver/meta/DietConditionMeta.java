package coboo.impl.DocDriver.meta;

/**
 * 饮食情况 HR51_01_198
 */
public class DietConditionMeta extends Meta {
	public String metaname = "饮食情况";
	String[] SIds = new String[] {"ysqk:HR51_01_198"};
	String[] SValues = new String[] { "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		if (humanReadValue.equals("良好")) {
			SValues[0] = "1";
		} else if (humanReadValue.equals("一般")) {
			SValues[0] = "2";
		} else if (humanReadValue.equals("较差")) {
			SValues[0] = "3";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "良好";
		} else if (storeValueList[0].equals("2")) {
			HValue = "一般";
		} else if (storeValueList[0].equals("3")) {
			HValue = "较差";
		}
		top();
		return;
	}

	public DietConditionMeta() {
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