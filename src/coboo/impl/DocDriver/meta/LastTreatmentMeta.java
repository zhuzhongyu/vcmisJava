package coboo.impl.DocDriver.meta;

/**
 * 治疗效果 HR51_01_205
 */
public class LastTreatmentMeta extends Meta {
	public String metaname = "治疗效果";
	String[] SIds = new String[] { "zj004" };
	String[] SValues = new String[] { "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		if (humanReadValue.equals("痊愈")) {
			SValues[0] = "1";
		} else if (humanReadValue.equals("好转")) {
			SValues[0] = "2";
		} else if (humanReadValue.equals("无变化")) {
			SValues[0] = "3";
		} else if (humanReadValue.equals("加重")) {
			SValues[0] = "4";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "痊愈";
		} else if (storeValueList[0].equals("2")) {
			HValue = "好转";
		} else if (storeValueList[0].equals("3")) {
			HValue = "无变化";
		} else if (storeValueList[0].equals("4")) {
			HValue = "加重";
		}
		top();
		return;
	}

	public LastTreatmentMeta() {
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
