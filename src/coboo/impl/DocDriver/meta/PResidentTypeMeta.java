 package coboo.impl.DocDriver.meta;

/**
 * 常住类型 对应字段 HR03_00_001
 * 
 * @author 任笑言
 */
public class PResidentTypeMeta extends Meta {

	public String metaname = "常住类型";
	String[] SIds = new String[] { "czlx:HR03_00_001" };
	String[] SValues = new String[] { "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		if (humanReadValue.equals("户籍")) {
			SValues[0] = "1";
		}
		if (humanReadValue.equals("非户籍")) {
			SValues[0] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (SValues[0].equals("1")) {
			HValue = "户籍";
		}
		if (SValues[0].equals("2")) {
			HValue = "非户籍";
		}
		top();
		return;
	}

	public PResidentTypeMeta() {
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