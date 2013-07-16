package coboo.impl.DocDriver.meta;

/**
 * 出生日期 对应字段 HR30_00_001
 * 
 * @author 任笑言
 */
public class BirthDateMeta extends Meta {
	public String metaname = "出生日期";
	String[] SIds = new String[] { "birthdate:csrq:HR30_00_001" };
	String[] SValues = new String[] { "" };
	String HValue;

	// ===================================================================

	// ================数据元两种格式转换=================

	void con_hvalue2svalue(String humanReadValue) {
		HValue=humanReadValue;
		SValues[0] = humanReadValue;
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		SValues=storeValueList;
		HValue = storeValueList[0];
		top();
		return;
	}

	public BirthDateMeta() {
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
