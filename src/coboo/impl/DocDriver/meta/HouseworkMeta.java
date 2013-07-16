package coboo.impl.DocDriver.meta;

/**
 * 社会功能情况--家务劳动 HR55_01_040_02
 */
public class HouseworkMeta extends Meta {
	String metaname = "做家务";
	String[] SIds = new String[] {"cbpg_2_zjw_c:cc34", "cbpg_2_zjw_z:zq34",
			"cbpg_2_zjw_m:mq34", "cbpg_1_zjw_c:cc35", "cbpg_1_zjw_z:zq35", "cbpg_1_zjw_m:mq35",
			"cbpg_0_zjw_c:cc36", "cbpg_0_zjw_z:zq36", "cbpg_0_zjw_m:mq36"  };
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

	public HouseworkMeta() {
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