package coboo.impl.DocDriver.meta;

/**
 * 药物不良反应 cbywblfy_01 cbywblfy_02
 */
public class DrugAdverseReactionsMeta extends Meta {
	public String metaname = "药物不良反应";
	String[] SIds = new String[] { "ywfy01:cbywblfy_01", "ywfy02"  };
	String[] SValues = new String[] { "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = new String[2];
		readValueList = humanReadValue.split("/");
		if (readValueList[1].equals("无")) {
			SValues[0] = "";
			SValues[1] = "1";
		} else if(readValueList[1].equals("有")){
			SValues[0] = readValueList[0];
			SValues[1] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (storeValueList[1].equals("1")) {
			HValue = "无";
		} else {
			HValue = "有" + "/" + storeValueList[0];
		}
		top();
		return;
	}

	public DrugAdverseReactionsMeta() {
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