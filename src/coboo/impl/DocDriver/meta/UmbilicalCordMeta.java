 package coboo.impl.DocDriver.meta;

/**
 * 脐带 
 * CV5502_03_05_1,CV5502_03_05_2
 * @author 任笑言
 * 
 */
public class UmbilicalCordMeta extends Meta {
	public String metaname = " 脐带";
	String[] SIds = new String[] {"jy25:CV5502_03_05_1", "jy26:CV5502_03_05_2" };
	String[] SValues = new String[] { "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[4];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("")) {
			SValues[0] = "";
			if (readValueList[1].equals("未脱")) {
				SValues[1] = "1";
			} else if (readValueList[1].equals("脱落")) {
				SValues[1] = "2";
			} else if (readValueList[1].equals("胸部有渗出")) {
				SValues[1] = "2";
			}

		} else {
			SValues[0] = readValueList[0];
			SValues[1] = "4";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String line = "";
		String form = "";
		if (storeValueList[0].equals("")) {
			if (storeValueList[1].equals("1")) {
				form = "未脱";
			} else if (storeValueList[1].equals("2")) {
				form = "脱落";
			} else if (storeValueList[1].equals("3")) {
				form = "胸部有渗出";
			}
		} else {
			line = storeValueList[0];
			form = "其他";
		}
		HValue = line + "/" + form;
		top();
		return;
	}

	public UmbilicalCordMeta() {
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