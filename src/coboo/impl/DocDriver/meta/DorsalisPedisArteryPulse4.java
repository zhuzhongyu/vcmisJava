package coboo.impl.DocDriver.meta;

/**
 * 第四次随访--体征--足背动脉搏动 对应标记 HR51_02_199_4
 * 
 * @author rp
 */
public class DorsalisPedisArteryPulse4 extends Meta {
	String metaname = "第四次随访--体征--足背动脉搏动";
	String[] SIds = new String[] { "zbdmbd7" };
	String[] SValues = new String[] { "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		if (humanReadValue.equals("未触及")) {
			SValues[0] = "1";
		} else if (humanReadValue.equals("触及")) {
			SValues[0] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[0].equals("1")) {
			HValue = "未触及";
		} else if (storeValueList[0].equals("2")) {
			HValue = "触及";
		}
		top();
		return;
	}

	public DorsalisPedisArteryPulse4() {
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