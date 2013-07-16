 package coboo.impl.DocDriver.meta;

/**
 * 脏器功能--口腔 oral
 * HR51_02_178,HR51_02_179_1,HR51_02_179_2,HR51_02_179_3,HR51_02_179_4,
 * HR51_02_179_1_5,HR51_02_179_6,HR51_02_179_7,HR51_02_179_8,HR51_02_179_9,
 * HR51_02_179_10,HR51_02_179_11,HR51_02_179_12,HR51_02_179,HR51_02_030
 */
public class OralMeta extends Meta {
	public String metaname = "脏器功能--口腔";
	String[] SIds = new String[] { "kq1:HR51_02_178","s1:HR51_02_179_1","s2:HR51_02_179_2","s3:HR51_02_179_3","s4:HR51_02_179_4","s5:HR51_02_179_1_5","s6:HR51_02_179_6","s7:HR51_02_179_7","s8:HR51_02_179_8","s9:HR51_02_179_9","10:HR51_02_179_10","s11:HR51_02_179_11","s12:HR51_02_179_12", "kq3:HR51_02_179",
			"kq2:HR51_02_030", };
	String[] SValues = new String[] {"","","","","","","","","","","","","","","" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = new String[15];
		readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {
			SValues[i] = readValueList[i];
		}

		if (readValueList[13].equals("1")) {
			for (int i = 1; i < readValueList.length - 2; i++) {
				SValues[i] = "";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		HValue = "";
		for (int i = 0; i < storeValueList.length; i++) {
			if (i < (storeValueList.length - 1)) {
				HValue += storeValueList[i] + "/";
			} else {
				HValue += storeValueList[i];
			}
		}
		top();
		return;
	}

	public OralMeta() {
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
