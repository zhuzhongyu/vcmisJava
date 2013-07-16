 package coboo.impl.DocDriver.meta;

/**
 * 前囟 
 * HR51_02_009_1,HR51_02_009_2,HR51_02_009_3,HR51_02_009_4
 * @author 任笑言
 * 
 */
public class SinciputMeta extends Meta {
	public String metaname = "  前囟";
	String[] SIds = new String[] { "sstz9:HR51_02_009_1", "sstz10:HR51_02_009_2",
			"sstz11:HR51_02_009_3", "sstz12:HR51_02_009_4"  };
	String[] SValues = new String[] { "", "", "", "" };
	String HValue;

	void con_hvalue2svalue(String humanReadValue) {
		String readValueList[] = new String[4];
		readValueList = humanReadValue.split("/");
		SValues[0] = readValueList[0];
		SValues[1] = readValueList[1];
		if (readValueList[2].equals("") && readValueList[3].equals("正常")) {
			SValues[2] = "";
			SValues[3] = "1";
		} else {
			SValues[2] = readValueList[2];
			if (readValueList[3].equals("膨隆")) {
				SValues[3] = "2";
			} else if (readValueList[3].equals("凹陷")) {
				SValues[3] = "3";
			} else if (readValueList[3].equals("其他")) {
				SValues[3] = "4";
			}
		}
		top();
		return;
	}

	void con_svalue2hvalue(String[] storeValueList) {
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String form = "";
		line1 = storeValueList[0];
		line2 = storeValueList[1];
		if (storeValueList[2].equals("") && storeValueList[3].equals("1")) {
			line3 = "";
			form = "正常";
		} else {
			line3 = storeValueList[2];
			if (storeValueList[3].equals("2")) {
				form = "膨隆";
			} else if (storeValueList[3].equals("3")) {
				form = "凹陷";
			} else if (storeValueList[3].equals("4")) {
				form = "其他";
			}
		}
		HValue = line1 + "/" + line2 + "/" + line3 + "/" + form;
		top();
		return;
	}

	public SinciputMeta() {
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
