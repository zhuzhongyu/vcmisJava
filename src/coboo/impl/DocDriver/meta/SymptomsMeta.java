 package coboo.impl.DocDriver.meta;

/**
 * 症状
 * "cbtjbzz02", "cbtjbzz03", "cbtjbzz04","cbtjbzz05", 
 * "cbtjbzz06", "cbtjbzz07", "cbtjbzz08", "cbtjbzz09",
 * "cbtjbzz10", "cbtjbzz11", "cbtjbzz01"
 */
public class SymptomsMeta extends Meta {
	public String metaname = "症状";
	String[] SIds = new String[] { "zz:cbtjbzz01", "zz1:cbtjbzz02", "zz2:cbtjbzz03",
			"zz3:cbtjbzz04", "zz4:cbtjbzz05", "zz5:cbtjbzz06", "zz6:cbtjbzz07", "zz7:cbtjbzz08",
			"zz8:cbtjbzz09", "zz9:cbtjbzz10", "zz10:cbtjbzz11" };
	String[] SValues = new String[] { "", "", "", "", "", "", "", "", "", "",
			"" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		boolean flag = false;
		String[] readValueList = new String[11];
		readValueList = humanReadValue.split("/");
		for (int i = 0; i < (readValueList.length - 1); i++) {
			SValues[i] = readValueList[i];
			if (readValueList[i].equals("25")) {
				flag = true;
			}
		}
		if (flag) {
			SValues[10] = readValueList[10];
		} else {
			SValues[10] = "";
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = "";

		for (int i = 0; i < (storeValueList.length - 1); i++) {
			HValue += storeValueList[i] + "/";
		}
		HValue += storeValueList[10];
		top();
		return;
	}

	public SymptomsMeta() {
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