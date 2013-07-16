 package coboo.impl.DocDriver.meta;

/**
 * 日吸烟量
 * "HR51_01_108_21", "HR51_01_108_22"
 * @author WangZhendong
 * 
 */
public class ThirdTimeSmokingVolumeOfEveryDayMeta extends Meta {
	String metaname = " 日吸烟量 ";
	String[] SIds = new String[] { "rxyl5:HR51_01_108_21", "rxyl6:HR51_01_108_22" };
	String[] SValues = new String[] {"",""};
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] valueList = new String[2];
		valueList = humanReadValue.split("/");
		SValues[0] = valueList[0];
		SValues[1] = valueList[1];
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0] + "/" + storeValueList[1];
		top();
		return;
	}

	public ThirdTimeSmokingVolumeOfEveryDayMeta() {
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