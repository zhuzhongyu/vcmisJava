package coboo.impl.DocDriver.meta;

/**
 * 妇科检查--宫颈 HR51_02_059
 */
public class CervicalCheckMeta extends Meta {
	String metaname = "妇科检查--宫颈";
	String[] SIds = new String[] {"gj:HR51_02_059"};
	String[] SValues = new String[] { "" };
	String HValue;

	void con_hvalue2svalue(String HValue) {
		SValues[0] = HValue;
		top();
		return;
	}
	void con_svalue2hvalue(String[] SValues) {
		HValue = SValues[0];
		top();
		return;
	}

	public CervicalCheckMeta() {
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