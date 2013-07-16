 package coboo.impl.DocDriver.meta;

/**
 * 出生情况  
 * cbcsqk1，cbcsqk0，cbcsqk2
 * 
 * @author 任笑言
 * 
 */
public class WasBornSituationMeta extends Meta {
	public String metaname = " 出生情况";
	String[] SIds = new String[] { "cbcsqk1", "cbcsqk0", "cbcsqk2" };
	String[] SValues = new String[] { "","","" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[3];
		readValueList = humanReadValue.split("/");
		if (readValueList[0].equals("") && readValueList[1].equals("顺产")
				&& readValueList[2].equals("")) {
			SValues[0] = "";
			SValues[1] = "1";
			SValues[2] = "";
		} else {
			SValues[0] = readValueList[0];

			if (readValueList[1].equals("头吸")) {
				SValues[1] = "2";
			} else if (readValueList[1].equals("产钳")) {
				SValues[1] = "3";
			} else if (readValueList[1].equals("剖宫")) {
				SValues[1] = "4";
			} else if (readValueList[1].equals("双胞胎")) {
				SValues[1] = "5";
			} else if (readValueList[1].equals("臀位")) {
				SValues[1] = "6";
			} else if (readValueList[1].equals("其他")) {
				SValues[1] = "7";
			}

			if (readValueList[2].equals("头吸")) {
				SValues[2] = "2";
			} else if (readValueList[2].equals("产钳")) {
				SValues[2] = "3";
			} else if (readValueList[2].equals("剖宫")) {
				SValues[2] = "4";
			} else if (readValueList[2].equals("双胞胎")) {
				SValues[2] = "5";
			} else if (readValueList[2].equals("臀位")) {
				SValues[2] = "6";
			} else if (readValueList[2].equals("其他")) {
				SValues[2] = "7";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String line = "";
		String form1 = "";
		String form2 = "";
		if (storeValueList[0].equals("") && storeValueList[1].equals("1")
				&& storeValueList[2].equals("")) {
			line = "";
			form1 = "顺产";
			form2 = "";
		} else {

			line = storeValueList[0];

			if (storeValueList[1].equals("2")) {
				form1 = "头吸";
			} else if (storeValueList[1].equals("3")) {
				form1 = "产钳";
			} else if (storeValueList[1].equals("4")) {
				form1 = "剖宫";
			} else if (storeValueList[1].equals("5")) {
				form1 = "双胞胎";
			} else if (storeValueList[1].equals("6")) {
				form1 = "臀位";
			} else if (storeValueList[1].equals("7")) {
				form1 = "其他";
			}

			if (storeValueList[2].equals("2")) {
				form2 = "头吸";
			} else if (storeValueList[2].equals("3")) {
				form2 = "产钳";
			} else if (storeValueList[2].equals("4")) {
				form2 = "剖宫";
			} else if (storeValueList[2].equals("5")) {
				form2 = "双胞胎";
			} else if (storeValueList[2].equals("6")) {
				form2 = "臀位";
			} else if (storeValueList[2].equals("7")) {
				form2 = "其他";
			}

		}
		HValue = line + "/" + form1 + "/" + form2;
		top();
		return;
	}

	public WasBornSituationMeta() {
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