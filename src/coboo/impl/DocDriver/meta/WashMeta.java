 package coboo.impl.DocDriver.meta;

/**
 * 洗漱 
 * cbpg_2_xs_c, cbpg_2_xs_z, cbpg_2_xs_m, cbpg_1_xs_c cbpg_1_xs_z,
 * cbpg_1_xs_m, cbpg_0_xs_c, cbpg_0_xs_z, cbpg_0_xs_m
 * 
 * @author 任笑言
 */
public class WashMeta extends Meta {
	public String metaname = "洗漱";
	String[] SIds = new String[] { "cbpg_2_xs_c:cc25", "cbpg_2_xs_z:zq25", "cbpg_2_xs_m:mq25",
			"cbpg_1_xs_c:cc26", "cbpg_1_xs_z:zq26", "cbpg_1_xs_m:mq26", "cbpg_0_xs_c:cc27",
			"cbpg_0_xs_z:zq27", "cbpg_0_xs_m:mq27"  };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "" };
	String HValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#humanReadToStore(java.lang.String)
	 */
	void con_hvalue2svalue(String humanReadValue) {
		SValues[0] = humanReadValue.substring(0, 1);
		SValues[1] = humanReadValue.substring(1, 2);
		SValues[2] = humanReadValue.substring(2, 3);
		SValues[3] = humanReadValue.substring(3, 4);
		SValues[4] = humanReadValue.substring(4, 5);
		SValues[5] = humanReadValue.substring(5, 6);
		SValues[6] = humanReadValue.substring(6, 7);
		SValues[7] = humanReadValue.substring(7, 8);
		SValues[8] = humanReadValue.substring(8, 9);
		top();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see coboo.model.table.metaData#storeToHumanRead(java.lang.String[])
	 */
	void con_svalue2hvalue(String[] storeValueList) {
		HValue = storeValueList[0] + storeValueList[1] + storeValueList[2]
				+ storeValueList[3] + storeValueList[4] + storeValueList[5]
				+ storeValueList[6] + storeValueList[7] + storeValueList[8];
		top();
		return;
	}

	public WashMeta() {
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