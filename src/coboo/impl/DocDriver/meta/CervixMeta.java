package coboo.impl.DocDriver.meta;

/**
 * 检查内容--宫颈
 */
public class CervixMeta extends Meta {
	public String metaname = "检查内容--宫颈";
	String[] SIds = new String[] {"gj1:HR51_02_059_01", "gj2:HR51_02_059_02",
			"gj3:HR51_02_059_03", "gj4:HR51_02_059_04", "gj5:HR51_02_059_05",
			"gj6:HR51_02_059_06", "gj7:HR51_02_059_07", "gj8:HR51_02_059_08"};
	String[] SValues = new String[] { "", "", "", "", "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {

		String[] readValueList = humanReadValue.split("/");
		for (int i = 0; i < readValueList.length; i++) {
			String value = readValueList[i];
			if (value.equals("光滑")) {
				SValues[0] = "true";
			} else if (value.equals("肥大")) {
				SValues[1] = "true";
			} else if (value.equals("轻糜")) {
				SValues[2] = "true";
			} else if (value.equals("中糜")) {
				SValues[3] = "true";
			} else if (value.equals("重糜")) {
				SValues[4] = "true";
			} else if (value.equals("纳氏囊肿")) {
				SValues[5] = "true";
			} else if (value.equals("息肉")) {
				SValues[6] = "true";
			} else if (value.equals("宫颈癌")) {
				SValues[7] = "true";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {

		HValue = "";
		if (storeValueList[0].equals("true")) {
			HValue += "光滑/";
		}
		if (storeValueList[1].equals("true")) {
			HValue += "肥大/";
		}
		if (storeValueList[2].equals("true")) {
			HValue += "轻糜/";
		}
		if (storeValueList[3].equals("true")) {
			HValue += "中糜/";
		}
		if (storeValueList[4].equals("true")) {
			HValue += "重糜/";
		}
		if (storeValueList[5].equals("true")) {
			HValue += "纳氏囊肿/";
		}
		if (storeValueList[6].equals("true")) {
			HValue += "息肉/";
		}
		if (storeValueList[7].equals("true")) {
			HValue += "宫颈癌/";
		}
		top();
		return;
	}

	public CervixMeta() {
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