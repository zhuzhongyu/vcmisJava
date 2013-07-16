package coboo.impl.DocDriver.meta;

/**
 * 肢残原因 对应字段 cbxldjyy_xt, cbxldjyy_jb, cbxldjyy_ywsh, cbxldjyy_zd, cbxldjyy_qt
 * 
 * @author 任笑言
 */
public class DisCauseMeta extends Meta {
	public String metaname = "肢残原因";
	String[] SIds = new String[] { "cbxldjyy_xt:xt", "cbxldjyy_jb:jb",
			"cbxldjyy_ywsh:ywsh", "cbxldjyy_zd:zd", "cbxldjyy_qt:qt1"};
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[5];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		SValues[2] = readValueList[2];
		SValues[3] = readValueList[3];
		SValues[4] = readValueList[4];
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "先天/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "疾病/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "意外伤害/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "中毒/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "其他/";
		}
		top();
		return;
	}

	public DisCauseMeta() {
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