/**
 * 
 */
 package coboo.impl.DocDriver.meta;

/**
 * 性别 
 * HR02_02_001
 * @author user
 * 
 */
public class SexMeta extends Meta {
	public String metaname = "性别";
	String[] SIds = new String[] { "gender:HR02_02_001:xb" };
	String[] SValues = new String[] { "" };
	String HValue;

	void con_svalue2hvalue(String[] storeValueList) {
		// HValue = SValues[0];
		if (SValues[0].equals("0"))
			HValue = "未知的性别";
		if (SValues[0].equals("1"))
			HValue = "男";
		if (SValues[0].equals("2"))
			HValue = "女";
		if (SValues[0].equals("9"))
			HValue = "未说明的性别";
		top();
		return;

	}

	void con_hvalue2svalue(String humanReadValue) {
		SValues[0] = humanReadValue;
		top();
		return;
	}

	public SexMeta() {
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
