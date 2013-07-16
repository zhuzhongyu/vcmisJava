 package coboo.impl.DocDriver.meta;

/**
 * 训练场所 
 * "cbxlcs_jg", "cbxlcs_jt"
 * @author 任笑言
 */
public class TrainPlaceMeta extends Meta {
	public String metaname = "训练场所";
	String[] SIds = new String[] { "cbxlcs_jg:jg", "cbxlcs_jt:jt"};
	String[] SValues = new String[] { "", "" };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[2];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "机构/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "家庭/";
		}
		top();
		return;
	}

	public TrainPlaceMeta() {
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