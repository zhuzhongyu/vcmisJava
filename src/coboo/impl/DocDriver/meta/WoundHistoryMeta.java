 package coboo.impl.DocDriver.meta;

/**
 * 既往史-外伤
 * HR51_01_006_21,HR51_01_006_22,HR51_01_006_23,HR51_01_006_24,cbws
 * 
 * @author 任笑言
 */
public class WoundHistoryMeta extends Meta {

	public String metaname = "既往史-外伤";
	String[] SIds = new String[] { "ws_name_1:HR51_01_006_21", "wstime1:ws_time_1:HR51_01_006_22",
			"ws_name_2:HR51_01_006_23", "wstime2:ws_time_2:HR51_01_006_24", "cbws:ws:cbws" };
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[5];
		readValueList = humanReadValue.split("/");
		if (readValueList[4].equals("无")) {
			SValues[4] = "1";
		} else {
			SValues[0] = readValueList[0];
			SValues[1] = readValueList[1];
			SValues[2] = readValueList[2];
			SValues[3] = readValueList[3];
			SValues[4] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		if (SValues[4].equals("1")) {
			HValue = "无";
		} else {
			HValue = SValues[0] + "/" + SValues[1] + "/" + SValues[2] + "/"
					+ SValues[3] + "/" + "有";
		}
		top();
		return;
	}

	public WoundHistoryMeta() {
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
