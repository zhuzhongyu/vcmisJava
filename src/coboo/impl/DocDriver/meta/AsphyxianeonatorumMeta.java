package coboo.impl.DocDriver.meta;

/**
 * 新生儿窒息 对应字段 CV5502_04_01
 * 
 * @author 任笑言
 * 
 */
public class AsphyxianeonatorumMeta extends Meta {
	public String metaname = "新生儿窒息";
	String[] SIds = new String[] { "xm15:CV5502_04_01" };
	String[] SValues = new String[] { "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		if (humanReadValue.equals("无")) {
			SValues[0] = "1";
		} else {
			SValues[0] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "无";
		} else {
			HValue = "有";
		}
		top();
		return;
	}

	public AsphyxianeonatorumMeta() {
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
