package coboo.impl.DocDriver.meta;

public class CorClinical extends Meta {
	String metaname = "并发临床情况";
	String[] SIds = new String[] { "mxxlsj:HR51_99_003_01_1", "nxgjb:R51_99_003_01_2",
			"szjb:R51_99_003_01_3", "wzxgjb:R51_99_003_01_4", "tnb:R51_99_003_01_5"};
	String[] SValues = new String[] { "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String[] readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {
			String value = readValueList[i];
			if (value.equals("慢性心力衰竭")) {
				SValues[0] = "true";
			} else if (value.equals("脑血管疾病")) {
				SValues[1] = "true";
			} else if (value.equals("肾脏疾病")) {
				SValues[2] = "true";
			} else if (value.equals("外周血管疾病")) {
				SValues[3] = "true";
			} else if (value.equals("糖尿病")) {
				SValues[4] = "true";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "慢性心力衰竭/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "脑血管疾病/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "肾脏疾病/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "外周血管疾病/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "糖尿病/";
		}

		top();
		return;
	}

	public CorClinical() {
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
