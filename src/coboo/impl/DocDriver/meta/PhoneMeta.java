 package coboo.impl.DocDriver.meta;

/**
 * 联系电话
 * HR04_00_001_03
 */
public class PhoneMeta extends Meta {
	public String metaname = "电话";
	String[] SIds = new String[] {"telephone:lxdh:HR04_00_001_03:HR04_00_001_01:bh7"};
	String[] SValues = new String[] { "" };
	String HValue;

	// ================数据元两种格式转换=================

	void con_hvalue2svalue(String h) {
		SValues[0] = h;

		top();
		return;
	}

	void con_svalue2hvalue(String[] s) {
		HValue = s[0];
		top();
		return;
	}

	public PhoneMeta() {
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
