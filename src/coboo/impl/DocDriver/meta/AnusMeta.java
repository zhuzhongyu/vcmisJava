package coboo.impl.DocDriver.meta;

/**
 * 肛门 对应字段 HR51_02_191_02_1,HR51_02_191_02_2
 * 
 * @author 任笑言
 * 
 */
public class AnusMeta extends Meta {
	public String metaname = "肛门";
	String[] SIds = new String[] {"jy15:HR51_02_191_02_1", "jy16:HR51_02_191_02_2"};
	String[] SValues = new String[] { "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[4];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("") && readValueList[0].equals("未见异常")) {
			SValues[0] = "";
			SValues[1] = "1";
		} else {
			SValues[0] = readValueList[0];
			SValues[1] = "2";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String line = "";
		String form = "";
		if (storeValueList[0].equals("") && storeValueList[1].equals("1")) {
			line = "";
			form = "未见异常";
		} else {
			line = storeValueList[0];
			form = "异常";
		}
		HValue = line + "/" + form;
		top();
		return;
	}

	public AnusMeta() {
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